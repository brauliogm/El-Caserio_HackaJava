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

  armadoDelCarrito(productoRecibido: Producto){
    let repetido: boolean = false;

    if (this.listaProductos.length == 0) {
      this.agregarProductoALaLista(productoRecibido);
   
    } else {
      for (const product of this.listaProductos) {
        if (product.id == productoRecibido.id) {
            repetido = true;          
        }
      }

      if (repetido) {        
        this.editarCantidadProducto(productoRecibido);
                
      } else {
        this.agregarProductoALaLista(productoRecibido);

      }
    }
  }

  agregarProductoALaLista(producto: Producto){
    this.listaProductos.push(producto);
  }

  editarCantidadProducto(productoRecibido: Producto){
    let index: number = 0

    this.listaProductos.forEach(producto => {
      if(producto.id === productoRecibido.id){
        index = this.listaProductos.indexOf(producto);
      }
    })
    
    if (index !== -1) {
        this.listaProductos[index].cantidadRequeridaDelProducto += productoRecibido.cantidadRequeridaDelProducto;
    }    
  }

  sumarProducto(id: number){
    let index: number = 0

    this.listaProductos.forEach(producto => {
      if(producto.id === id){
        index = this.listaProductos.indexOf(producto);
      }
    })
    
    if (index !== -1) {
        this.listaProductos[index].cantidadRequeridaDelProducto++;
    } 
  }

  restarProducto(id: number, producto: Producto){
    let index: number = 0

    this.listaProductos.forEach(producto => {
      if(producto.id === id){
        index = this.listaProductos.indexOf(producto);
      }
    })
    
    if (index !== -1) {
        this.listaProductos[index].cantidadRequeridaDelProducto--;
        if (this.listaProductos[index].cantidadRequeridaDelProducto === 0) {
          this.eliminarProductoDeLaLista(producto);
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

  totalElementosCarrito(): number{
    let totalElementos: number = 0;

    this.listaProductos.forEach(elemento => {
      totalElementos += elemento.cantidadRequeridaDelProducto;
    })

    return totalElementos;
  }

  armarCarrito(){
    let carrito: Carrito = new Carrito();

    carrito.productos = this.listaProductos;
    carrito.totalDelCarrito = this.totalCarrito();
    
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
