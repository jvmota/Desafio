package com.example.desafio.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity(name="tarefa")
public class EntityTarefa implements Serializable{
	private static final long serialVersionUID = 729079895339435234L;
	
	//atributos da tarefa
	@Id
	@GeneratedValue
	private Integer tarefaID;
	private boolean concluido;
	private String nome;
	private String imgSrc;
	
	public Integer getTarefaID() {
		return tarefaID;
	}
	public void setTarefaID(Integer tarefaID) {
		this.tarefaID = tarefaID;
	}
	public boolean isConcluido() {
		return concluido;
	}
	public void setConcluido(boolean concluido) {
		this.concluido = concluido;
	}
	public String getNome() {
		return nome;
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
