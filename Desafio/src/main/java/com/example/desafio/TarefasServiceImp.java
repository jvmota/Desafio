package com.example.desafio;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.BeanUtils;

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

}
