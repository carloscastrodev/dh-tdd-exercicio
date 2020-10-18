package br.com.dh.clinica.model.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "consulta")
public class Consulta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column
	private Date data;
	
	@Column
	private Double valor;
	
	@Column
	private String descricao;
	
	@Column
	private String fk_id_paciente;
	
	public Consulta () {};
	
	public Consulta (Date data, Double valor, String descricao, String cpf_paciente) {
		this.setData(data);
		this.setValor(valor);
		this.setDescricao(descricao);
		this.setFk_id_paciente(cpf_paciente);
		
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getFk_id_paciente() {
		return fk_id_paciente;
	}

	public void setFk_id_paciente(String fk_id_paciente) {
		this.fk_id_paciente = fk_id_paciente;
	}
}
