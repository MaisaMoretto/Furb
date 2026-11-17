import { Component, Input } from '@angular/core';
import { Funcionario } from '../models/funcionario';

@Component({
  selector: 'app-card',
  imports: [],
  templateUrl: './card.html',
  styleUrl: './card.css',
})
export class Card {
  @Input({ required: true }) funcionario!: Funcionario;
}