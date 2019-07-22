import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Headers } from '@angular/http';
import { RequestOptions } from '@angular/http';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch';
import { Observable } from 'rxjs/Rx';

import {Tarefa} from './Tarefa';
import {ConfigService} from './config.service';

@Injectable()
export class TarefaService {
	private baseUrlService:string = '';
	private headers: Headers;
	private options: RequestOptions;
	
	constructor (private http: Http, private configService: ConfigService){
		//setar url
		this.baseUrlService = configService.getUrlService();
		
		//adicionar o json no header
		this.headers = new Headers({'Content-Type': 'application/json;'});
		this.options = new RequestOptions({headers: this.headers});
	}
	
	//adiciona tarefa
	addTarefa(tarefa: Tarefa){
		console.log(this.baseUrlService);
		return this.http.post(this.baseUrlService, JSON.stringify(tarefa), this.options).map(res => res.json());
	}
	
	getTarefas(){        
        return this.http.get(this.baseUrlService).map(res => res.json());
    }
	
	getFotoSrc(codigo: number){
		return this.http.get("http://localhost:8080/testeFotos/" + codigo).map(res => res.json());
	}
}