package br.com.dh.clinica.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "receita")
public class Receita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_receita;
	
	@Column
	private String descricao;
	
	@Column
	private Integer tempo;
	
	@Column
	private String dosagem;
	
	@Column
	private Integer fk_id_consulta;
	
	
	public Receita () {};
	
	public Receita(String descricao, String tempo, String dosagem, Integer id_consulta) {
	}

	public Integer getId_receita() {
		return id_receita;
	}

	public void setId_receita(Integer id_receita) {
		this.id_receita = id_receita;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getTempo() {
		return tempo;
	}

	public void setTempo(Integer tempo) {
		this.tempo = tempo;
	}

	public String getDosagem() {
		return dosagem;
	}

	public void setDosagem(String dosagem) {
		this.dosagem = dosagem;
	}

	public Integer getFk_id_consulta() {
		return fk_id_consulta;
	}

	public void setFk_id_consulta(Integer fk_id_consulta) {
		this.fk_id_consulta = fk_id_consulta;
	}

}
