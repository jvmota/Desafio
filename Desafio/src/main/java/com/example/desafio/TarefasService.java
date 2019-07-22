package com.example.desafio;

import java.util.List;

public interface TarefasService {
	
	public Tarefa saveTarefa(TarefaDTO tarefa);
	public Tarefa loadTarefa(Integer ID);
	public List<EntityTarefa> loadTarefas();
	public EntityTarefa atualizaTarefa(Tarefa tarefa, Integer ID);

}
