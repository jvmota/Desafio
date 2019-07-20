import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { HomeComponent } from './home/home.component';
import { CadastroComponent } from './home/tarefa/cadastro.component';
import { ConsultaComponent } from './home/tarefa/consulta.component';

import { routing } from './../app.routes';

import { ConfigService } from './services/config.service';
import { TarefaService } from './services/tarefa.service';

@NgModule({
  declarations: [
    AppComponent,
	MenuComponent,
	HomeComponent,
	CadastroComponent,
	ConsultaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
	HttpModule,
	FormsModule,
	routing
  ],
  providers: [ConfigService, TarefaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
