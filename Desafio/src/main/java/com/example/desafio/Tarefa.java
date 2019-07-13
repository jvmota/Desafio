package com.example.desafio;

public class Tarefa {
	//atributos da tarefa
	private int tarefaID;
	private boolean concluido;
	private String nome;
	private String descricao;
	
	//construtor
	public Tarefa(int id, String nome, String descricao) {
		this.tarefaID = id;
		this.concluido = false;
		this.nome = nome;
		this.descricao = descricao;
	}
	
	//metodos get e set
	public int getID() {
		return this.tarefaID;
	}
	
	public void setID(int id) {
		this.tarefaID = id;
	}
	
	public boolean getStatus() {
		return this.concluido;
	}
	
	public void setStatus(boolean status) {
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
