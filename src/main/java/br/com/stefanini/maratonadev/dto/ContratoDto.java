package br.com.stefanini.maratonadev.dto;

import java.time.LocalDateTime;

import javax.json.bind.annotation.JsonbDateFormat;

import br.com.stefanini.maratonadev.model.dominio.StatusEnum;

public class ContratoDto {

	private Long id;
	
	private String nomeCliente;
	
	private String cpf;
	
	private String placa;

	private String modeloCarro;
	
	private StatusEnum status;
	
	@JsonbDateFormat("dd/MM/yyyy HH:mm")
	private LocalDateTime dataAtivacao;
	
	@JsonbDateFormat("dd/MM/yyyy HH:mm")
	private LocalDateTime dataDesativacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModeloCarro() {
		return modeloCarro;
	}

	public void setModeloCarro(String modeloCarro) {
		this.modeloCarro = modeloCarro;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public LocalDateTime getDataAtivacao() {
		return dataAtivacao;
	}

	public void setDataAtivacao(LocalDateTime dataAtivacao) {
		this.dataAtivacao = dataAtivacao;
	}

	public LocalDateTime getDataDesativacao() {
		return dataDesativacao;
	}

	public void setDataDesativacao(LocalDateTime dataDesativacao) {
		this.dataDesativacao = dataDesativacao;
	}
	
}
