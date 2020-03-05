package br.com.meutreino.controller;

import java.util.List;

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

import br.com.meutreino.domain.AulaExercicio;
import br.com.meutreino.service.AulaExercicioService;

@RestController
@RequestMapping("/v1/aulaExercicio")
public class AulaExercicioController {

	@Autowired
	private AulaExercicioService service;

	@PostMapping("/inserir")
	public ResponseEntity<AulaExercicio> inserir(@RequestBody AulaExercicio aulaExercicio){
		return new ResponseEntity<AulaExercicio>(this.service.inserir(aulaExercicio), HttpStatus.OK);
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<AulaExercicio> atualizar(@RequestBody AulaExercicio aulaExercicio){
		return new ResponseEntity<AulaExercicio>(this.service.atualizar(aulaExercicio), HttpStatus.OK);
	}

	@GetMapping("/consultar")
	public ResponseEntity<List<AulaExercicio>> consultarTodos() {
		return new ResponseEntity<>(this.service.consultarTodos(), HttpStatus.OK);
	}
	
	@DeleteMapping("deletar/{id}")
	public ResponseEntity<String> deletar(@PathVariable Long id){
		return new ResponseEntity<>(this.service.deletar(id), HttpStatus.OK);
	}

	
}
