package br.com.meutreino;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
import br.com.meutreino.domain.TreinoAgenda;
import br.com.meutreino.repository.AlunoRepository;
import br.com.meutreino.repository.AulaExercicioRepository;
import br.com.meutreino.repository.ContratoRepository;
import br.com.meutreino.repository.ExercicioRepository;
import br.com.meutreino.repository.PlanejamentoAulaRepository;
import br.com.meutreino.repository.ProfessorRepository;
import br.com.meutreino.repository.TreinoAgendaRepository;
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
	
	@Autowired
	TreinoAgendaRepository treinoAgendaRepository;

	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent arg0) {

		// DADOS ALUNO
		Aluno aluno = new Aluno();
		aluno.setNome("Fábio Luiz De Franchi Marques");
		aluno.setDataNascimento(LocalDate.parse("1980-04-30"));
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
		planejamentoAula.setIdProfessor(professor.getIdProfessor());
		planejamentoAula.setDataCadastro(LocalDate.now());
		planejamentoAula.setObservacao("Treino de costas e ombros para reabilização pós-operatório");

		this.planejamentoAulaRepository.save(planejamentoAula);

		// DADOS CONTRATO
		Contrato contrato = new Contrato();
		contrato.setIdAluno(aluno.getIdAluno());
		contrato.setIdProfessor(professor.getIdProfessor());
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
		Treino treino = new Treino();
		treino.setIdAluno(aluno.getIdAluno());
		treino.setIdPlanejamento(planejamentoAula.getIdPlanejamento());

		treino = this.treinoRepository.save(treino);
		
		// DADOS TREINO AGENDA
		TreinoAgenda treinoAgenda = new TreinoAgenda();
		treinoAgenda.setDataTreino(LocalDateTime.now());
		treinoAgenda.setIdAluno(treino.getIdAluno());
		treinoAgenda.setIdPlanejamento(treino.getIdPlanejamento());
		treinoAgenda.setIdTreino(treino.getIdTreino());
		
		
		this.treinoAgendaRepository.save(treinoAgenda);
		
		treinoAgenda.setDataTreino(LocalDateTime.now());
		treinoAgenda.setIdAluno(treino.getIdAluno());
		treinoAgenda.setIdPlanejamento(treino.getIdPlanejamento());
		treinoAgenda.setIdTreino(treino.getIdTreino());
		
		this.treinoAgendaRepository.save(treinoAgenda);

	}

}
