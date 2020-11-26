package br.com.stefanini.maratonadev.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import br.com.stefanini.maratonadev.model.dominio.StatusEnum;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name="contrato")
public class Contrato extends PanacheEntityBase{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "data_ativacao", updatable = false)
	@CreationTimestamp
	private LocalDateTime dataAtivacao;
	
	@Column(name = "data_desativacao", nullable = true, updatable=true)
	private LocalDateTime dataDesativacao;
	
	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	private StatusEnum status;
	
	@ManyToOne(optional=false)
	@JoinColumn(name = "cliente_id", updatable=false, nullable = false)
	private Cliente cliente;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="carro_placa", updatable=false, nullable = false)
	private Carro carro;

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
