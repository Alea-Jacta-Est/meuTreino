package br.com.meutreino.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class PlanejamentoAula implements Serializable {

	private static final long serialVersionUID = 2968611034961584180L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPlanejamento;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "idProfessor", nullable = false)
	private Professor professor;

	private LocalDate dataCadastro;

	@OneToMany(mappedBy = "planejamentoAula", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<AulaExercicio> aulaExercicios;

	public PlanejamentoAula() {
		super();
	}

	public PlanejamentoAula(Long idPlanejamento, Professor professor, LocalDate dataCadastro,
			Set<AulaExercicio> aulaExercicios) {
		super();
		this.idPlanejamento = idPlanejamento;
		this.professor = professor;
		this.dataCadastro = dataCadastro;
		this.aulaExercicios = aulaExercicios;
	}

	public Long getIdPlanejamento() {
		return idPlanejamento;
	}

	public void setIdPlanejamento(Long idPlanejamento) {
		this.idPlanejamento = idPlanejamento;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Set<AulaExercicio> getAulaExercicios() {
		return aulaExercicios;
	}

	public void setAulaExercicios(Set<AulaExercicio> aulaExercicios) {
		this.aulaExercicios = aulaExercicios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aulaExercicios == null) ? 0 : aulaExercicios.hashCode());
		result = prime * result + ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + ((idPlanejamento == null) ? 0 : idPlanejamento.hashCode());
		result = prime * result + ((professor == null) ? 0 : professor.hashCode());
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
		PlanejamentoAula other = (PlanejamentoAula) obj;
		if (aulaExercicios == null) {
			if (other.aulaExercicios != null)
				return false;
		} else if (!aulaExercicios.equals(other.aulaExercicios))
			return false;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (idPlanejamento == null) {
			if (other.idPlanejamento != null)
				return false;
		} else if (!idPlanejamento.equals(other.idPlanejamento))
			return false;
		if (professor == null) {
			if (other.professor != null)
				return false;
		} else if (!professor.equals(other.professor))
			return false;
		return true;
	}

}
