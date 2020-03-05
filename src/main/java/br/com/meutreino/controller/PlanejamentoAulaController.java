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

import br.com.meutreino.domain.PlanejamentoAula;
import br.com.meutreino.service.PlanejamentoService;

@RestController
@RequestMapping("/v1/planejamento")
public class PlanejamentoAulaController {

	@Autowired
	private PlanejamentoService service;

	@PostMapping("/inserir")
	public ResponseEntity<PlanejamentoAula> inserir(@RequestBody PlanejamentoAula planejamentoAula){
		return new ResponseEntity<PlanejamentoAula>(this.service.inserir(planejamentoAula), HttpStatus.OK);
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<PlanejamentoAula> atualizar(@RequestBody PlanejamentoAula planejamentoAula){
		return new ResponseEntity<PlanejamentoAula>(this.service.atualizar(planejamentoAula), HttpStatus.OK);
	}

	@GetMapping("/consultar")
	public ResponseEntity<List<PlanejamentoAula>> consultarTodos() {
		return new ResponseEntity<>(this.service.consultarTodos(), HttpStatus.OK);
	}
	
	@GetMapping("/consultarUm/{id}")
	public ResponseEntity<Optional<PlanejamentoAula>> consultarUm(@PathVariable Long id){
		return new ResponseEntity<>(this.service.consultarUm(id), HttpStatus.OK);
	}
	
	@GetMapping("/consultarProfessor/{id}")
	public ResponseEntity<List<PlanejamentoAula>> consultarPorProfessor(@PathVariable Long id){
		return new ResponseEntity<>(this.service.consultarPorProfessor(id), HttpStatus.OK);
	}

	
	@DeleteMapping("deletar/{id}")
	public ResponseEntity<String> deletar(@PathVariable Long id){		
			
		return new ResponseEntity<>(this.service.deletar(id), HttpStatus.OK);
	}

	
}
