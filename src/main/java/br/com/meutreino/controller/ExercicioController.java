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
	public Exercicio atualizar(@RequestBody Exercicio exercicio) {
		return this.repository.save(exercicio);
	}

	@GetMapping("/consultar")
	public List<Exercicio> consultarTodos() {
		return this.repository.findAll();
	}

	@GetMapping(value = "/{id}")
	public Optional<Exercicio> consultarPorId(@PathVariable Long id) {
		return this.repository.findById(id);
	}

	@DeleteMapping(value = "/{id}")
	public String deletar(@PathVariable Long id) {
		this.repository.deleteById(id);
		return "{\"mensagem\": \"Registro excluído!\" }";
	}

	@GetMapping(value = "/consultar/{nome}")
	public List<Exercicio> consultarPorNome(@PathVariable String nome) {
		return this.repository.findByNomeLike(nome);
	}

}
