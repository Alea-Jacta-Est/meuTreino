package br.com.meutreino.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meutreino.domain.TreinoAgenda;
import br.com.meutreino.repository.TreinoAgendaRepository;

@Service
public class TreinoAgendaService {	

	@Autowired
	TreinoAgendaRepository repository;
		
	public TreinoAgenda inserir(TreinoAgenda treinoAgenda) {
		return repository.save(treinoAgenda);
	}	

	
	public List<TreinoAgenda> consultarTodos(){
		return repository.findAll();
	}
	
}
