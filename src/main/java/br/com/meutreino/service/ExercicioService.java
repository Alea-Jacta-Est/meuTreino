package br.com.meutreino.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meutreino.domain.Exercicio;
import br.com.meutreino.repository.ExercicioRepository;

@Service
public class ExercicioService {
	
	private static final String MENSAGEM_REGISTRO_EXCLUIDO = "{\"mensagem\": \"Registro excluído!\" }";

	@Autowired
	ExercicioRepository repository;
	
	public Exercicio inserir(Exercicio exercicio) {
		
		exercicio.setDataCadastro(LocalDate.now());
		
		return repository.save(exercicio);
	}
	
	public Exercicio atualizar(Exercicio exercicio) {
		return repository.save(exercicio);
	}
	
	public List<Exercicio> consultarTodos(){
		return repository.findAll();
	}
	
	public Optional<Exercicio> consultarUm(Long id) {
		return repository.findById(id);
	}
	
	public List<Exercicio> consultarPorNome(String nome){
		return repository.findByNomeIgnoreCaseContaining(nome);
	}
	
	public String deletar(Long id) {
		this.repository.deleteById(id);
		return MENSAGEM_REGISTRO_EXCLUIDO;
	}
}
