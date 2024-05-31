import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Producto } from '../models/producto';
import { Carrito } from '../models/carrito';
import { Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CarritoService {

  private urlBase = "http://localhost:8080/el-caserio/carrito";
  listaProductos: Array<Producto> = [];

  private updateCarritoFuente = new Subject<void>();
  updateCarrito$ = this.updateCarritoFuente.asObservable();

  constructor(private clientHttp: HttpClient) { }

  obtenerCarritoPorId(id: number){
    return this.clientHttp.get<Carrito>(`${this.urlBase}/${id}`);
  }

  updateCarrito() {
    this.updateCarritoFuente.next();
  }
  
  agregarProductoALaLista(producto: Producto){
    this.listaProductos.push(producto);
  }

  crearCarrito(carrito: Carrito){
    this.clientHttp.post<Carrito>(this.urlBase, carrito);
    this.listaProductos = [];
  }

  eliminarCarritoPorId(id: number){
    return this.clientHttp.delete<String>(`${this.urlBase}/${id}`)
  }


}
