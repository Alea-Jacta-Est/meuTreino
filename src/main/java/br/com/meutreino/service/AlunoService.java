package br.com.meutreino.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meutreino.domain.Aluno;
import br.com.meutreino.repository.AlunoRepository;

@Service
public class AlunoService {
	
	private static final String MENSAGEM_REGISTRO_EXCLUIDO = "{\"mensagem\": \"Registro excluído!\" }";

	@Autowired
	AlunoRepository repository;
		
	public Aluno inserir(Aluno aluno) {
		aluno.setDataCadastro(LocalDate.now());
		return repository.save(aluno);
	}	
	
	public Aluno atualizar(Aluno aluno) {
		return repository.save(aluno);
	}
	
	public List<Aluno> consultarTodos(){
		return repository.findAll();
	}
	
	public Optional<Aluno> consultarUm(Long id) {
		return repository.findById(id);
	}
	
	public List<Aluno> consultarPorNome(String nome){
		return repository.findByNomeIgnoreCaseContaining(nome);
	}
	
	public Optional<Aluno> consultarPorEmail(String email){
		return repository.findByEmailIgnoreCase(email);
	}
	
	public String deletar(Long id) {
		this.repository.deleteById(id);
		return MENSAGEM_REGISTRO_EXCLUIDO;
	}
}
