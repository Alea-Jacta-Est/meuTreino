package br.com.meutreino.domain.compositeKey;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class AulaExercicioCompositeKey implements Serializable {

	private static final long serialVersionUID = -3556386906859192880L;

	Long idPlanejamento;

	Long idExercicio;

	public AulaExercicioCompositeKey() {
		super();
	}

	public AulaExercicioCompositeKey(Long idPlanejamento, Long idExercicio) {
		super();
		this.idPlanejamento = idPlanejamento;
		this.idExercicio = idExercicio;
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
		AulaExercicioCompositeKey other = (AulaExercicioCompositeKey) obj;
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
