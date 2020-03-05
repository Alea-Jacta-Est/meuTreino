package br.com.meutreino.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.meutreino.domain.Treino;
import br.com.meutreino.service.TreinoService;

@RestController
@RequestMapping("/v1/treino")
public class TreinoController {

	@Autowired
	private TreinoService service;

	@PostMapping("/inserir")
	public ResponseEntity<Treino> inserir(@RequestBody Treino treino){
		return new ResponseEntity<Treino>(this.service.inserir(treino), HttpStatus.OK);
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Treino> atualizar(@RequestBody Treino treino){
		return new ResponseEntity<Treino>(this.service.atualizar(treino), HttpStatus.OK);
	}

	@GetMapping("/consultar")
	public ResponseEntity<List<Treino>> consultarTodos() {
		return new ResponseEntity<>(this.service.consultarTodos(), HttpStatus.OK);
	}
	
	@GetMapping("/consultarUm/{id}")
	public ResponseEntity<Optional<Treino>> consultarUm(@PathVariable Long id){
		return new ResponseEntity<>(this.service.consultarUm(id), HttpStatus.OK);
	}
	
	@GetMapping("/consultarAluno/{id}")
	public ResponseEntity<List<Treino>> consultarPorNome(@PathVariable Long id){
		return new ResponseEntity<>(this.service.consultarPorAluno(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/deletar")
	public ResponseEntity<String> deletar(@RequestBody Treino treino){
		return new ResponseEntity<>(this.service.deletar(treino), HttpStatus.OK);
	}

	
}
