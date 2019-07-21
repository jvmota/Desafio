import { ModuleWithProviders }  from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
 
 
import { ConsultaComponent } from './app/home/tarefa/consulta.component';
 
import { CadastroComponent } from './app/home/tarefa/cadastro.component';
 
import { HomeComponent } from './app/home/home.component';

import { AtualizaComponent } from './app/home/tarefa/atualiza.component';
 
const appRoutes: Routes = [
    { path: 'home',                    component: HomeComponent },
    { path: '',                        component: HomeComponent },
    { path: 'consulta-tarefa',         component: ConsultaComponent },
    { path: 'cadastro-tarefa',         component: CadastroComponent },
    { path: 'atualiza-tarefa',		   component: AtualizaComponent }
 
];
 
export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);