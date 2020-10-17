package br.com.dh.clinica.model.service;

import java.util.List;

import br.com.dh.clinica.model.entity.Consulta;

public interface ConsultaService {
	Consulta getConsultaByCodigo(Integer codigo);
	Consulta cadastrarConsulta(Consulta consulta);
	List<Consulta> listarConsultas();
	void deletarConsulta(Integer codigo);
}
