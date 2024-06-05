import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Producto } from '../models/producto';
import { Carrito } from '../models/carrito';

@Injectable({
  providedIn: 'root'
})
export class CarritoService {

  private urlBase = "http://localhost:8080/el-caserio/carrito";

  carrito: Carrito = new Carrito();
  listaProductos: Array<Producto> = [];

  constructor(private clientHttp: HttpClient) { }

  armadoDelCarrito(productoRecibido: Producto){
    let repetido: boolean = false;

    if (this.listaProductos.length == 0) {
      
      console.log("lista en 0");
      
      this.agregarProductoALaLista(productoRecibido);
   
    } else {

      console.log("lista con mas de un producto");
      

      for (const product of this.listaProductos) {
        if (product.id == productoRecibido.id) {
            repetido = true;
            console.log("hay repetido");            
        }
      }

      if (repetido) {
        console.log("se modificara el repetido");
        
        this.editarProducto(productoRecibido);
                
      } else {
        console.log("es diferente a los que ya estaban");
        this.agregarProductoALaLista(productoRecibido);
      }
    }
    console.log(this.listaProductos.length);
    
  }

  agregarProductoALaLista(producto: Producto){
    this.listaProductos.push(producto);
      this.carrito.productos = this.listaProductos;
      this.carrito.totalDelCarrito = this.totalCarrito();
  }

  editarProducto(productoRecibido: Producto){

    let index: number = 0

    this.listaProductos.forEach(producto => {
      if(producto.id === productoRecibido.id){
        index = this.listaProductos.indexOf(producto);
      }
    })


    console.log(index);
    
    if (index !== -1) {
      console.log("ola");
      
        this.listaProductos[index].cantidadRequeridaDelProducto += productoRecibido.cantidadRequeridaDelProducto;
        console.log(productoRecibido.cantidadRequeridaDelProducto);
        console.log(this.listaProductos[index].cantidadRequeridaDelProducto);
        
        
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
    return this.clientHttp.post<Carrito>(this.urlBase, carrito);
  }

  obtenerCarritoPorId(id: number){
    return this.clientHttp.get<Carrito>(`${this.urlBase}/${id}`);
  }

  modificarCarrito(carrito : Carrito, id: number){
    return this.clientHttp.put<Carrito>(`${this.urlBase}/${id}`, carrito);
  }

  eliminarCarritoPorId(id: number){
    return this.clientHttp.delete<String>(`${this.urlBase}/${id}`)
  }


}
