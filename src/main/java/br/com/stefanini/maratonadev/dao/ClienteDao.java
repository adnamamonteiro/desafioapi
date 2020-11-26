package br.com.stefanini.maratonadev.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;

import br.com.stefanini.maratonadev.model.Cliente;

@RequestScoped
public class ClienteDao {
	
	@Transactional
	public Long incluir(Cliente cliente) {
		cliente.persistAndFlush();
		return cliente.getId();
	}
	
	public Cliente buscarPorId(Long id){
		Cliente cliente = Cliente.findById(id);
		return cliente;
	}
	
	public Cliente buscarPorCpf(String cpf){
		Cliente cliente = Cliente.find("cpf", cpf).firstResult();
		return cliente;
	}
	
	public List<Cliente> listar(){
		List<Cliente> clientes = Cliente.listAll();
		return clientes;
	}	
}
