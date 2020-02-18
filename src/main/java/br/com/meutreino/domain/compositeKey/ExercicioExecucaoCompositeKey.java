package br.com.meutreino.domain.compositeKey;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ExercicioExecucaoCompositeKey implements Serializable {

	private static final long serialVersionUID = -4334638457015470702L;

	Long idExecucao;

	Long idPlanejamento;

	Long idExercicio;

	public ExercicioExecucaoCompositeKey() {
		super();
	}

	public ExercicioExecucaoCompositeKey(Long idExecucao, Long idPlanejamento, Long idExercicio) {
		super();
		this.idExecucao = idExecucao;
		this.idPlanejamento = idPlanejamento;
		this.idExercicio = idExercicio;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idExecucao == null) ? 0 : idExecucao.hashCode());
		result = prime * result + ((idExercicio == null) ? 0 : idExercicio.hashCode());
		result = prime * result + ((idPlanejamento == null) ? 0 : idPlanejamento.hashCode());
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
		ExercicioExecucaoCompositeKey other = (ExercicioExecucaoCompositeKey) obj;
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
		return true;
	}
}
