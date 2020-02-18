package br.com.meutreino.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.meutreino.domain.Exercicio;

public interface ExercicioRepository extends CrudRepository<Exercicio, Long> {

}
