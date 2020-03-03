package br.com.meutreino.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meutreino.domain.Professor;
import br.com.meutreino.repository.ProfessorRepository;


@Service
public class ProfessorService {
	
	private static final String MENSAGEM_REGISTRO_EXCLUIDO = "{\"mensagem\": \"Registro excluído!\" }";

	@Autowired
	ProfessorRepository repository;
		
	public Professor inserir(Professor professor) {
		professor.setDataCadastro(LocalDate.now());
		return repository.save(professor);
	}	
	
	public Professor atualizar(Professor professor) {
		return repository.save(professor);
	}
	
	public List<Professor> consultarTodos(){
		return repository.findAll();
	}
	
	public Optional<Professor> consultarUm(Long id) {
		return repository.findById(id);
	}
	
	public List<Professor> consultarPorNome(String nome){
		return repository.findByNomeIgnoreCaseContaining(nome);
	}
	
	public Optional<Professor> consultarPorEmail(String email){
		return repository.findByEmailIgnoreCase(email);
	}
	
	public String deletar(Long id) {
		this.repository.deleteById(id);
		return MENSAGEM_REGISTRO_EXCLUIDO;
	}
}
