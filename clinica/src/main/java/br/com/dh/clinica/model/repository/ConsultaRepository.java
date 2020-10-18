package br.com.dh.clinica.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dh.clinica.model.entity.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer>{
	
}
