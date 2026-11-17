import { Routes } from '@angular/router';
import { Home } from './home/home';
import { Funcionarios } from './funcionarios/funcionarios';

export const routes: Routes = [
    { path: '', component: Home },
    { path: 'funcionarios', component: Funcionarios },
    { path: '**', redirectTo: '' }
];