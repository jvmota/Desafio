package com.example.desafio.service;

import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.BeanUtils;

import com.example.desafio.model.EntityTarefa;
import com.example.desafio.model.Tarefa;
import com.example.desafio.model.TarefaDTO;

public class TarefasServiceImp implements TarefasService{

	Database database = new mySQLDAO();
	
	@Override
	public Tarefa saveTarefa(TarefaDTO tarefa) {
		Tarefa retornaTarefa = null;
		
		EntityTarefa entidade = new EntityTarefa();
		BeanUtils.copyProperties(tarefa, entidade);
		
		try {
			this.database.openConnection();
			EntityTarefa tarefaArmazenada = this.database.saveTarefa(entidade);
			if(tarefaArmazenada != null && tarefaArmazenada.getTarefaID() > 0) {
				retornaTarefa = new Tarefa();
				BeanUtils.copyProperties(tarefaArmazenada, retornaTarefa);
			} 
		}finally {
			this.database.closeConnection();
		}
		
		return retornaTarefa;
	}
	
	@Override
	public Tarefa loadTarefa(Integer ID) {
		Tarefa retornaTarefa = null;
		
		EntityTarefa entidade = new EntityTarefa();
		
		try {
			this.database.openConnection();
			entidade = this.database.loadTarefa(ID);
		}catch(ObjectNotFoundException e) {
			System.out.println("Tarefa Não Encontrada");
			entidade = null;
		}finally {
			this.database.closeConnection();
		}
		
		retornaTarefa = new Tarefa();
		BeanUtils.copyProperties(entidade, retornaTarefa);
		return retornaTarefa;
	}

	@Override
	public List<EntityTarefa> loadTarefas() {
		List<EntityTarefa> tarefas = null;
		try {
			this.database.openConnection();
			tarefas = database.retornaTarefas();
		}finally {
			this.database.closeConnection();
		}
		return tarefas;
	}

	@Override
	public EntityTarefa atualizaTarefa(Tarefa tarefa, Integer ID) {
		EntityTarefa retornaTarefa = null;
		try {
			this.database.openConnection();
			retornaTarefa = this.database.atualizaTarefa(tarefa, ID);
		}finally {
			this.database.closeConnection();
		}
		return retornaTarefa;
	}

}
