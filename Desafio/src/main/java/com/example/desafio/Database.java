package com.example.desafio;

import java.util.List;

public interface Database {
	
	public void openConnection();
	public EntityTarefa saveTarefa(EntityTarefa tarefa);
	public EntityTarefa loadTarefa(Integer ID);
	public void closeConnection();
	public List<EntityTarefa> retornaTarefas();

}
