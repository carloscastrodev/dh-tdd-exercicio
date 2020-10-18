package br.com.dh.clinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dh.clinica.model.entity.Consulta;
import br.com.dh.clinica.model.service.ConsultaService;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

	@Autowired
	private ConsultaService consultaService;
	
	@GetMapping
	public ResponseEntity<?> listaConsultas() {
		return ResponseEntity.ok().body(consultaService.listarConsultas());		
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<?> getConsultaByCodigo(@PathVariable("codigo") Integer codigo) {
		Consulta consulta = consultaService.getConsultaByCodigo(codigo);
		
		return (consulta == null) ? ResponseEntity.notFound().build() :
			ResponseEntity.ok().body(consulta);
	}
	
	@PostMapping
	public ResponseEntity<?> cadastrarConsulta(@RequestBody Consulta consulta) {
		Consulta consultaCadastrada = consultaService.cadastrarConsulta(consulta);		
		return ResponseEntity.status(HttpStatus.CREATED).body(consultaCadastrada);
	}
	
	@DeleteMapping("/{codigo}")
	public ResponseEntity<?> deletarByCodigo(@PathVariable("codigo") Integer codigo) {
		consultaService.deletarConsulta(codigo);
		return ResponseEntity.ok().build();
	}
	

	
	
	
}
