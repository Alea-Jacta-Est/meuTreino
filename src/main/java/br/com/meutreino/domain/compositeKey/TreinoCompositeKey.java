package br.com.meutreino.domain.compositeKey;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class TreinoCompositeKey implements Serializable {

	private static final long serialVersionUID = 4132813574564739021L;

	Long idTreino;

	Long idAluno;

	Long idPlanejamentoAula;

	public TreinoCompositeKey() {
		super();
	}

	public TreinoCompositeKey(Long idTreino, Long idAluno, Long idPlanejamentoAula) {
		super();
		this.idTreino = idTreino;
		this.idAluno = idAluno;
		this.idPlanejamentoAula = idPlanejamentoAula;
	}

	public Long getIdTreino() {
		return idTreino;
	}

	public void setIdTreino(Long idTreino) {
		this.idTreino = idTreino;
	}

	public Long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}

	public Long getIdPlanejamentoAula() {
		return idPlanejamentoAula;
	}

	public void setIdPlanejamentoAula(Long idPlanejamentoAula) {
		this.idPlanejamentoAula = idPlanejamentoAula;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAluno == null) ? 0 : idAluno.hashCode());
		result = prime * result + ((idPlanejamentoAula == null) ? 0 : idPlanejamentoAula.hashCode());
		result = prime * result + ((idTreino == null) ? 0 : idTreino.hashCode());
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
		TreinoCompositeKey other = (TreinoCompositeKey) obj;
		if (idAluno == null) {
			if (other.idAluno != null)
				return false;
		} else if (!idAluno.equals(other.idAluno))
			return false;
		if (idPlanejamentoAula == null) {
			if (other.idPlanejamentoAula != null)
				return false;
		} else if (!idPlanejamentoAula.equals(other.idPlanejamentoAula))
			return false;
		if (idTreino == null) {
			if (other.idTreino != null)
				return false;
		} else if (!idTreino.equals(other.idTreino))
			return false;
		return true;
	}

}
