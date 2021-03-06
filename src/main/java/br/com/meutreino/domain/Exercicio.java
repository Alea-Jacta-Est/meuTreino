package br.com.meutreino.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Exercicio implements Serializable {

	private static final long serialVersionUID = -6631064849055593898L;

	@SequenceGenerator(name="exercicioGenerator",sequenceName = "EXERCICIO_SEQ", allocationSize = 10)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exercicioGenerator")
	private Long idExercicio;

	@NotEmpty(message = "O nome não pode ser vazio!")
	@Size(min=3, max=60, message = "Tamanho máximo para o nome é de 60 caracteres")
	private String nome;

	@NotEmpty(message = "O grupo muscular não pode ser vazio!")
	@Size(max=20)
	private String grupoMuscular;

	@NotNull
	private LocalDate dataCadastro;

	public Exercicio() {
		super();
	}

	public Exercicio(Long idExercicio, String nome, String grupoMuscular, LocalDate dataCadastro) {
		super();
		this.idExercicio = idExercicio;
		this.nome = nome;
		this.grupoMuscular = grupoMuscular;
		this.dataCadastro = dataCadastro;
	}

	public Long getIdExercicio() {
		return idExercicio;
	}

	public void setIdExercicio(Long idExercicio) {
		this.idExercicio = idExercicio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGrupoMuscular() {
		return grupoMuscular;
	}

	public void setGrupoMuscular(String grupoMuscular) {
		this.grupoMuscular = grupoMuscular;
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
		result = prime * result + ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + ((grupoMuscular == null) ? 0 : grupoMuscular.hashCode());
		result = prime * result + ((idExercicio == null) ? 0 : idExercicio.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Exercicio other = (Exercicio) obj;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (grupoMuscular == null) {
			if (other.grupoMuscular != null)
				return false;
		} else if (!grupoMuscular.equals(other.grupoMuscular))
			return false;
		if (idExercicio == null) {
			if (other.idExercicio != null)
				return false;
		} else if (!idExercicio.equals(other.idExercicio))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
