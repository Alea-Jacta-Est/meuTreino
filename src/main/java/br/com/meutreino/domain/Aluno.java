package br.com.meutreino.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotBlank;

@Entity
public class Aluno implements Serializable {

	private static final long serialVersionUID = -781058200732224433L;

	@SequenceGenerator(name="alunoGenerator",sequenceName = "ALUNO_SEQ", allocationSize = 10)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alunoGenerator")
	private Long idAluno;

	@NotBlank
	private String nome;

	private LocalDate dataNascimento;

	@NotBlank
	private String email;

	@NotBlank
	private String telefone;

	private LocalDate dataCadastro;
	
	@Transient
	private int idade;

	@Version
	private Integer versao;

	@OneToMany(mappedBy = "idAluno", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<Contrato> contratos;

	@OneToMany(mappedBy = "idAluno", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<Treino> treinos;

	public Aluno() {
		super();
	}

	public Aluno(Long idAluno, String nome, LocalDate dataNascimento, String email, String telefone,
			LocalDate dataCadastro, Integer versao, Set<Contrato> contratos, Set<Treino> treinos) {
		super();
		this.idAluno = idAluno;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.telefone = telefone;
		this.dataCadastro = dataCadastro;
		this.versao = versao;
		this.contratos = contratos;
		this.treinos = treinos;
	}

	public Long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getIdade() {
		return Period.between(dataNascimento, LocalDate.now()).getYears();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Integer getVersao() {
		return versao;
	}

	public void setVersao(Integer versao) {
		this.versao = versao;
	}

	public Set<Contrato> getContratos() {
		return contratos;
	}

	public void setContratos(Set<Contrato> contratos) {
		this.contratos = contratos;
	}

	public Set<Treino> getTreinos() {
		return treinos;
	}

	public void setTreinos(Set<Treino> treinos) {
		this.treinos = treinos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((idAluno == null) ? 0 : idAluno.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
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
		Aluno other = (Aluno) obj;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idAluno == null) {
			if (other.idAluno != null)
				return false;
		} else if (!idAluno.equals(other.idAluno))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		if (versao == null) {
			if (other.versao != null)
				return false;
		} else if (!versao.equals(other.versao))
			return false;
		return true;
	}

}
