package br.com.dh.clinica.model.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	@OneToOne
    @JoinColumn(name="fk_id_paciente")
	private Paciente paciente;
	private LocalDate data;
	private float valor;
	private String descricao;
	@OneToOne
    @JoinColumn(name="fk_id_medico")
	private Medico medico;
	
	
	
}
