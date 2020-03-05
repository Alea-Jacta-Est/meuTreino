package br.com.meutreino.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meutreino.domain.AulaExercicio;
import br.com.meutreino.repository.AulaExercicioRepository;

@Service
public class AulaExercicioService {
	
	private static final String MENSAGEM_REGISTRO_EXCLUIDO = "{\"mensagem\": \"Registro excluído!\" }";

	@Autowired
	AulaExercicioRepository repository;
		
	public AulaExercicio inserir(AulaExercicio aulaExercicio) {
		return repository.save(aulaExercicio);
	}	
	
	public AulaExercicio atualizar(AulaExercicio aulaExercicio) {
		return repository.save(aulaExercicio);
	}
	
	public List<AulaExercicio> consultarTodos(){
		return repository.findAll();
	}	

	public String deletar(Long id) {
		this.repository.deleteById(id);
		return MENSAGEM_REGISTRO_EXCLUIDO;
	}
}
