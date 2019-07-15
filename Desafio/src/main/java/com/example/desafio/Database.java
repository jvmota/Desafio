package com.example.desafio;

public interface Database {
	
	public void openConnection();
	public EntityTarefa saveTarefa(EntityTarefa tarefa);
	public EntityTarefa loadTarefa(Integer ID);
	public void closeConnection();

}
