package br.com.stefanini.maratonadev.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.NotFoundException;

import br.com.stefanini.maratonadev.dao.ClienteDao;
import br.com.stefanini.maratonadev.dto.ClienteEnderecoDto;
import br.com.stefanini.maratonadev.dto.ContratoDto;
import br.com.stefanini.maratonadev.exceptions.CpfCadastradoExcpetion;
import br.com.stefanini.maratonadev.model.Cliente;
import br.com.stefanini.maratonadev.model.parser.ClienteEnderecoParser;
import br.com.stefanini.maratonadev.model.parser.ContratoParser;

@RequestScoped
public class ClienteService {
	
	@Inject
	ClienteDao dao;
	
	public Cliente buscarPorId(Long id) {
		Cliente cliente =  dao.buscarPorId(id);
		if (cliente == null) {
			throw new NotFoundException();
		}
		return cliente;
	}
	
	public Cliente buscarPorCpf(String cpf) {
		Cliente cliente = dao.buscarPorCpf(cpf);
		return cliente;
	}
	
	@Transactional(rollbackOn = Exception.class)
	public Long inserir(@Valid ClienteEnderecoDto clienteEndDto) throws CpfCadastradoExcpetion {
		
		if(buscarPorCpf(clienteEndDto.getCpf()) != null) {
			throw new CpfCadastradoExcpetion();
		
		}else {
			Cliente cliente = ClienteEnderecoParser.get().entidadeCliente(clienteEndDto);
			return dao.incluir(cliente);
		}
	}
	
	public List<ClienteEnderecoDto> listarClienteEndereco(){
		List<ClienteEnderecoDto> clientes = new ArrayList<>();
		
		dao.listar().forEach(c -> {
			clientes.add(ClienteEnderecoParser
					.get()
					.dto(c, c.getEndereco()));
		});
		
		return clientes;
	}
	
	public List<ContratoDto> historicoCliente(Long id){
		
		List<ContratoDto> historico = buscarPorId(id).getContratos()
		.stream().map(ContratoParser.get()::dto)
		.collect(Collectors.toList());
		
		return historico;
	}
}
