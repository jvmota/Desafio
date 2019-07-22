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
 
    constructor(private tarefaService: TarefaService,
                private router: Router){}
 
    ngOnInit() {
 
      /*SETA O TÍTULO */
      this.titulo = "Registros Cadastrados";
 
      /*CHAMA O SERVIÇO E RETORNA TODAS AS PESSOAS CADASTRADAS */
      this.tarefaService.getTarefas().subscribe(res => this.tarefas = res);
	  
	  this.mostrar = 0;
    }
	
	mostrarTipo(tipo: number): void{
		this.mostrar = tipo;
		console.log(this.mostrar);
	}
 
    /**EXCLUI UM REGISTRO QUANDO CLICAMOS NA OPÇÃO EXCLUIR DE UMA 
     * LINHA DA TABELA
    excluir(codigo:number, index:number):void {
 
      if(confirm("Deseja realmente excluir esse registro?")){
 
        /*CHAMA O SERVIÇO PARA REALIZAR A EXCLUSÃO 
        this.pessoaService.excluirPessoa(codigo).subscribe(response => {
 
              /**PEGA O RESPONSE DO SERVIÇO 
              let res:Response = <Response>response;
 
              /*1 = SUCESSO
              * MOSTRAMOS A MENSAGEM RETORNADA PELO SERVIÇO E DEPOIS REMOVEMOS
              O REGISTRO DA TABELA HTML
              if(res.codigo == 1){
                alert(res.mensagem);
                this.pessoas.splice(index,1);
              }
              else{
                /*0 = EXCEPTION GERADA NO SERVIÇO JAVA 
                alert(res.mensagem);
              }
          },
          (erro) => {                    
               /*MOSTRA ERROS NÃO TRATADOS 
               alert(erro);
          });        
      }
 
    }
 
    editar(codigo:number):void{
 
      this.router.navigate(['/cadastro-pessoa',codigo]);
 
    }*/
	atualizar(codigo: number): void {
		this.router.navigate(['/atualiza-tarefa', codigo]);
	}
	
	assimilaCodigo (cod: number): void{
		this.codigo = cod;
	}
	
	buscarSRC(cod: number): string{
		this.tarefaService.getFotoSrc(cod).subscribe(res => this.src = res);
		return this.src;
	}
  }