import { Component } from '@angular/core';
import { Card } from '../card/card';
import { Funcionario } from '../models/funcionario';
import { FUNCIONARIOS } from '../models/funcionarios-dados';

@Component({
  selector: 'app-funcionarios',
  imports: [Card],
  templateUrl: './funcionarios.html',
  styleUrl: './funcionarios.css',
})
export class Funcionarios {
  funcionarios: Funcionario[] = FUNCIONARIOS;
}