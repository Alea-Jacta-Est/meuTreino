package br.com.meutreino.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meutreino.domain.Aluno;
import br.com.meutreino.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository alunoRepository;
	
	public Iterable<Aluno> getAlunos(){
		
		return alunoRepository.findAll();
	}
	
	public Optional<Aluno> consultarAluno(Aluno aluno) {
		return alunoRepository.findById(aluno.getIdAluno());
	}
	
	public Aluno inserir(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
}
