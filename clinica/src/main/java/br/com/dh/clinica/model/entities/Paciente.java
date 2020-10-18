package br.com.dh.clinica.model.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Table (name = "paciente")
public class Paciente {
	@Id
	private String cpf;
	
	@Column
	private String nome;
	
	@Column
	private Date dataNascimento;
	
	@Column
	private String telefone;
	
	@Column
	private Date dataPrimeiraConsulta;
	
	@Column
	private String email;
	
	@Column
	private Integer peso;
	
	@Column
	private Double altura;
	
	@OneToOne
	@JoinColumn(name="fk_id_paciente")
	private Endereco endereco;
	
	public Paciente () {}
	
	public Paciente(String cpf, String nome, Date dataNascimento, String telefone, Date dataPrimeiraConsulta,
			String email, Integer peso, Double altura, Endereco endereco) {
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.dataPrimeiraConsulta = dataPrimeiraConsulta;
		this.email = email;
		this.peso = peso;
		this.altura = altura;
		this.endereco = endereco;
	};

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataPrimeiraConsulta() {
		return dataPrimeiraConsulta;
	}

	public void setDataPrimeiraConsulta(Date dataPrimeiraConsulta) {
		this.dataPrimeiraConsulta = dataPrimeiraConsulta;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	
	

}
