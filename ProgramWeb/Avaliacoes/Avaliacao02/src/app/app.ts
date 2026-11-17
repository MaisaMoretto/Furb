import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Cabecalho } from './cabecalho/cabecalho';
import { Menu } from './menu/menu';
import { Rodape } from './rodape/rodape';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Cabecalho, Menu, Rodape],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {

}