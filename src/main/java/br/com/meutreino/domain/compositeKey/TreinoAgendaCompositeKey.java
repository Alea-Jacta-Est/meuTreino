package br.com.meutreino.domain.compositeKey;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Embeddable;

@Embeddable
public class TreinoAgendaCompositeKey implements Serializable {

	private static final long serialVersionUID = 5738596647186505584L;

	LocalDateTime dataTreino;

	Long idTreino;

	Long idPlanejamento;

	Long idAluno;

	public TreinoAgendaCompositeKey() {
		super();
	}

	public TreinoAgendaCompositeKey(LocalDateTime dataTreino, Long idTreino, Long idPlanejamento, Long idAluno) {
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

}
