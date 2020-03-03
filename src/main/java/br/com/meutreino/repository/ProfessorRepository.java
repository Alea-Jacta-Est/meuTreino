package br.com.meutreino.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.meutreino.domain.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
	public List<Professor> findByNomeIgnoreCaseContaining(String nome);
	public Optional<Professor> findByEmailIgnoreCase(String email);
}
