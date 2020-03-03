package br.com.meutreino.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import br.com.meutreino.domain.compositeKey.ExercicioExecucaoCompositeKey;

@Entity
@IdClass(ExercicioExecucaoCompositeKey.class)
public class ExercicioExecucao implements Serializable{

	private static final long serialVersionUID = -4386489158460718028L;

	@SequenceGenerator(name="exercicioExecucaoGenerator",sequenceName = "EXERCICIO_EXECUCAO_SEQ", allocationSize = 10)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exercicioExecucaoGenerator")
	private Long idExecucao;

	@Id
	@Column(name = "idPlanejamento", insertable = false, updatable = false)
	private Long idPlanejamento;

	@Id
	@Column(name = "idExercicio", insertable = false, updatable = false)
	private Long idExercicio; 

	private Integer serie;

	private Integer numeroRepeticaoMinimo;

	private Integer numeroRepeticaoMaximo;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumns({ @JoinColumn(name = "idExecucao", referencedColumnName = "idExecucao"),
		@JoinColumn(name = "idExercicio", referencedColumnName = "idExercicio"),
		@JoinColumn(name = "idPlanejamento", referencedColumnName = "idPlanejamento") })
	private Set<CargaExecucao> cargaExecucoes;

	public ExercicioExecucao() {
		super();
	}

	public ExercicioExecucao(Long idExecucao, Long idPlanejamento, Long idExercicio, Integer serie,
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

	public Set<CargaExecucao> getCargaExecucoes() {
		return cargaExecucoes;
	}

	public void setCargaExecucoes(Set<CargaExecucao> cargaExecucoes) {
		this.cargaExecucoes = cargaExecucoes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cargaExecucoes == null) ? 0 : cargaExecucoes.hashCode());
		result = prime * result + ((idExecucao == null) ? 0 : idExecucao.hashCode());
		result = prime * result + ((idExercicio == null) ? 0 : idExercicio.hashCode());
		result = prime * result + ((idPlanejamento == null) ? 0 : idPlanejamento.hashCode());
		result = prime * result + ((numeroRepeticaoMaximo == null) ? 0 : numeroRepeticaoMaximo.hashCode());
		result = prime * result + ((numeroRepeticaoMinimo == null) ? 0 : numeroRepeticaoMinimo.hashCode());
		result = prime * result + ((serie == null) ? 0 : serie.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExercicioExecucao other = (ExercicioExecucao) obj;
		if (cargaExecucoes == null) {
			if (other.cargaExecucoes != null)
				return false;
		} else if (!cargaExecucoes.equals(other.cargaExecucoes))
			return false;
		if (idExecucao == null) {
			if (other.idExecucao != null)
				return false;
		} else if (!idExecucao.equals(other.idExecucao))
			return false;
		if (idExercicio == null) {
			if (other.idExercicio != null)
				return false;
		} else if (!idExercicio.equals(other.idExercicio))
			return false;
		if (idPlanejamento == null) {
			if (other.idPlanejamento != null)
				return false;
		} else if (!idPlanejamento.equals(other.idPlanejamento))
			return false;
		if (numeroRepeticaoMaximo == null) {
			if (other.numeroRepeticaoMaximo != null)
				return false;
		} else if (!numeroRepeticaoMaximo.equals(other.numeroRepeticaoMaximo))
			return false;
		if (numeroRepeticaoMinimo == null) {
			if (other.numeroRepeticaoMinimo != null)
				return false;
		} else if (!numeroRepeticaoMinimo.equals(other.numeroRepeticaoMinimo))
			return false;
		if (serie == null) {
			if (other.serie != null)
				return false;
		} else if (!serie.equals(other.serie))
			return false;
		return true;
	}

}
