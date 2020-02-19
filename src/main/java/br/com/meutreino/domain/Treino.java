package br.com.meutreino.domain;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
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
	private Long idAluno;

	@Id
	private Long idPlanejamento;

	@OneToMany(mappedBy = "treino", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<TreinoAgenda> treinoAgenda;

	private String tipo;

	private LocalDate dataInicio;

	private LocalDate dataFim;

	private LocalDate dataEnvio;

	@Version
	private Integer versao;

	public Treino() {
		super();
	}

	public Treino(Long idTreino, Long idAluno, Long idPlanejamento,
			Set<TreinoAgenda> treinoAgenda, String tipo, LocalDate dataInicio, LocalDate dataFim, LocalDate dataEnvio,
			Integer versao) {
		super();
		this.idTreino = idTreino;
		this.idAluno = idAluno;
		this.idPlanejamento = idPlanejamento;
		this.treinoAgenda = treinoAgenda;
		this.tipo = tipo;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.dataEnvio = dataEnvio;
		this.versao = versao;
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

	public Long getIdPlanejamento() {
		return idPlanejamento;
	}

	public void setIdPlanejamento(Long idPlanejamento) {
		this.idPlanejamento = idPlanejamento;
	}

	public Set<TreinoAgenda> getTreinoAgenda() {
		return treinoAgenda;
	}

	public void setTreinoAgenda(Set<TreinoAgenda> treinoAgenda) {
		this.treinoAgenda = treinoAgenda;
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

	public Integer getVersao() {
		return versao;
	}

	public void setVersao(Integer versao) {
		this.versao = versao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataEnvio == null) ? 0 : dataEnvio.hashCode());
		result = prime * result + ((dataFim == null) ? 0 : dataFim.hashCode());
		result = prime * result + ((dataInicio == null) ? 0 : dataInicio.hashCode());
		result = prime * result + ((idAluno == null) ? 0 : idAluno.hashCode());
		result = prime * result + ((idPlanejamento == null) ? 0 : idPlanejamento.hashCode());
		result = prime * result + ((idTreino == null) ? 0 : idTreino.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((versao == null) ? 0 : versao.hashCode());
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
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (versao == null) {
			if (other.versao != null)
				return false;
		} else if (!versao.equals(other.versao))
			return false;
		return true;
	}

}
