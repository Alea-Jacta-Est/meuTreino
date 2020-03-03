package br.com.meutreino.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meutreino.domain.PlanejamentoAula;
import br.com.meutreino.repository.PlanejamentoAulaRepository;

@Service
public class PlanejamentoService {
	
	private static final String MENSAGEM_REGISTRO_EXCLUIDO = "{\"mensagem\": \"Registro excluído!\" }";

	@Autowired
	PlanejamentoAulaRepository repository;
		
	public PlanejamentoAula inserir(PlanejamentoAula planejamentoAula) {
		planejamentoAula.setDataCadastro(LocalDate.now());
		return repository.save(planejamentoAula);
	}	
	
	public PlanejamentoAula atualizar(PlanejamentoAula planejamentoAula) {
		return repository.save(planejamentoAula);
	}
	
	public List<PlanejamentoAula> consultarTodos(){
		return repository.findAll();
	}
	
	public Optional<PlanejamentoAula> consultarUm(Long id) {
		return repository.findById(id);
	}
	
	public List<PlanejamentoAula> consultarPorProfessor(Long id){
		return repository.findByIdProfessor(id);
	}
	
	public String deletar(Long id) {
		this.repository.deleteById(id);
		return MENSAGEM_REGISTRO_EXCLUIDO;
	}
}
