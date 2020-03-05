package br.com.meutreino.domain.dto;

import java.time.LocalDate;

public class AlunoDTO {
	
	private Long idAluno;

	private String nome;

	private LocalDate dataNascimento;

	private String email;

	private String telefone;

	private LocalDate dataCadastro;
	
	private int idade;

	private Integer versao;

	public AlunoDTO() {
		super();
	}

	public AlunoDTO(Long idAluno, String nome, LocalDate dataNascimento, String email, String telefone,
			LocalDate dataCadastro, int idade, Integer versao) {
		super();
		this.idAluno = idAluno;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.telefone = telefone;
		this.dataCadastro = dataCadastro;
		this.idade = idade;
		this.versao = versao;
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

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Integer getVersao() {
		return versao;
	}

	public void setVersao(Integer versao) {
		this.versao = versao;
	}	
		
}
