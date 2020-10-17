package br.com.dh.clinica.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dh.clinica.model.entity.Consulta;
import br.com.dh.clinica.model.repository.ConsultaRepository;

@Service
public class ConsultaServiceImpl implements ConsultaService {

	@Autowired
	private ConsultaRepository consultaRepository;
	
	public Consulta getConsultaByCodigo(Integer codigo) {
		Optional<Consulta> optionalConsulta = consultaRepository.findById(codigo);
		return optionalConsulta.isEmpty() ? null : optionalConsulta.get();
	}
	
	public Consulta cadastrarConsulta(Consulta consulta) {
		return (consulta == null) ? null : consultaRepository.save(consulta);
	}

	@Override
	public List<Consulta> listarConsultas() {
		return consultaRepository.findAll();
	}

	@Override
	public void deletarConsulta(Integer codigo) {		
		consultaRepository.deleteById(codigo);
	}
}
