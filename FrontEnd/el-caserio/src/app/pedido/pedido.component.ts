import { Component } from '@angular/core';
import { Producto } from '../models/producto';
import { CarritoService } from '../services/carrito.service';

@Component({
  selector: 'app-pedido',
  templateUrl: './pedido.component.html',
  styleUrls: ['./pedido.component.css']
})
export class PedidoComponent {

  marcador: number = 1;
  listaDeProductos: Array<Producto> = [];

  constructor(
    private carritoServise: CarritoService,
  ){}

  ngOnInit(){
    this.listaDeProductos = this.carritoServise.listaProductos;
  }

  sumarMarcador(){
    this.marcador++;
  }

  restarMarcador(){
    this.marcador--;
  }

  confirmarPedido(){

  }

  ventanaDatos(){
    this.marcador = 2;
  }
}
