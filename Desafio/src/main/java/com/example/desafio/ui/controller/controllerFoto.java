package com.example.desafio.ui.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.desafio.model.Tarefa;
import com.example.desafio.service.TarefasService;
import com.example.desafio.service.TarefasServiceImp;

@RestController
public class controllerFoto {
	

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "uploadFotos/{id}")
	@PostMapping
	public String SalvaFoto(@PathVariable("id") Integer ID, @RequestParam MultipartFile foto) throws IOException{
		TarefasService servico = new TarefasServiceImp();
		Tarefa tarefa = servico.loadTarefa(ID);
		String caminho = System.getProperty("user.dir") + "\\uploads\\tarefa" + ID + ".png";
		File fileFoto = new File(caminho);
		foto.transferTo(fileFoto);
		tarefa.setImgSrc(caminho);
		tarefa.setConcluido(true);
		servico.atualizaTarefa(tarefa, ID);
		return "Ok";
	}
	
	@RequestMapping(value = "/Imagem/{id}")
	@GetMapping
	public ResponseEntity<byte[]> getImage(@PathVariable("id") Integer id) throws IOException{
		TarefasService servico = new TarefasServiceImp();
		Tarefa tarefa = servico.loadTarefa(id);
	    File imagem = new File(tarefa.getImgSrc());
		byte[] image = Files.readAllBytes(imagem.toPath());;
	    return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
	}

}
