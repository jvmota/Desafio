package com.example.desafio.ui.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	/*@RequestMapping(value = "/")
	public String index() {
		return "index";
	}
	/*@GetMapping
	public Tarefa getTarefas(@RequestParam(value="page", defaultValue = "1") int page) {
		Tarefa novaTarefa = new Tarefa();
		return novaTarefa;
	}
	
	@GetMapping(path="/{tarefaID}")
	public String getTarefa(@PathVariable String tarefaID) {
		return "Retorna Tarefa com id = " + tarefaID;
	}*/
	
	@CrossOrigin(origins = "*")
	@PostMapping
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON/*, MediaType.APPLICATION_XML*/})
	public String criarTarefa(@RequestBody Tarefa tarefa) {
		Tarefa retornaTarefa = null;
		TarefaDTO tarefadto = new TarefaDTO();
		BeanUtils.copyProperties(tarefa, tarefadto);
		if(tarefa.getConcluido()) {
			System.out.println("Oláaaaaaa");
		};
		TarefasService servico = new TarefasServiceImp();
		tarefadto.setConcluido(false);
		Tarefa tarefaArmazenada = servico.saveTarefa(tarefadto);
		System.out.println(tarefa.getConcluido());
		if(tarefaArmazenada != null && !tarefaArmazenada.getNome().isEmpty()) {
			retornaTarefa = new Tarefa();
			BeanUtils.copyProperties(tarefaArmazenada, retornaTarefa);
		}
		return "Requisição post";
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON/*, MediaType.APPLICATION_XML*/})
	/*public Tarefa carregarTarefa() {
		Integer ID = 11;
		System.out.println(ID);
		Tarefa retornaTarefa = new Tarefa();
		TarefasService servico = new TarefasServiceImp();
		retornaTarefa = servico.loadTarefa(ID);
		System.out.println(retornaTarefa.getNome());
		return retornaTarefa;
	}*/
	public List<EntityTarefa> carregarTarefas(){
		TarefasService servico = new TarefasServiceImp();
		List<EntityTarefa> tarefas = servico.loadTarefas();
		return tarefas;
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
