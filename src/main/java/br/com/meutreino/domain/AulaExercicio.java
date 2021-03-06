package br.com.meutreino.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.meutreino.domain.compositeKey.AulaExercicioCompositeKey;

@Entity
@IdClass(AulaExercicioCompositeKey.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AulaExercicio implements Serializable{

	private static final long serialVersionUID = 8437343108966704084L;

	@Id
	@JoinColumn(name = "idPlanejamento", nullable = false)
	private Long idPlanejamento;

	@Id
	@JoinColumn(name = "idExercicio", nullable = false)
	private Long idExercicio;

	private Short orderExecucao;

	private String observacao;

	private String linkExecucao;

	@OneToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "idExercicio")
	@MapsId
	private Exercicio exercicio;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumns({ @JoinColumn(name = "idExercicio", referencedColumnName = "idExercicio"),
			@JoinColumn(name = "idPlanejamento", referencedColumnName = "idPlanejamento") })
	private Set<ExercicioExecucao> exercicioExecucoes;

	public AulaExercicio() {
		super();
	}

	public AulaExercicio(Long idPlanejamento, Long idExercicio, Exercicio exercicio, Short orderExecucao,
			String observacao, String linkExecucao, Set<ExercicioExecucao> exercicioExecucoes) {
		super();
		this.idPlanejamento = idPlanejamento;
		this.idExercicio = idExercicio;
		this.exercicio = exercicio;
		this.orderExecucao = orderExecucao;
		this.observacao = observacao;
		this.linkExecucao = linkExecucao;
		this.exercicioExecucoes = exercicioExecucoes;
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

	public Exercicio getExercicio() {
		return exercicio;
	}

	public void setExercicio(Exercicio exercicio) {
		this.exercicio = exercicio;
	}

	public Short getOrderExecucao() {
		return orderExecucao;
	}

	public void setOrderExecucao(Short orderExecucao) {
		this.orderExecucao = orderExecucao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getLinkExecucao() {
		return linkExecucao;
	}

	public void setLinkExecucao(String linkExecucao) {
		this.linkExecucao = linkExecucao;
	}

	public Set<ExercicioExecucao> getExercicioExecucoes() {
		return exercicioExecucoes;
	}

	public void setExercicioExecucoes(Set<ExercicioExecucao> exercicioExecucoes) {
		this.exercicioExecucoes = exercicioExecucoes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exercicio == null) ? 0 : exercicio.hashCode());
		result = prime * result + ((exercicioExecucoes == null) ? 0 : exercicioExecucoes.hashCode());
		result = prime * result + ((idExercicio == null) ? 0 : idExercicio.hashCode());
		result = prime * result + ((idPlanejamento == null) ? 0 : idPlanejamento.hashCode());
		result = prime * result + ((linkExecucao == null) ? 0 : linkExecucao.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + ((orderExecucao == null) ? 0 : orderExecucao.hashCode());
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
		AulaExercicio other = (AulaExercicio) obj;
		if (exercicio == null) {
			if (other.exercicio != null)
				return false;
		} else if (!exercicio.equals(other.exercicio))
			return false;
		if (exercicioExecucoes == null) {
			if (other.exercicioExecucoes != null)
				return false;
		} else if (!exercicioExecucoes.equals(other.exercicioExecucoes))
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
		if (linkExecucao == null) {
			if (other.linkExecucao != null)
				return false;
		} else if (!linkExecucao.equals(other.linkExecucao))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (orderExecucao == null) {
			if (other.orderExecucao != null)
				return false;
		} else if (!orderExecucao.equals(other.orderExecucao))
			return false;

		return true;
	}

}
