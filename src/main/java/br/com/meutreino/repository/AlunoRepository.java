package br.com.meutreino.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.meutreino.domain.Aluno;

public interface AlunoRepository extends CrudRepository<Aluno, Long> {

}
