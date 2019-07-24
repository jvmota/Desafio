package com.example.desafio.ui.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	
	@RequestMapping("AppEnter")
	@CrossOrigin
	public void retornaOK() {
	}

}
