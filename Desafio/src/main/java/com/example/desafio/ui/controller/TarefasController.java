package com.example.desafio.ui.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafio.*;

@RestController
@RequestMapping("tarefas") //http://localhost:8080/tarefas
public class TarefasController {
	
	/*@GetMapping
	public Tarefa getTarefas(@RequestParam(value="page", defaultValue = "1") int page) {
		Tarefa novaTarefa = new Tarefa();
		return novaTarefa;
	}
	
	@GetMapping(path="/{tarefaID}")
	public String getTarefa(@PathVariable String tarefaID) {
		return "Retorna Tarefa com id = " + tarefaID;
	}*/
	
	@PostMapping
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Tarefa criarTarefa(@RequestBody Tarefa tarefa) {
		Tarefa retornaTarefa = null;
		TarefaDTO tarefadto = new TarefaDTO();
		BeanUtils.copyProperties(tarefa, tarefadto);
		TarefasService servico = new TarefasServiceImp();
		Tarefa tarefaArmazenada = servico.saveTarefa(tarefadto);
		System.out.println("Teste de verificacao");
		if(tarefaArmazenada != null && !tarefaArmazenada.getNome().isEmpty()) {
			retornaTarefa = new Tarefa();
			BeanUtils.copyProperties(tarefaArmazenada, retornaTarefa);
		}
		return tarefa;
	}
	
	@GetMapping
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String carregarTarefa() {
		Integer ID = 11;
		System.out.println(ID);
		Tarefa retornaTarefa = new Tarefa();
		TarefasService servico = new TarefasServiceImp();
		retornaTarefa = servico.loadTarefa(ID);
		System.out.println(retornaTarefa.getNome());
		return retornaTarefa.getNome();
	}
	
	/*@PutMapping
	public String atualizaTarefa() {
		return "atualiza tarefa";
	}
	
	@DeleteMapping
	public String deletarTarefa() {
		return "Apagar tarefa";
	}*/

}
