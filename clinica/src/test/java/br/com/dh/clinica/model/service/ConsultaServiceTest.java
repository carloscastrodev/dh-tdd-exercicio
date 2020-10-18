package br.com.dh.clinica.model.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.com.dh.clinica.model.entity.Consulta;
import br.com.dh.clinica.model.entity.Medico;
import br.com.dh.clinica.model.entity.Paciente;
import br.com.dh.clinica.model.repository.ConsultaRepository;

@SpringBootTest
class ConsultaServiceTest {

	@Autowired
	private ConsultaService consultaService;
	@MockBean
	private ConsultaRepository consultaRepository;
	
	private Consulta consultaMock1, consultaMock2;
	
	@BeforeEach
	void setup(){
		consultaMock1 = Consulta
				.builder()
				.codigo(32).medico(Medico.builder().id_medico(1).build())
				.paciente(Paciente.builder().cpf("213f12313123").build())
				.valor(32.2f).data(LocalDate.now()).descricao("Alguma consulta")
				.build();
		
		consultaMock2 = Consulta
				.builder()
				.codigo(52).medico(Medico.builder().id_medico(1).build())
				.paciente(Paciente.builder().cpf("31311").build())
				.valor(52.2f).data(LocalDate.now()).descricao("Outra consulta")
				.build();
	}
	

	@Test
	void consultaServiceInstance_shouldNot_Be_Null() {
		assertNotNull(consultaService);
	}
	
	@Test
	void getConsulta_shouldReturnNull_whenCodigo_doesNotExists() {
		assertEquals(null,  consultaService.getConsultaByCodigo(1));		
	}
	
	@Test
	void cadastrarConsulta_shouldReturnNull_whenConsultaIsNull() {
		assertNull(consultaService.cadastrarConsulta(null));
	}
	
	@Test
	void cadastrarConsulta_shouldReturnTheObject_whenIts_successuful() {
		
		doReturn(consultaMock1).when(consultaRepository).save(any());
		Consulta savedConsulta =  consultaService.cadastrarConsulta(consultaMock1);
		
		assertNotNull(consultaMock1);
		assertEquals(consultaMock1, savedConsulta);
	}	
	
	@Test
	void listarConsulta_shouldReturnAListWithTheCorrectSize_ofConsultas() {
		doReturn(Arrays.asList(new Consulta[] {consultaMock1, consultaMock2}))
		.when(consultaRepository).findAll();
		
		List<Consulta> consultas = consultaService.listarConsultas();
		assertEquals(2, consultas.size());
	}
	
	@Test
	void deletarConsulta_shouldReturnDeletedConsulta_whenCodigoExists() {
		consultaService.deletarConsulta(1);
		verify(consultaRepository, times(1)).deleteById(anyInt());
	}
	

}
