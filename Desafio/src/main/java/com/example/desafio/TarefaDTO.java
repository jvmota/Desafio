package com.example.desafio;

import java.sql.Blob;

//import java.io.File;

public class TarefaDTO {
	//atributos da tarefa
	private boolean concluido = false;
	private String nome;
	private String imgSrc;
	
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

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
}