package br.com.meutreino.domain.dto;

public class ExercicioExecucaoDTO {
	
	private Long idExecucao;

	private Long idPlanejamento;

	private Long idExercicio; 

	private Integer serie;

	private Integer numeroRepeticaoMinimo;

	private Integer numeroRepeticaoMaximo;

	public ExercicioExecucaoDTO() {
		super();
	}

	public ExercicioExecucaoDTO(Long idExecucao, Long idPlanejamento, Long idExercicio, Integer serie,
			Integer numeroRepeticaoMinimo, Integer numeroRepeticaoMaximo) {
		super();
		this.idExecucao = idExecucao;
		this.idPlanejamento = idPlanejamento;
		this.idExercicio = idExercicio;
		this.serie = serie;
		this.numeroRepeticaoMinimo = numeroRepeticaoMinimo;
		this.numeroRepeticaoMaximo = numeroRepeticaoMaximo;
	}

	public Long getIdExecucao() {
		return idExecucao;
	}

	public void setIdExecucao(Long idExecucao) {
		this.idExecucao = idExecucao;
	}

	public Long getIdPlanejamento() {
		return idPlanejamento;
	}

	public void setIdPlanejamento(Long idPlanejamento) {
		this.idPlanejamento = idPlanejamento;
	}

	public Long getIdExercicio() {
		return idExercicio;
	}

	public void setIdExercicio(Long idExercicio) {
		this.idExercicio = idExercicio;
	}

	public Integer getSerie() {
		return serie;
	}

	public void setSerie(Integer serie) {
		this.serie = serie;
	}

	public Integer getNumeroRepeticaoMinimo() {
		return numeroRepeticaoMinimo;
	}

	public void setNumeroRepeticaoMinimo(Integer numeroRepeticaoMinimo) {
		this.numeroRepeticaoMinimo = numeroRepeticaoMinimo;
	}

	public Integer getNumeroRepeticaoMaximo() {
		return numeroRepeticaoMaximo;
	}

	public void setNumeroRepeticaoMaximo(Integer numeroRepeticaoMaximo) {
		this.numeroRepeticaoMaximo = numeroRepeticaoMaximo;
	}
	
	
}
