package com.example.desafio.service;

import java.util.List;

import com.example.desafio.model.EntityTarefa;
import com.example.desafio.model.Tarefa;

public interface Database {
	
	public void openConnection();
	public EntityTarefa saveTarefa(EntityTarefa tarefa);
	public EntityTarefa loadTarefa(Integer ID);
	public void closeConnection();
	public List<EntityTarefa> retornaTarefas();
	public EntityTarefa atualizaTarefa(Tarefa tarefa, Integer ID);

}
