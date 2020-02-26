package br.com.meutreino.service;

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
}
