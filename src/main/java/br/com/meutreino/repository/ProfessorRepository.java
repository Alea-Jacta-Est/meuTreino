package br.com.meutreino.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.meutreino.domain.Professor;

public interface ProfessorRepository extends CrudRepository<Professor, Long> {

}
