package br.com.meutreino.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.meutreino.domain.Exercicio;

public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {

	public List<Exercicio> findByNomeIgnoreCaseContaining(String nome);
}
