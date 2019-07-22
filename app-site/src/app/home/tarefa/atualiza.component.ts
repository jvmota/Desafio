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
	rota: string = 'http://localhost:8080/uploadFotos';
	id: string;
	constructor(private http: HttpClient, private route: ActivatedRoute){
		this.route.params.subscribe( params => this.id = params['id']);
		this.rota = this.rota + '/' + this.id;
		console.log(this.rota);
	}
				
	InputFileChange(event){
		if(event.target.files && event.target.files[0]){
			const foto = event.target.files[0];
			const formData = new FormData();
			formData.append('foto', foto);
			this.http.post(this.rota, formData).subscribe(resposta => console.log('Upload ok'));
		}
		
	}
}