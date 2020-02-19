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
import javax.persistence.OneToMany;

@Entity
public class PlanejamentoAula implements Serializable {

	private static final long serialVersionUID = 2968611034961584180L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPlanejamento;

	private Long idProfessor;

	private LocalDate dataCadastro;

	@OneToMany(mappedBy = "idPlanejamento", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<AulaExercicio> aulaExercicios;
	
	@OneToMany(mappedBy = "idPlanejamento", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Treino> treinos;	

	public PlanejamentoAula() {
		super();
	}

	public PlanejamentoAula(Long idPlanejamento, Long idProfessor, LocalDate dataCadastro,
			Set<AulaExercicio> aulaExercicios) {
		super();
		this.idPlanejamento = idPlanejamento;
		this.idProfessor = idProfessor;
		this.dataCadastro = dataCadastro;
		this.aulaExercicios = aulaExercicios;
	}

	public Long getIdPlanejamento() {
		return idPlanejamento;
	}

	public void setIdPlanejamento(Long idPlanejamento) {
		this.idPlanejamento = idPlanejamento;
	}

	public Long getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(Long idProfessor) {
		this.idProfessor = idProfessor;
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
		result = prime * result + ((idProfessor == null) ? 0 : idProfessor.hashCode());
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
		if (idProfessor == null) {
			if (other.idProfessor != null)
				return false;
		} else if (!idProfessor.equals(other.idProfessor))
			return false;
		return true;
	}

}
