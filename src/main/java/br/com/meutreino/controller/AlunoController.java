package br.com.meutreino.controller;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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
import br.com.meutreino.domain.dto.AlunoDTO;
import br.com.meutreino.service.AlunoService;

@RestController
@RequestMapping("/v1/alunos")
public class AlunoController {

	@Autowired
	private AlunoService service;
	
	@Autowired
	private ModelMapper mapper;

	@PostMapping("/inclusao")
	public ResponseEntity<AlunoDTO> inserir(@RequestBody AlunoDTO alunoDTO){
		return new ResponseEntity<>(convertToDto(this.service.inserir(convertToEntity(alunoDTO))), HttpStatus.OK);
	}
	
	@PutMapping("/atualizacao")
	public ResponseEntity<AlunoDTO> atualizar(@RequestBody AlunoDTO alunoDTO){
		return new ResponseEntity<>(convertToDto(this.service.atualizar(convertToEntity(alunoDTO))), HttpStatus.OK);
	}

	@GetMapping("/pesquisa")
	public ResponseEntity<List<AlunoDTO>> consultarTodos() {
		return new ResponseEntity<>(convertToListDTO(this.service.consultarTodos()), HttpStatus.OK);
	}
	
	@GetMapping("/pesquisaUm/{id}")
	public ResponseEntity<Optional<AlunoDTO>> consultarUm(@PathVariable Long id){
		return new ResponseEntity<>(convertToOptional(this.service.consultarUm(id)), HttpStatus.OK);
	}
	
	@GetMapping("/pesquisaNome/{nome}")
	public ResponseEntity<List<AlunoDTO>> consultarPorNome(@PathVariable String nome){
		return new ResponseEntity<>(convertToListDTO(this.service.consultarPorNome(nome)), HttpStatus.OK);
	}
	
	@GetMapping("/pesquisaEmail/{email}")
	public ResponseEntity<Optional<AlunoDTO>> consultarPorEmail(@PathVariable String email){
		return new ResponseEntity<>(convertToOptional(this.service.consultarPorEmail(email)), HttpStatus.OK);
	}
	
	@DeleteMapping("exclusao/{id}")
	public ResponseEntity<String> deletar(@PathVariable Long id){
		return new ResponseEntity<>(this.service.deletar(id), HttpStatus.OK);
	}

	private AlunoDTO convertToDto(Aluno aluno) {
		return mapper.map(aluno, AlunoDTO.class);		
	}
	
	private Aluno convertToEntity(AlunoDTO alunoDto) {
		return mapper.map(alunoDto, Aluno.class);
	}
	
	private List<AlunoDTO> convertToListDTO(List<Aluno> listaAluno){
		return mapper.map(listaAluno, new TypeToken<List<AlunoDTO>>(){}.getType());
	}
	
	private Optional<AlunoDTO> convertToOptional(Optional<Aluno> aluno){
		return mapper.map(aluno, new TypeToken<Optional<AlunoDTO>>(){}.getType());
	}
	
}
