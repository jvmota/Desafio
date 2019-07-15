package com.example.desafio;

public interface TarefasService {
	
	public Tarefa saveTarefa(TarefaDTO tarefa);
	public Tarefa loadTarefa(Integer ID);

}
