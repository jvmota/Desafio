package com.example.desafio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("testeFotos")
public class controllerFoto {
	@Autowired
	private HttpServletRequest request;
	
	@CrossOrigin(origins = "*")
	@PostMapping
	@Consumes(MediaType.APPLICATION_JSON)
	public String SalvaFoto(@RequestParam MultipartFile foto) throws IOException{
		String uploadsDir = "/uploads/";
        String realPathtoUploads =  request.getServletContext().getRealPath(uploadsDir);
        if(! new File(realPathtoUploads).exists())
        {
            new File(realPathtoUploads).mkdir();
        }

        String orgName = foto.getOriginalFilename();
        String filePath = realPathtoUploads + orgName;
        System.out.println(filePath);
        File dest = new File(filePath);
        foto.transferTo(dest);
		return "Ok";
	}

}
