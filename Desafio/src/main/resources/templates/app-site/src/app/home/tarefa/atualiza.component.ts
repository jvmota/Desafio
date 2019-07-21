import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
 
import {Router} from '@angular/router';
import { ActivatedRoute } from '@angular/router';
 
import {TarefaService} from '../../services/tarefa.service';
 
import {Tarefa} from '../../services/tarefa';

import {Resposta} from '../../services/resposta';
 
import { Observable } from 'rxjs/Observable';

@Component({
    selector: 'atualiza-tarefa',
    templateUrl: './atualiza.component.html',
    styleUrls:["./consulta.component.css"]
  })
	
export class AtualizaComponent {
	constructor(private http: HttpClient){
		
	}
				
	InputFileChange(event){
		if(event.target.files && event.target.files[0]){
			const foto = event.target.files[0];
			const formData = new FormData();
			formData.append('foto', foto);
			this.http.post('http://localhost:8080/testeFotos', formData).subscribe(resposta => console.log('Upload ok'));
		}
		
	}
}