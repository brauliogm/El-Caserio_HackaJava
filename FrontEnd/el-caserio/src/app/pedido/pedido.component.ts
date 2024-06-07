import { Component } from '@angular/core';
import { Producto } from '../models/producto';
import { CarritoService } from '../services/carrito.service';
import { Cliente } from '../models/cliente';
import { DireccionCliente } from '../models/direccionCliente';

@Component({
  selector: 'app-pedido',
  templateUrl: './pedido.component.html',
  styleUrls: ['./pedido.component.css']
})
export class PedidoComponent {

  marcador: number = 2;
  listaDeProductos: Array<Producto> = [];
  cliente: Cliente = new Cliente();
  direccion: DireccionCliente = new DireccionCliente();
  validado: boolean = false;

  constructor(
    private carritoServise: CarritoService,
  ){}

  ngOnInit(){
    this.listaDeProductos = this.carritoServise.listaProductos;
    this.cliente.direccionCliente = this.direccion;
  }

  pruebe(){
    console.log(this.cliente);
    
  }

  sumarMarcador(){
    this.marcador++;
  }

  restarMarcador(){
    this.marcador--;
  }

  ventanaDatos(){
    this.marcador = 2;
  }

  sumarProducto(id: number){
    this.carritoServise.sumarProducto(id)
  }

  restarProducto(id: number, producto: Producto){
    this.carritoServise.restarProducto(id, producto)
  }

  eliminarProducto(product: Producto){
    this.carritoServise.eliminarProductoDeLaLista(product);
  }

  totalCarrito():number {
    return this.carritoServise.totalCarrito();
  }

  totalElementosCarrito():number {
    return this.carritoServise.totalElementosCarrito();
  }

  validarForm(){
    this.sumarMarcador();
    this.validado = false;
  }
  
  onSubmit() {
    console.log('Formulario enviado:');
    
    console.log(this.cliente);
    this.validado = true;
  }

  confirmarPedido(){

  }
}
