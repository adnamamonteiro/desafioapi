package br.com.stefanini.maratonadev.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.stefanini.maratonadev.dao.ContratoDao;
import br.com.stefanini.maratonadev.dto.ContratoDto;
import br.com.stefanini.maratonadev.exceptions.CarroIndisponivelExcpetion;
import br.com.stefanini.maratonadev.exceptions.ClienteComContratoAtivoExcpetion;
import br.com.stefanini.maratonadev.exceptions.ClienteNaoCadastradoExcpetion;
import br.com.stefanini.maratonadev.model.Carro;
import br.com.stefanini.maratonadev.model.Cliente;
import br.com.stefanini.maratonadev.model.Contrato;
import br.com.stefanini.maratonadev.model.dominio.StatusEnum;
import br.com.stefanini.maratonadev.model.parser.ContratoParser;

@RequestScoped
public class ContratoService  {
	
	@Inject
	ContratoDao dao;
	
	@Inject
	ClienteService clienteService;
	
	@Inject
	CarroService carroService;
	
	private void validarContrato(Cliente cliente, Carro carro) throws Exception {
		
		if (dao.listarContratosAtivos().stream()
				.anyMatch(c -> c.getCarro().equals(carro))){
	
			throw new CarroIndisponivelExcpetion();
	
		}else if (dao.listarContratosAtivos().stream()
		.anyMatch(c -> c.getCliente().equals(cliente))){
					
			throw new ClienteComContratoAtivoExcpetion();			
		}
	}
	
	private Cliente validarCliente(String cpf) throws ClienteNaoCadastradoExcpetion {
		Cliente cliente  = clienteService.buscarPorCpf(cpf);
		if (cliente == null) {
			throw new ClienteNaoCadastradoExcpetion();
		}else {
			return cliente;
		}
	}
	
	@Transactional(rollbackOn = Exception.class)
	public Long ativarContrato(String cpf , String placa) throws Exception {
		
		Cliente cliente = validarCliente(cpf);
		Carro carro = carroService.buscarPorPlaca(placa);
		validarContrato(cliente, carro);
		
		Contrato contrato = new Contrato();
		contrato.setCliente(cliente);
		contrato.setCarro(carro);
		contrato.setStatus(StatusEnum.ATIVADO);
		return dao.ativarContrato(contrato);
	}
	
	@Transactional(rollbackOn = Exception.class)
	public void desativarContrato(Long id) {
		Contrato.update("status = ?1, dataDesativacao = ?2 where id = ?3",
				StatusEnum.DESATIVADO, LocalDateTime.now(), id);
	}
	
	public List<ContratoDto> listarContratosAtivos(){
		return dao.listarContratosAtivos()
				.stream().map(ContratoParser.get()::dto)
				.collect(Collectors.toList());
	}

}
