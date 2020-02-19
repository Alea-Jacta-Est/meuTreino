package br.com.meutreino.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CargaExecucao implements Serializable {

	private static final long serialVersionUID = -6139186010887763805L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCarga;

	@Column(name = "idExecucao", insertable = false, updatable = false)
	private Long idExercucao;

	@Column(name = "idExercicio", insertable = false, updatable = false)
	private Long idExercicio;

	@Column(name = "idPlanejamento", insertable = false, updatable = false)
	private Long idPlanejamento;

	private Integer carga;

	private LocalDate dataCadastro;

	public CargaExecucao() {
		super();
	}

	public CargaExecucao(Long idCarga, Long idExercucao, Long idExercicio, Long idPlanejamento, Integer carga,
			LocalDate dataCadastro) {
		super();
		this.idCarga = idCarga;
		this.idExercucao = idExercucao;
		this.idExercicio = idExercicio;
		this.idPlanejamento = idPlanejamento;
		this.carga = carga;
		this.dataCadastro = dataCadastro;
	}

	public Long getIdCarga() {
		return idCarga;
	}

	public void setIdCarga(Long idCarga) {
		this.idCarga = idCarga;
	}

	public Long getIdExercucao() {
		return idExercucao;
	}

	public void setIdExercucao(Long idExercucao) {
		this.idExercucao = idExercucao;
	}

	public Long getIdExercicio() {
		return idExercicio;
	}

	public void setIdExercicio(Long idExercicio) {
		this.idExercicio = idExercicio;
	}

	public Long getIdPlanejamento() {
		return idPlanejamento;
	}

	public void setIdPlanejamento(Long idPlanejamento) {
		this.idPlanejamento = idPlanejamento;
	}

	public Integer getCarga() {
		return carga;
	}

	public void setCarga(Integer carga) {
		this.carga = carga;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carga == null) ? 0 : carga.hashCode());
		result = prime * result + ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + ((idCarga == null) ? 0 : idCarga.hashCode());
		result = prime * result + ((idExercicio == null) ? 0 : idExercicio.hashCode());
		result = prime * result + ((idExercucao == null) ? 0 : idExercucao.hashCode());
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
		CargaExecucao other = (CargaExecucao) obj;
		if (carga == null) {
			if (other.carga != null)
				return false;
		} else if (!carga.equals(other.carga))
			return false;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (idCarga == null) {
			if (other.idCarga != null)
				return false;
		} else if (!idCarga.equals(other.idCarga))
			return false;
		if (idExercicio == null) {
			if (other.idExercicio != null)
				return false;
		} else if (!idExercicio.equals(other.idExercicio))
			return false;
		if (idExercucao == null) {
			if (other.idExercucao != null)
				return false;
		} else if (!idExercucao.equals(other.idExercucao))
			return false;
		if (idPlanejamento == null) {
			if (other.idPlanejamento != null)
				return false;
		} else if (!idPlanejamento.equals(other.idPlanejamento))
			return false;
		return true;
	}

}
