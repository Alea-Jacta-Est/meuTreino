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

import br.com.meutreino.domain.Exercicio;
import br.com.meutreino.repository.ExercicioRepository;
import br.com.meutreino.service.ExercicioService;

@RestController
@RequestMapping("/v1/exercicio")
public class ExercicioController {

	@Autowired
	ExercicioRepository repository;

	@Autowired
	ExercicioService service;

	@PostMapping("/inserir")
	public ResponseEntity<Exercicio> inserir(@RequestBody Exercicio exercicio) {
		return new ResponseEntity<>(this.service.inserir(exercicio), HttpStatus.OK);
	}

	@PutMapping("/atualizar")
	public ResponseEntity<Exercicio> atualizar(@RequestBody Exercicio exercicio) {
		return new ResponseEntity<>(this.service.atualizar(exercicio), HttpStatus.OK);
	}

	@GetMapping("/consultar")
	public ResponseEntity<List<Exercicio>> consultarTodos() {
		return new ResponseEntity<>(this.service.consultarTodos(), HttpStatus.OK);
	}

	@GetMapping(value = "/consultarUm/{id}")
	public ResponseEntity<Optional<Exercicio>> consultarUm(@PathVariable Long id) {
		return new ResponseEntity<>(this.service.consultarUm(id), HttpStatus.OK);
	}	
	
	@GetMapping(value = "/consultarNome/{nome}")
	public ResponseEntity<List<Exercicio>> consultarPorNome(@PathVariable String nome) {
		return new ResponseEntity<>(this.service.consultarPorNome(nome), HttpStatus.OK);
	}

	@DeleteMapping(value = "deletar/{id}")
	public ResponseEntity<String> deletar(@PathVariable Long id) {
		return new ResponseEntity<>(this.service.deletar(id), HttpStatus.OK);
	}



}
