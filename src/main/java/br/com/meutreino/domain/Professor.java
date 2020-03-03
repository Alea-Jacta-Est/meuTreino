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
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

@Entity
public class Professor implements Serializable {

	private static final long serialVersionUID = 3352885807072052668L;

	@SequenceGenerator(name="professorGenerator",sequenceName = "PROFESSOR_SEQ", allocationSize = 10)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "professorGenerator")
	private Long idProfessor;

	private String nome;

	private String telefone;

	private String email;

	private LocalDate dataCadastro; 

	@Version
	private Integer versao;

	@OneToMany(mappedBy = "idProfessor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Contrato> contratos;

	@OneToMany(mappedBy = "idProfessor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<PlanejamentoAula> planejamentoAulas;

	public Professor() {
		super();
	}

	public Professor(Long idProfessor, String nome, String telefone, String email, LocalDate dataCadastro,
			Integer versao, Set<Contrato> contratos, Set<PlanejamentoAula> planejamentoAulas) {
		super();
		this.idProfessor = idProfessor;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.dataCadastro = dataCadastro;
		this.versao = versao;
		this.contratos = contratos;
		this.planejamentoAulas = planejamentoAulas;
	}

	public Long getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(Long idProfessor) {
		this.idProfessor = idProfessor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Set<PlanejamentoAula> getPlanejamentoAulas() {
		return planejamentoAulas;
	}

	public void setPlanejamentoAulas(Set<PlanejamentoAula> planejamentoAulas) {
		this.planejamentoAulas = planejamentoAulas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((idProfessor == null) ? 0 : idProfessor.hashCode());
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
		Professor other = (Professor) obj;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idProfessor == null) {
			if (other.idProfessor != null)
				return false;
		} else if (!idProfessor.equals(other.idProfessor))
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
