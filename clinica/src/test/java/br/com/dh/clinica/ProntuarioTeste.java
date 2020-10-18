package br.com.dh.clinica;

import java.util.Date;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.dh.clinica.model.entities.Prontuario;
import br.com.dh.clinica.model.repositories.ProntuarioRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProntuarioTeste {
	
	private Prontuario mockProntuario;
	
	@Autowired
	private ProntuarioRepository prontuarioRepository;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setup() {
		this.mockProntuario = new Prontuario(new Date(2020, 10, 15), "123.456.789-21");
		
	}
	
	
	@Test
	public void verificaSeProntuarioEstaSendoSalvo() {
		Prontuario prontuarioSalvo = prontuarioRepository.save(mockProntuario);
		Assertions.assertThat(prontuarioRepository.findById(prontuarioSalvo.getId_consulta())).isNotNull();
	}

	@Test
	public void verificaSeProntuarioNaoTemIdNuloQuandoSalvo() {
		Prontuario prontuarioSalvo = prontuarioRepository.save(mockProntuario);
		Assertions.assertThat(prontuarioSalvo.getId_consulta()).isNotNull();
	}
	
	@Test 
	public void quandoProcuraProntuariosPorPaciente_DeveRetornarListaDeProntuarios() {
		prontuarioRepository.save(mockProntuario);
		Assertions.assertThat(prontuarioRepository.getProntuariosByPaciente(mockProntuario.getFk_id_paciente())).isNotEmpty();
	}

	@Test
	public void 

}
