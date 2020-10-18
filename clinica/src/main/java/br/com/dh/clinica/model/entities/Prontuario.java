package br.com.dh.clinica.model.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="prontuarios")
public class Prontuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_consulta;
	
	@Column
	private Date dataConsulta;
	
	@Column
	private String fk_id_paciente;
	
	public Prontuario () {};
	
	public Prontuario(Date dataConsulta, String cpf_paciente) {
		this.dataConsulta = dataConsulta;
		this.setFk_id_paciente(cpf_paciente);
	}
	
	@OneToOne
	@JoinColumn(name="cpf")
	private Paciente paciente;
	
	public Date getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}


	public String getFk_id_paciente() {
		return fk_id_paciente;
	}

	public void setFk_id_paciente(String fk_id_paciente) {
		this.fk_id_paciente = fk_id_paciente;
	}

	public Integer getId_consulta() {
		return id_consulta;
	}

	public void setId_consulta(Integer id_consulta) {
		this.id_consulta = id_consulta;
	}

}
