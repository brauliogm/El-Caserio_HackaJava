import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Producto } from '../models/producto';
import { Carrito } from '../models/carrito';

@Injectable({
  providedIn: 'root'
})
export class CarritoService {

  private urlBase = "http://localhost:8080/el-caserio/carrito";
  listaProductos: Array<Producto> = [];

  constructor(private clientHttp: HttpClient) { }

  obtenerCarritoPorId(id: number){
    return this.clientHttp.get<Carrito>(`${this.urlBase}/${id}`);
  }

  agregarProductoALaLista(producto: Producto){
    let repetido: boolean = false;

    if (this.listaProductos.length == 0) {
      this.listaProductos.push(producto);
      console.log("pad");      
    } else {

      for (const product of this.listaProductos) {
        if (product.id == producto.id) {
            repetido = true;
            console.log("hay repetido");            
        }
      }

      if (repetido) {
        console.log("se modifica el repetido");
        
      } else {
        this.listaProductos.push(producto);
        console.log("es nuevo");
      }
    }
  }

  eliminarProductoDeLaLista(producto: Producto){
    const index = this.listaProductos.indexOf(producto);
    if (index !== -1) {
        this.listaProductos.splice(index, 1);
    }
  }

  totalCarrito():number {
    let total: number = 0;
    
    this.listaProductos.forEach(producto => {
      total += producto.precio * producto.cantidadRequeridaDelProducto;
    });

    return parseFloat(total.toFixed(2));
  }

  crearCarrito(carrito: Carrito){
    this.clientHttp.post<Carrito>(this.urlBase, carrito);
    this.listaProductos = [];
  }

  eliminarCarritoPorId(id: number){
    return this.clientHttp.delete<String>(`${this.urlBase}/${id}`)
  }


}
