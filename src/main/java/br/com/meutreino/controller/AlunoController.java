package br.com.meutreino.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.meutreino.service.AlunoService;

@Controller
public class AlunoController {

	@Autowired
	private AlunoService alunoService;
	
	@RequestMapping("/")
	public String getAlunos(Model model) {
		
		model.addAttribute("alunosList", this.alunoService.getAlunos());
		
		return "aluno";
	}
}
