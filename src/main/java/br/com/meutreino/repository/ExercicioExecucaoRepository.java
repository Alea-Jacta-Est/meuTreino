package br.com.meutreino.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.meutreino.domain.ExercicioExecucao;
import br.com.meutreino.domain.compositeKey.ExercicioExecucaoCompositeKey;

public interface ExercicioExecucaoRepository extends JpaRepository<ExercicioExecucao, ExercicioExecucaoCompositeKey> {
	@Transactional
	public void deleteByIdExecucaoAndIdExercicioAndIdPlanejamento(Long idExecucao, Long idExercicio, Long idPlanejamento);
}
