import { Component } from '@angular/core';

@Component({
  selector: 'app-pedido',
  templateUrl: './pedido.component.html',
  styleUrls: ['./pedido.component.css']
})
export class PedidoComponent {

  pedido: boolean = false;
  datos: boolean = true;
  resumen: boolean = false;
  marcador: number = 1;

  constructor(){

  }

  ngInit(){
  }

  ventanaDatos(){
    this.datos = !this.datos;
    this.pedido = !this.pedido;
  }

  ventanaResumen(){
    this.resumen = !this.resumen;
    this.datos = !this.datos;
  }

  sumarMarcador(){
    this.marcador++;
  }

  restarMarcador(){
    this.marcador--;
  }
}
