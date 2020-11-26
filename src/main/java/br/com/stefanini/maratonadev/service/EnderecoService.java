package br.com.stefanini.maratonadev.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.stefanini.maratonadev.dao.EnderecoDao;
import br.com.stefanini.maratonadev.dto.ClienteEnderecoDto;
import br.com.stefanini.maratonadev.model.Endereco;
import br.com.stefanini.maratonadev.model.parser.ClienteEnderecoParser;

@RequestScoped
public class EnderecoService {
	
	@Inject
	EnderecoDao dao;
	
	@Inject
	ClienteService clienteService;
	
	@Transactional(rollbackOn = Exception.class)
	public void incluir(ClienteEnderecoDto clienteEnderecoDto, Long _id) {
		Endereco end = ClienteEnderecoParser.get()
				.entidadeEndereco(clienteEnderecoDto);
		end.setCliente(clienteService.buscarPorId(_id));
		dao.incluir(end);
	}

}
