package br.com.meutreino.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.meutreino.domain.ExercicioExecucao;
import br.com.meutreino.domain.compositeKey.ExercicioExecucaoCompositeKey;

public interface ExercicioExecucaoRepository extends CrudRepository<ExercicioExecucao, ExercicioExecucaoCompositeKey> {

}
