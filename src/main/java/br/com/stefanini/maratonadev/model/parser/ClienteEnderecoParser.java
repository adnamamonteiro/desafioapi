package br.com.stefanini.maratonadev.model.parser;

import br.com.stefanini.maratonadev.dto.ClienteEnderecoDto;
import br.com.stefanini.maratonadev.model.Cliente;
import br.com.stefanini.maratonadev.model.Endereco;

public class ClienteEnderecoParser {
	
	public static ClienteEnderecoParser get() {
		return new ClienteEnderecoParser();
	}
	
	public Cliente entidadeCliente(ClienteEnderecoDto dto) {
		Cliente entidade = new Cliente();
		
		entidade.setNome(dto.getNome());
		entidade.setCpf(dto.getCpf());
		entidade.setEmail(dto.getEmail());
		entidade.setContato(dto.getContato());
		
		return entidade;
	}
	
	public Endereco entidadeEndereco(ClienteEnderecoDto dto) {
		Endereco entidade = new Endereco();
	
		entidade.setCep(dto.getCep());
		entidade.setLogradouro(dto.getLogradouro());
		entidade.setComplemento(dto.getComplemento());
		entidade.setBairro(dto.getBairro());
		entidade.setCidade(dto.getCidade());
		entidade.setUf(dto.getUf());
		
		return entidade;
	}
	
	public ClienteEnderecoDto dto(Cliente entidadeCliente, Endereco entidadeEndereco) {
		
		ClienteEnderecoDto dto = new ClienteEnderecoDto();
		
		dto.setId(entidadeCliente.getId());
		dto.setNome(entidadeCliente.getNome());
		dto.setCpf(entidadeCliente.getCpf());
		dto.setEmail(entidadeCliente.getEmail());
		dto.setContato(entidadeCliente.getContato());
		
		dto.setCep(entidadeEndereco.getCep());
		dto.setLogradouro(entidadeEndereco.getLogradouro());
		dto.setComplemento(entidadeEndereco.getComplemento());
		dto.setBairro(entidadeEndereco.getBairro());
		dto.setCidade(entidadeEndereco.getCidade());
		dto.setUf(entidadeEndereco.getUf());
		
		return dto;
	}
}
