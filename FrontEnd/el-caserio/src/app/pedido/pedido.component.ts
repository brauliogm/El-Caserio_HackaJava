import { Component } from '@angular/core';
import { Producto } from '../models/producto';
import { CarritoService } from '../services/carrito.service';
import { Cliente } from '../models/cliente';
import { DireccionCliente } from '../models/direccionCliente';
import { ClienteService } from '../services/cliente.service';
import { DireccionClienteService } from '../services/direccion-cliente.service';

@Component({
  selector: 'app-pedido',
  templateUrl: './pedido.component.html',
  styleUrls: ['./pedido.component.css']
})
export class PedidoComponent {

  marcador: number = 1;
  listaDeProductos: Array<Producto> = [];
  cliente: Cliente = new Cliente();
  direccion: DireccionCliente = new DireccionCliente();
  validado: boolean = false;

  constructor(
    private carritoServise: CarritoService,
    private clienteServise: ClienteService,
    private direccionClienteServise: DireccionClienteService,
  ){}

  ngOnInit(){
    this.listaDeProductos = this.carritoServise.listaProductos;
    this.cliente = this.clienteServise.cliente;
    this.direccion = this.direccionClienteServise.direccion;
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

  dosDecimales(cantidad: number, precio:number):number{
    return this.carritoServise.dosDecimales(cantidad,precio);
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
    this.carritoServise.armarCarrito(this.direccion, this.cliente);
  }
}
