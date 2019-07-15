package com.example.desafio;

//import java.io.File;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity(name="tarefa")
public class EntityTarefa implements Serializable{
	private static final long serialVersionUID = 729079895339435234L;
	
	//atributos da tarefa
	@Id
	@GeneratedValue/*(
	    strategy= GenerationType.AUTO,
	    generator="native"
	)
	@GenericGenerator(
	    name = "native",
	    strategy = "native"
	)*/
	private Integer tarefaID;
	private boolean concluido;
	private String nome;
	private String descricao;
	/*private File foto;
	
	public File getFoto() {
		return foto;
	}

	public void setFoto(File foto) {
		this.foto = foto;
	}*/
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



}
