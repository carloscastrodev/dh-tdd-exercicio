package br.com.dh.clinica.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.dh.clinica.model.entity.Consulta;
import br.com.dh.clinica.model.entity.Medico;
import br.com.dh.clinica.model.entity.Paciente;
import br.com.dh.clinica.model.service.ConsultaService;

@SpringBootTest
@AutoConfigureMockMvc
class ConsultaControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ConsultaService consultaService;

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
				.valor(52.2f).data(null).descricao("Outra consulta")
				.build();
	}

	@Test
	void getConsulta_shouldReturn_statusOk_andConsultaJsonObject_whenCodigoExists() throws Exception {
		doReturn(consultaMock1).when(consultaService).getConsultaByCodigo(1);
		
		mockMvc.perform(get("/consulta/{codigo}", 1))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.descricao", is("Alguma consulta")))
			.andExpect(jsonPath("$.data", is(LocalDate.now().toString())))
			.andExpect(jsonPath("$.valor", is(32.2)))
			.andExpect(jsonPath("$.codigo", is(32)));
	}
	
	@Test
	void getConsulta_shouldReturn_statusNotFound_whenConsultaCodigoDoesNotExists() throws Exception{
		doReturn(null).when(consultaService).getConsultaByCodigo(1);
		mockMvc.perform(get("/consulta/{codigo}", 1))
			.andExpect(status().isNotFound());
	}
	
	@Test
	void cadastrarConsulta_shouldReturn_statusCreated_andReturn_consultaJsonObject() throws Exception {
		doReturn(consultaMock2).when(consultaService).cadastrarConsulta(any());

        mockMvc.perform(post("/consulta")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectToJsonString(consultaMock2)))
        		.andExpect(status().isCreated())
        		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
    			.andExpect(jsonPath("$.descricao", is("Outra consulta")))
    			.andExpect(jsonPath("$.valor", is(52.2)))
    			.andExpect(jsonPath("$.codigo", is(52)));
	}
	
	@Test
	void listarConsultas_shouldReturn_listOfConsultas() throws Exception {
		List<Consulta> listaConsulta = List.of(consultaMock1, consultaMock2);
		doReturn(listaConsulta).when(consultaService).listarConsultas();
		
		mockMvc.perform(get("/consulta"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(2)))
			
			.andExpect(jsonPath("$[0].descricao", is("Alguma consulta")))
			.andExpect(jsonPath("$[0].data", is(LocalDate.now().toString())))
			.andExpect(jsonPath("$[0].valor", is(32.2)))
			.andExpect(jsonPath("$[0].codigo", is(32)))

			.andExpect(jsonPath("$[1].descricao", is("Outra consulta")))
			.andExpect(jsonPath("$[1].valor", is(52.2)))
			.andExpect(jsonPath("$[1].codigo", is(52)));		
	}
	
	@Test
	void deletarConsulta_shouldDeleteConsulta_whenConsultaExists() throws Exception {
		mockMvc.perform(delete("/consulta/{codigo}", 32))
			.andExpect(status().isOk());
	}
	
	static String objectToJsonString(Object object) {
		try {
			return new ObjectMapper().writeValueAsString(object);
		} catch (Exception e ) {
			throw new RuntimeException();
		}
	}

	
	
}
