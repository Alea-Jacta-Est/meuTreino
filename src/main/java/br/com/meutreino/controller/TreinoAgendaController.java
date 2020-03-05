package br.com.meutreino.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.meutreino.domain.TreinoAgenda;
import br.com.meutreino.service.TreinoAgendaService;

@RestController
@RequestMapping("/v1/treinoAgenda")
public class TreinoAgendaController {

	@Autowired
	private TreinoAgendaService service;

	@PostMapping("/inserir")
	public ResponseEntity<TreinoAgenda> inserir(@RequestBody TreinoAgenda treinoAgenda){
		return new ResponseEntity<TreinoAgenda>(this.service.inserir(treinoAgenda), HttpStatus.OK);
	}

	@GetMapping("/consultar")
	public ResponseEntity<List<TreinoAgenda>> consultarTodos() {
		return new ResponseEntity<>(this.service.consultarTodos(), HttpStatus.OK);
	}	
	
}
