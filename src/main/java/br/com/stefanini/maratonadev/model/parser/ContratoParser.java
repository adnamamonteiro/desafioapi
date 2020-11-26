package br.com.stefanini.maratonadev.model.parser;

import br.com.stefanini.maratonadev.dto.ContratoDto;
import br.com.stefanini.maratonadev.model.Contrato;

public class ContratoParser {

	public static ContratoParser get() {
		return new ContratoParser();
	}

	public ContratoDto dto(Contrato entidade) {
		
		ContratoDto dto = new ContratoDto();
		
		dto.setId(entidade.getId());
		dto.setNomeCliente(entidade.getCliente().getNome());
		dto.setCpf(entidade.getCliente().getCpf());
		dto.setPlaca(entidade.getCarro().getPlaca());
		dto.setModeloCarro(entidade.getCarro().getModelo());
		dto.setStatus(entidade.getStatus());
		dto.setDataAtivacao(entidade.getDataAtivacao());
		dto.setDataDesativacao(entidade.getDataDesativacao());
		
		return dto;
	}
}
