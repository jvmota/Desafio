package com.example.desafio;

//import java.io.File;

public class TarefaDTO {
	//atributos da tarefa
	private boolean concluido = false;
	private String nome;
	private String descricao;
	//private File foto;
	
	/*public File getFoto() {
		return foto;
	}

	public void setFoto(File foto) {
		this.foto = foto;
	}*/
	
	public boolean getConcluido() {
		return this.concluido;
	}
	
	public void setConcluido(boolean status) {
		this.concluido = status;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}