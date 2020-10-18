package br.com.dh.clinica.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "endereco")
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_endereco;
	
	@Column
	private String rua;
	
	@Column
	private Integer numero;
	
	@Column
	private String bairro;
	
	@Column
	private String cidade;
	
	@Column
	private String fk_id_paciente;
	
	@OneToOne
	@JoinColumn(name="cpf")
	private Paciente paciente;
	
	public Endereco () {};
	
	public Endereco(String rua, Integer numero, String bairro, String cidade, String cpf_paciente) {
		this.setRua(rua);
		this.setNumero(numero);
		this.setBairro(bairro);
		this.setCidade(cidade);
		this.setFk_id_paciente(cpf_paciente);
	}

	public Integer getId_endereco() {
		return id_endereco;
	}

	public void setId_endereco(Integer id_endereco) {
		this.id_endereco = id_endereco;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
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

	public String getFk_id_paciente() {
		return fk_id_paciente;
	}

	public void setFk_id_paciente(String fk_id_paciente) {
		this.fk_id_paciente = fk_id_paciente;
	}

}
