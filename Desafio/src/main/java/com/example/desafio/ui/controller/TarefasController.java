package com.example.desafio.ui.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafio.model.EntityTarefa;
import com.example.desafio.model.Tarefa;
import com.example.desafio.model.TarefaDTO;
import com.example.desafio.service.TarefasService;
import com.example.desafio.service.TarefasServiceImp;

@RestController
@RequestMapping("tarefas") //http://localhost:8080/tarefas
public class TarefasController {	
	@CrossOrigin(origins = "*")
	@PostMapping
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON/*, MediaType.APPLICATION_XML*/})
	public void criarTarefa(@RequestBody Tarefa tarefa) {
		Tarefa retornaTarefa = null;
		TarefaDTO tarefadto = new TarefaDTO();
		BeanUtils.copyProperties(tarefa, tarefadto);
		TarefasService servico = new TarefasServiceImp();
		tarefadto.setConcluido(false);
		Tarefa tarefaArmazenada = servico.saveTarefa(tarefadto);
		System.out.println(tarefa.getConcluido());
		if(tarefaArmazenada != null && !tarefaArmazenada.getNome().isEmpty()) {
			retornaTarefa = new Tarefa();
			BeanUtils.copyProperties(tarefaArmazenada, retornaTarefa);
		}
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON/*, MediaType.APPLICATION_XML*/})
	public List<EntityTarefa> carregarTarefas(){
		TarefasService servico = new TarefasServiceImp();
		List<EntityTarefa> tarefas = servico.loadTarefas();
		return tarefas;
	}

}
