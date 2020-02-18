package br.com.meutreino.domain;

import java.time.LocalDate;
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
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import br.com.meutreino.domain.compositeKey.TreinoCompositeKey;

@Entity
@IdClass(TreinoCompositeKey.class)
public class Treino {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idTreino;

	@Id
	@Column(name = "idAluno")
	Long idAluno;

	@Id
	@Column(name = "idPlanejamento")
	Long idPlanejamentoAula;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "idAluno")
	@MapsId
	Aluno aluno;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "idPlanejamento")
	@MapsId
	PlanejamentoAula planejamentoAula;

	@OneToMany(mappedBy = "treino", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<TreinoAgenda> treinoAgenda;

	String tipo;

	LocalDate dataInicio;

	LocalDate dataFim;

	LocalDate dataEnvio;

	@Version
	Integer versao;

	public Treino() {
		super();
	}

	public Treino(Long idTreino, Long idAluno, Long idPlanejamentoAula, Aluno aluno, PlanejamentoAula planejamentoAula,
			String tipo, LocalDate dataInicio, LocalDate dataFim, LocalDate dataEnvio) {
		super();
		this.idTreino = idTreino;
		this.idAluno = idAluno;
		this.idPlanejamentoAula = idPlanejamentoAula;
		this.aluno = aluno;
		this.planejamentoAula = planejamentoAula;
		this.tipo = tipo;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.dataEnvio = dataEnvio;
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

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public PlanejamentoAula getPlanejamentoAula() {
		return planejamentoAula;
	}

	public void setPlanejamentoAula(PlanejamentoAula planejamentoAula) {
		this.planejamentoAula = planejamentoAula;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public LocalDate getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(LocalDate dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public Integer getDataUltimaAlteracao() {
		return versao;
	}

	public void setDataUltimaAlteracao(Integer versao) {
		this.versao = versao;
	}

	public Set<TreinoAgenda> getTreinoAgenda() {
		return treinoAgenda;
	}

	public void setTreinoAgenda(Set<TreinoAgenda> treinoAgenda) {
		this.treinoAgenda = treinoAgenda;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aluno == null) ? 0 : aluno.hashCode());
		result = prime * result + ((dataEnvio == null) ? 0 : dataEnvio.hashCode());
		result = prime * result + ((dataFim == null) ? 0 : dataFim.hashCode());
		result = prime * result + ((dataInicio == null) ? 0 : dataInicio.hashCode());
		result = prime * result + ((versao == null) ? 0 : versao.hashCode());
		result = prime * result + ((idAluno == null) ? 0 : idAluno.hashCode());
		result = prime * result + ((idPlanejamentoAula == null) ? 0 : idPlanejamentoAula.hashCode());
		result = prime * result + ((idTreino == null) ? 0 : idTreino.hashCode());
		result = prime * result + ((planejamentoAula == null) ? 0 : planejamentoAula.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Treino other = (Treino) obj;
		if (aluno == null) {
			if (other.aluno != null)
				return false;
		} else if (!aluno.equals(other.aluno))
			return false;
		if (dataEnvio == null) {
			if (other.dataEnvio != null)
				return false;
		} else if (!dataEnvio.equals(other.dataEnvio))
			return false;
		if (dataFim == null) {
			if (other.dataFim != null)
				return false;
		} else if (!dataFim.equals(other.dataFim))
			return false;
		if (dataInicio == null) {
			if (other.dataInicio != null)
				return false;
		} else if (!dataInicio.equals(other.dataInicio))
			return false;
		if (versao == null) {
			if (other.versao != null)
				return false;
		} else if (!versao.equals(other.versao))
			return false;
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
		if (planejamentoAula == null) {
			if (other.planejamentoAula != null)
				return false;
		} else if (!planejamentoAula.equals(other.planejamentoAula))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

}
