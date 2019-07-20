import { ModuleWithProviders }  from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
 
 
import { ConsultaComponent } from './app/home/tarefa/consulta.component';
 
import {CadastroComponent} from './app/home/tarefa/cadastro.component';
 
import { HomeComponent } from './app/home/home.component';
 
const appRoutes: Routes = [
    { path: 'home',                    component: HomeComponent },
    { path: '',                        component: HomeComponent },
    { path: 'consulta-tarefa',         component: ConsultaComponent },
    { path: 'cadastro-tarefa',         component: CadastroComponent }
    //{ path: 'cadastro-pessoa/:codigo', component: CadastroComponent }
 
];
 
export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);