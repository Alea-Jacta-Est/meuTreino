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

import br.com.meutreino.domain.Aluno;
import br.com.meutreino.service.AlunoService;

@RestController
@RequestMapping("/v1/aluno")
public class AlunoController {

	@Autowired
	private AlunoService service;

	@PostMapping("/inserir")
	public ResponseEntity<Aluno> inserir(@RequestBody Aluno aluno){
		return new ResponseEntity<Aluno>(this.service.inserir(aluno), HttpStatus.OK);
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Aluno> atualizar(@RequestBody Aluno aluno){
		return new ResponseEntity<Aluno>(this.service.atualizar(aluno), HttpStatus.OK);
	}

	@GetMapping("/consultar")
	public ResponseEntity<List<Aluno>> consultarTodos() {
		return new ResponseEntity<>(this.service.consultarTodos(), HttpStatus.OK);
	}
	
	@GetMapping("/consultarUm/{id}")
	public ResponseEntity<Optional<Aluno>> consultarUm(@PathVariable Long id){
		return new ResponseEntity<>(this.service.consultarUm(id), HttpStatus.OK);
	}
	
	@GetMapping("/consultarNome/{nome}")
	public ResponseEntity<List<Aluno>> consultarPorNome(@PathVariable String nome){
		return new ResponseEntity<>(this.service.consultarPorNome(nome), HttpStatus.OK);
	}
	
	@GetMapping("/consultarEmail/{email}")
	public ResponseEntity<Optional<Aluno>> consultarPorEmail(@PathVariable String email){
		return new ResponseEntity<>(this.service.consultarPorEmail(email), HttpStatus.OK);
	}
	
	@DeleteMapping("deletar/{id}")
	public ResponseEntity<String> deletar(@PathVariable Long id){
		return new ResponseEntity<>(this.service.deletar(id), HttpStatus.OK);
	}

	
}
