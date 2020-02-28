package br.com.meutreino.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.meutreino.domain.Aluno;
import br.com.meutreino.service.AlunoService;

@RestController
public class AlunoController {

	@Autowired
	private AlunoService alunoService;

	/*
	 * @RequestMapping(value="/") public String getAlunos(Model model) {
	 * 
	 * model.addAttribute("alunosList", this.alunoService.getAlunos());
	 * 
	 * return "aluno"; }
	 */

	@GetMapping(value =  "/")
	public List<Aluno> getAlunos() {
		return (List<Aluno>) this.alunoService.getAlunos();
	}

	@PostMapping(value = "aluno")
	public Aluno inserir(@RequestBody Aluno aluno) {
		
		return this.alunoService.inserir(aluno);
		
	}
}
