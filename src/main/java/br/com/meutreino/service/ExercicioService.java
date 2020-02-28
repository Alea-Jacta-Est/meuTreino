package br.com.meutreino.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meutreino.domain.Exercicio;
import br.com.meutreino.repository.ExercicioRepository;

@Service
public class ExercicioService {

	@Autowired
	ExercicioRepository repository;
	
	public Exercicio inserir(Exercicio exercicio) {
		
		exercicio.setDataCadastro(LocalDate.now());
		
		return repository.save(exercicio);
	}
}
