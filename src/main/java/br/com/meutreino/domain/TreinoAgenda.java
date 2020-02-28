package br.com.meutreino.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import br.com.meutreino.domain.compositeKey.TreinoAgendaCompositeKey;

@Entity
@IdClass(TreinoAgendaCompositeKey.class)
public class TreinoAgenda implements Serializable {

	private static final long serialVersionUID = -1194405381772011509L;

	@Id
	LocalDateTime dataTreino;

	@Id
	@Column(name = "idTreino", insertable = false, updatable = false)
	Long idTreino;

	@Id
	@Column(name = "idPlanejamento", insertable = false, updatable = false)
	Long idPlanejamento;

	@Id
	@Column(name = "idAluno", insertable = false, updatable = false)
	Long idAluno;

	public TreinoAgenda() {
		super();
	}

	public TreinoAgenda(LocalDateTime dataTreino, Long idTreino, Long idPlanejamento, Long idAluno) {
		super();
		this.dataTreino = dataTreino;
		this.idTreino = idTreino;
		this.idPlanejamento = idPlanejamento;
		this.idAluno = idAluno;
	}

	public LocalDateTime getDataTreino() {
		return dataTreino;
	}

	public void setDataTreino(LocalDateTime dataTreino) {
		this.dataTreino = dataTreino;
	}

	public Long getIdTreino() {
		return idTreino;
	}

	public void setIdTreino(Long idTreino) {
		this.idTreino = idTreino;
	}

	public Long getIdPlanejamento() {
		return idPlanejamento;
	}

	public void setIdPlanejamento(Long idPlanejamento) {
		this.idPlanejamento = idPlanejamento;
	}

	public Long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataTreino == null) ? 0 : dataTreino.hashCode());
		result = prime * result + ((idAluno == null) ? 0 : idAluno.hashCode());
		result = prime * result + ((idPlanejamento == null) ? 0 : idPlanejamento.hashCode());
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
		TreinoAgenda other = (TreinoAgenda) obj;
		if (dataTreino == null) {
			if (other.dataTreino != null)
				return false;
		} else if (!dataTreino.equals(other.dataTreino))
			return false;
		if (idAluno == null) {
			if (other.idAluno != null)
				return false;
		} else if (!idAluno.equals(other.idAluno))
			return false;
		if (idPlanejamento == null) {
			if (other.idPlanejamento != null)
				return false;
		} else if (!idPlanejamento.equals(other.idPlanejamento))
			return false;
		if (idTreino == null) {
			if (other.idTreino != null)
				return false;
		} else if (!idTreino.equals(other.idTreino))
			return false;
		
		return true;
	}

}
