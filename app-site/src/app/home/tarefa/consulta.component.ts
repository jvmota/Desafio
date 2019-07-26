import { Component, OnInit } from '@angular/core';
 
import {Router} from '@angular/router';
import { ActivatedRoute } from '@angular/router';
 
import {TarefaService} from '../../services/tarefa.service';
 
import {Tarefa} from '../../services/tarefa';
 
import {Resposta} from '../../services/resposta';
 
@Component({
    selector: 'consulta-tarefa',
    templateUrl: './consulta.component.html',
    styleUrls:["./consulta.component.css"]
  })
  export class ConsultaComponent implements OnInit {
 
    private tarefas: Tarefa[] = new Array();
	private mostrar: number;
    private titulo:string;
	private src: string;
	private codigo: number;
	private mostrarimg: boolean;
 
    constructor(private tarefaService: TarefaService,
                private router: Router){}
 
    ngOnInit() {
 
      /*SETA O TÍTULO */
      this.titulo = "Tarefas Cadastradas";
 
      /*CHAMA O SERVIÇO E RETORNA TODAS AS TAREFAS CADASTRADAS */
      this.tarefaService.getTarefas().subscribe(res => this.tarefas = res);
	  
	  this.mostrar = 0;
	  for(let tarefa of this.tarefas){
		  tarefa.tarefaShow = false;
	  }
	  this.mostrarimg = true;
    }
	
	mostrarTipo(tipo: number): void{
		this.mostrar = tipo;
		console.log(this.mostrar);
	}
	
	assimilaCodigo (cod: number): void{
		this.codigo = cod;
	}
	
	buscarSRC(cod: number): string{
		this.tarefaService.getFotoSrc(cod).subscribe(res => this.src = res);
		return this.src;
	}
	
	mostrarEsconder(tarefa: Tarefa): void{
		tarefa.tarefaShow = !tarefa.tarefaShow;
	}
  }