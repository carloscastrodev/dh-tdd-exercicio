package br.com.dh.clinica.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.dh.clinica.model.entities.Prontuario;

@Repository
public interface ProntuarioRepository extends CrudRepository<Prontuario, Integer>{
	
	@Query(value="select p from Prontuario p where p.fk_id_paciente = :cpf_paciente")
	public List<Prontuario> getProntuariosByPaciente(@Param("cpf_paciente") String cpf_paciente);
	
	

}
