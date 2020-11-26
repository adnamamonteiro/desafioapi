package br.com.stefanini.maratonadev.dao;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;

import br.com.stefanini.maratonadev.model.Endereco;

@RequestScoped
public class EnderecoDao {
	
	@Transactional
	public void incluir(Endereco endereco) {
		endereco.persistAndFlush();
	}
}
