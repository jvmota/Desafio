package com.example.desafio.ui.controller;

import com.example.desafio.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.BeanUtils;;

@Path("tarefas")
public class tarefasRest {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public TarefaDTO criarTarefa(TarefaDTO tarefa) {
		System.out.println("Até aqui foi");
		Tarefa retornaTarefa = null;
		TarefasService servico = new TarefasServiceImp();
		Tarefa tarefaArmazenada = servico.saveTarefa(tarefa);
		if(tarefaArmazenada != null && !tarefaArmazenada.getNome().isEmpty()) {
			retornaTarefa = new Tarefa();
			BeanUtils.copyProperties(tarefaArmazenada, retornaTarefa);
		}
		return tarefa;
	}

}
