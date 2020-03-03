package br.com.meutreino.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.meutreino.domain.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	public List<Aluno> findByNomeIgnoreCaseContaining(String nome);
	public Optional<Aluno> findByEmailIgnoreCase(String email);
}
