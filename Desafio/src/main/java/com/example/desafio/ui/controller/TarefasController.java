package com.example.desafio.ui.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tarefas") //http://localhost:8080/tarefas
public class TarefasController {
	
	@GetMapping
	public String getTarefa() {
		return "Retorna Tarefa";
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
