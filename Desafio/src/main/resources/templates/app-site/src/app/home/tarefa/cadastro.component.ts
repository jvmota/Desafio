import { Component, OnInit } from '@angular/core';
 
import {Router} from '@angular/router';
import { ActivatedRoute } from '@angular/router';
 
import {TarefaService} from '../../services/tarefa.service';
 
import {Tarefa} from '../../services/tarefa';

import {Resposta} from '../../services/resposta';
 
import { Observable } from 'rxjs/Observable';
 
@Component({
    selector: 'cadastro-tarefa',
    templateUrl: './cadastro.component.html',
    styleUrls:["./cadastro.component.css"]
  })
  
  export class CadastroComponent implements OnInit {
 
    private mensagem:string = "Nova Tarefa";
    private tarefa:Tarefa = new Tarefa();
 
    constructor(private tarefaService: TarefaService,
                private router: Router,
                private activatedRoute: ActivatedRoute){}
 
    /*CARREGADO NA INICIALIZAÇÃO DO COMPONENTE */
    ngOnInit() {
          this.mensagem = "Nova tarefa";
		  console.log("Teste");
    }
 
    /*FUNÇÃO PARA SALVAR UM NOVO REGISTRO OU ALTERAÇÃO EM UM REGISTRO EXISTENTE */
    salvar():void {
		console.log("Teste de envio");
        this.tarefaService.addTarefa(this.tarefa).subscribe(resposta => {
 
           //PEGA O RESPONSE DO RETORNO DO SERVIÇO
           let res:Resposta = <Resposta>resposta;
		   alert(res.mensagem);
		},(erro) => {   
           /**AQUI VAMOS MOSTRAR OS ERROS NÃO TRATADOS
             EXEMPLO: SE APLICAÇÃO NÃO CONSEGUIR FAZER UMA REQUEST NA API                        */                 
            alert(erro);
         });
    }
 
  }

