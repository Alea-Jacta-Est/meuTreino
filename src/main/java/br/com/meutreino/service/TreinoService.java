package br.com.meutreino.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meutreino.domain.Treino;
import br.com.meutreino.repository.TreinoRepository;

@Service
public class TreinoService {
	
	private static final String MENSAGEM_REGISTRO_EXCLUIDO = "{\"mensagem\": \"Registro excluído!\" }";

	@Autowired
	TreinoRepository repository;
		
	public Treino inserir(Treino treino) {
		return repository.save(treino);
	}	
	
	public Treino atualizar(Treino treino) {
		return repository.save(treino);
	}
	
	public List<Treino> consultarTodos(){
		return repository.findAll();
	}
	
	public Optional<Treino> consultarUm(Long id) {
		return repository.findByIdTreino(id);
	}
	
	public List<Treino> consultarPorAluno(Long id){
		return repository.findByIdAluno(id);
	}
	
	public String deletar(Treino treino) {
		this.repository.deleteByIdTreinoAndIdAlunoAndIdPlanejamento(treino.getIdTreino(), treino.getIdAluno(), treino.getIdPlanejamento());
		return MENSAGEM_REGISTRO_EXCLUIDO;
	}
}
