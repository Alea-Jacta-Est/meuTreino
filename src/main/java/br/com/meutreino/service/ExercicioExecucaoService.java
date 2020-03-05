package br.com.meutreino.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meutreino.domain.ExercicioExecucao;
import br.com.meutreino.repository.ExercicioExecucaoRepository;

@Service
public class ExercicioExecucaoService {

	private static final String MENSAGEM_REGISTRO_EXCLUIDO = "{\"mensagem\": \"Registro excluído!\" }";

	@Autowired
	ExercicioExecucaoRepository repository;

	public ExercicioExecucao inserir(ExercicioExecucao exercicioExecucao) {
		return repository.save(exercicioExecucao);
	}

	public ExercicioExecucao atualizar(ExercicioExecucao exercicioExecucao) {
		return repository.save(exercicioExecucao);
	}

	public List<ExercicioExecucao> consultarTodos() {
		return repository.findAll();
	}

	public String deletar(ExercicioExecucao exercicioExecucao) {
		this.repository.deleteByIdExecucaoAndIdExercicioAndIdPlanejamento(exercicioExecucao.getIdExecucao(),
				exercicioExecucao.getIdExercicio(), exercicioExecucao.getIdPlanejamento());
		return MENSAGEM_REGISTRO_EXCLUIDO;
	}
}
