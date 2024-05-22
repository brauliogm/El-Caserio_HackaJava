import { Component } from '@angular/core';

@Component({
  selector: 'app-pedido',
  templateUrl: './pedido.component.html',
  styleUrls: ['./pedido.component.css']
})
export class PedidoComponent {

  marcador: number = 3;

  constructor(){

  }

  ngInit(){
  }

  sumarMarcador(){
    this.marcador++;
  }

  restarMarcador(){
    this.marcador--;
  }
}
