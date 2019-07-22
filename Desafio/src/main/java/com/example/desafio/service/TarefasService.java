package com.example.desafio.service;

import java.util.List;

import com.example.desafio.model.EntityTarefa;
import com.example.desafio.model.Tarefa;
import com.example.desafio.model.TarefaDTO;

public interface TarefasService {
	
	public Tarefa saveTarefa(TarefaDTO tarefa);
	public Tarefa loadTarefa(Integer ID);
	public List<EntityTarefa> loadTarefas();
	public EntityTarefa atualizaTarefa(Tarefa tarefa, Integer ID);

}
