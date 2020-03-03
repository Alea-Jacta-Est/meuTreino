package br.com.meutreino.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.meutreino.domain.PlanejamentoAula;

public interface PlanejamentoAulaRepository extends JpaRepository<PlanejamentoAula, Long> {
	public List<PlanejamentoAula> findByIdProfessor(Long id);
}
