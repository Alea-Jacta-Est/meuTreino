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

import br.com.meutreino.domain.Professor;
import br.com.meutreino.service.ProfessorService;

@RestController
@RequestMapping("/v1/professor")
public class ProfessorController {

	@Autowired
	private ProfessorService service;

	@PostMapping("/inserir")
	public ResponseEntity<Professor> inserir(@RequestBody Professor professor){
		return new ResponseEntity<Professor>(this.service.inserir(professor), HttpStatus.OK);
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Professor> atualizar(@RequestBody Professor professor){
		return new ResponseEntity<Professor>(this.service.atualizar(professor), HttpStatus.OK);
	}

	@GetMapping("/consultar")
	public ResponseEntity<List<Professor>> consultarTodos() {
		return new ResponseEntity<>(this.service.consultarTodos(), HttpStatus.OK);
	}
	
	@GetMapping("/consultarUm/{id}")
	public ResponseEntity<Optional<Professor>> consultarUm(@PathVariable Long id){
		return new ResponseEntity<>(this.service.consultarUm(id), HttpStatus.OK);
	}
	
	@GetMapping("/consultarNome/{nome}")
	public ResponseEntity<List<Professor>> consultarPorNome(@PathVariable String nome){
		return new ResponseEntity<>(this.service.consultarPorNome(nome), HttpStatus.OK);
	}
	
	@GetMapping("/consultarEmail/{email}")
	public ResponseEntity<Optional<Professor>> consultarPorEmail(@PathVariable String email){
		return new ResponseEntity<>(this.service.consultarPorEmail(email), HttpStatus.OK);
	}
	
	@DeleteMapping("deletar/{id}")
	public ResponseEntity<String> deletar(@PathVariable Long id){
		return new ResponseEntity<>(this.service.deletar(id), HttpStatus.OK);
	}

	
}
