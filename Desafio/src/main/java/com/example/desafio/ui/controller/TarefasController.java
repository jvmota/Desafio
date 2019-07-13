package com.example.desafio.ui.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafio.Tarefa;

@RestController
@RequestMapping("tarefas") //http://localhost:8080/tarefas
public class TarefasController {
	
	@GetMapping
	public Tarefa getTarefas(@RequestParam(value="page", defaultValue = "1") int page) {
		Tarefa novaTarefa = new Tarefa(1, "nome", "descrição");
		return novaTarefa;
	}
	
	@GetMapping(path="/{tarefaID}")
	public String getTarefa(@PathVariable String tarefaID) {
		return "Retorna Tarefa com id = " + tarefaID;
	}
	
	@PostMapping
	public String criarTarefa() {
		return "Criar tarefa";
	}
	
	@PutMapping
	public String atualizaTarefa() {
		return "atualiza tarefa";
	}
	
	@DeleteMapping
	public String deletarTarefa() {
		return "Apagar tarefa";
	}

}
