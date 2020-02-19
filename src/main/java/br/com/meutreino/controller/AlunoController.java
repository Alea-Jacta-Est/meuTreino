package br.com.meutreino.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.meutreino.repository.AlunoRepository;

@Controller
public class AlunoController {

	private AlunoRepository alunoRepository;

	public AlunoController(AlunoRepository alunoRepository) {
		super();
		this.alunoRepository = alunoRepository;
	}
	
	@RequestMapping("/aluno")
	public String getAlunos(Model model) {
		model.addAttribute("alunosList", this.alunoRepository.findAll());
		
		return "aluno";
	}
}
