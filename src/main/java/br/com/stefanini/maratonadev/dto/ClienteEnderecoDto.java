package br.com.stefanini.maratonadev.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class ClienteEnderecoDto {
	
	private Long id;
	
	@NotNull(message = "Nome é Obrigatorio")
	@NotBlank(message = "Não é permito nome vazio")
	@Length(min = 3, max = 100)
	private String nome;
	
	@NotNull(message = "CPF é Obrigatorio")
	@NotBlank(message = "Não é permito CPF vazio")
	@Length(min = 11, max = 11)
	private String cpf;
	
	
	private String email;
	
	@NotNull(message = "Contato é Obrigatorio")
	@NotBlank(message = "Não é permitido contato vazio")
	@Length(min=10, max = 11)
	private String contato;
	
	@NotNull(message = "Cep é Obrigatorio")
	@NotBlank(message = "Não é permito cep vazio")
	@Length(min=8, max = 8)
	private String cep;
	
	@NotNull(message = "Logradouro é Obrigatorio")
	@NotBlank(message = "Não é permito logradouro vazio")
	private String logradouro;
	
	
	private String complemento;
	
	@NotNull(message = "Bairro é Obrigatorio")
	@NotBlank(message = "Não é permito bairro vazio")
	private String bairro;
	
	@NotNull(message = "Cidade é Obrigatoria")
	@NotBlank(message = "Não é permito cidade vazia")
	private String cidade;
	
	@NotNull(message = "UF é Obrigatoria")
	@NotBlank(message = "Não é permito uf vazia")
	@Length(max = 2)
	private String uf;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	
	
}
