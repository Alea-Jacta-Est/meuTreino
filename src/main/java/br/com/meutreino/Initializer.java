package br.com.meutreino;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.meutreino.domain.Aluno;
import br.com.meutreino.domain.AulaExercicio;
import br.com.meutreino.domain.Contrato;
import br.com.meutreino.domain.Exercicio;
import br.com.meutreino.domain.PlanejamentoAula;
import br.com.meutreino.domain.Professor;
import br.com.meutreino.domain.Treino;
import br.com.meutreino.domain.compositeKey.TreinoCompositeKey;
import br.com.meutreino.repository.AlunoRepository;
import br.com.meutreino.repository.AulaExercicioRepository;
import br.com.meutreino.repository.ContratoRepository;
import br.com.meutreino.repository.ExercicioRepository;
import br.com.meutreino.repository.PlanejamentoAulaRepository;
import br.com.meutreino.repository.ProfessorRepository;
import br.com.meutreino.repository.TreinoRepository;

@Component
public class Initializer implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	AlunoRepository alunoRepository;

	@Autowired
	ProfessorRepository professorRepository;

	@Autowired
	ExercicioRepository exercicioRepository;

	@Autowired
	PlanejamentoAulaRepository planejamentoAulaRepository;

	@Autowired
	ContratoRepository contratoRepository;

	@Autowired
	AulaExercicioRepository aulaExercicioRepository;

	@Autowired
	TreinoRepository treinoRepository;

	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent arg0) {

		// DADOS ALUNO
		Aluno aluno = new Aluno();
		aluno.setNome("Fábio Luiz De Franchi Marques");
		aluno.setIdade(Short.valueOf("39"));
		aluno.setEmail("fabio.franchi@gmail.com");
		aluno.setTelefone("5581999873752");
		aluno.setDataCadastro(LocalDate.now());

		this.alunoRepository.save(aluno);

		// DADOS PROFESSOR
		Professor professor = new Professor();
		professor.setDataCadastro(LocalDate.now());
		professor.setEmail("eduardo.guedes@gmail.com");
		professor.setNome("Eduardo Guedes");
		professor.setTelefone("5581998292912");

		this.professorRepository.save(professor);

		// DADOS EXERCÍCIO
		Exercicio exercicio = new Exercicio();
		exercicio.setNome("Agachamento Livre");
		exercicio.setGrupoMuscular("Pernas");
		exercicio.setDataCadastro(LocalDate.now());

		this.exercicioRepository.save(exercicio);

		// DADOS PLANEJAMENTO AULA
		PlanejamentoAula planejamentoAula = new PlanejamentoAula();
		planejamentoAula.setProfessor(professor);
		planejamentoAula.setDataCadastro(LocalDate.now());

		this.planejamentoAulaRepository.save(planejamentoAula);

		// DADOS CONTRATO
		Contrato contrato = new Contrato();
		contrato.setAluno(aluno);
		contrato.setProfessor(professor);
		contrato.setDataInicio(LocalDate.now());
		contrato.setValor(BigDecimal.valueOf(500));

		this.contratoRepository.save(contrato);

		// DADOS AULA EXERCÍCIO
		AulaExercicio aulaExercicio = new AulaExercicio();
		aulaExercicio.setIdPlanejamento(planejamentoAula.getIdPlanejamento());
		aulaExercicio.setIdExercicio(exercicio.getIdExercicio());
		aulaExercicio.setOrderExecucao(Short.valueOf("1"));
		aulaExercicio.setObservacao("Fazer após os exercícios de mobilidade do quadril");

		this.aulaExercicioRepository.save(aulaExercicio);

		// DADOS TREINO 
		TreinoCompositeKey pkTreino = new TreinoCompositeKey();
		pkTreino.setIdAluno(aluno.getIdAluno());
		pkTreino.setIdPlanejamentoAula(planejamentoAula.getIdPlanejamento());
		
		Treino treino = new Treino();
		treino.setIdAluno(aluno.getIdAluno());
		treino.setAluno(aluno);
		treino.setIdPlanejamentoAula(planejamentoAula.getIdPlanejamento());

		this.treinoRepository.save(treino);

	}

}
