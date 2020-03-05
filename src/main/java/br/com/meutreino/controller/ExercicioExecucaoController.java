package br.com.meutreino.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.meutreino.domain.ExercicioExecucao;
import br.com.meutreino.domain.dto.ExercicioExecucaoDTO;
import br.com.meutreino.service.ExercicioExecucaoService;

@RestController
@RequestMapping("/v1/exercicioExecucao")
public class ExercicioExecucaoController {

	@Autowired
	private ExercicioExecucaoService service;
	
	@Autowired
	private ModelMapper mapper;

	@PostMapping("/inclusao")
	public ResponseEntity<ExercicioExecucaoDTO> inserir(@RequestBody ExercicioExecucaoDTO exercicioExecucaoDTO) {
		return new ResponseEntity<>(convertToDto(this.service.inserir(convertToEntity(exercicioExecucaoDTO))), HttpStatus.OK);
	}

	@PutMapping("/atualizacao")
	public ResponseEntity<ExercicioExecucaoDTO> atualizar(@RequestBody ExercicioExecucaoDTO exercicioExecucaoDTO) {
		return new ResponseEntity<>(convertToDto(this.service.atualizar(convertToEntity(exercicioExecucaoDTO))), HttpStatus.OK);
	}

	@GetMapping("/pesquisa")
	public ResponseEntity<List<ExercicioExecucaoDTO>> consultarTodos() {
		return new ResponseEntity<>(convertToListDTO(this.service.consultarTodos()), HttpStatus.OK);
	}

	@DeleteMapping("exclusao/{id}")
	public ResponseEntity<String> deletar(ExercicioExecucaoDTO exercicioExecucaoDTO) {
		return new ResponseEntity<>(this.service.deletar(convertToEntity(exercicioExecucaoDTO)), HttpStatus.OK);
	}
	
	private ExercicioExecucaoDTO convertToDto(ExercicioExecucao exercicioExecucao) {
		return mapper.map(exercicioExecucao, ExercicioExecucaoDTO.class);		
	}
	
	private ExercicioExecucao convertToEntity(ExercicioExecucaoDTO exercicioExecucaoDTO) {
		return mapper.map(exercicioExecucaoDTO, ExercicioExecucao.class);
	}
	
	private List<ExercicioExecucaoDTO> convertToListDTO(List<ExercicioExecucao> listaExercicioExecucao){
		return mapper.map(listaExercicioExecucao, new TypeToken<List<ExercicioExecucaoDTO>>(){}.getType());
	}

}
