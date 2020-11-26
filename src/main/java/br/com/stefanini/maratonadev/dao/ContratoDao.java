package br.com.stefanini.maratonadev.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;

import br.com.stefanini.maratonadev.model.Contrato;
import br.com.stefanini.maratonadev.model.dominio.StatusEnum;

@RequestScoped
public class ContratoDao {

	@Transactional
	public Long ativarContrato(Contrato contrato) {		
		contrato.persistAndFlush();
		return contrato.getId();
	}
	
	public List<Contrato> listarContratosAtivos(){
		return Contrato.list("status = ?1", StatusEnum.ATIVADO);
	}
}
