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

  armadoDelCarrito(producto: Producto){
    let repetido: boolean = false;

    if (this.listaProductos.length == 0) {
      
      console.log("lista en 0");
      
      this.agregarProductoALaLista(producto);
   
    } else {

      console.log("lista con mas de un producto");
      

      for (const product of this.carrito.productos) {
        if (product.id == producto.id) {
            repetido = true;
            console.log("hay repetido");            
        }
      }

      if (repetido) {
        console.log("se modifica el repetido");
        
        this.editarProducto(producto);
                
      } else {
        console.log("es nuevo");
        this.agregarProductoALaLista(producto);
      }
    }
    console.log(this.listaProductos.length);
    
  }

  agregarProductoALaLista(producto: Producto){
    this.listaProductos.push(producto);
      this.carrito.productos = this.listaProductos;
      this.carrito.totalDelCarrito = this.totalCarrito();

      this.crearCarrito(this.carrito).subscribe(
        {
          next: (datos) => {
            this.carrito = datos;
            this.listaProductos = datos.productos;
            console.log("Se agrego el carrito con el id: " + this.carrito.id);            
          },
          error: (error: any) => {console.log(error);
          }
        }
      );
  }

  editarProducto(product: Producto){

    let productosExistentes: Array<Producto> = new Array<Producto>;

    this.obtenerCarritoPorId(this.carrito.id).subscribe(
      {
        next: (datos) => {
          productosExistentes = datos.productos;
          this.listaProductos = datos.productos;
        }
        ,
        error: (error: any) => console.log(error)
      }
    );

    productosExistentes.forEach(productoEnCarrito => {
      if (productoEnCarrito.id == product.id) {
        productoEnCarrito.cantidadRequeridaDelProducto += product.cantidadRequeridaDelProducto;
      }
    });

    this.carrito.productos = productosExistentes;
    this.carrito.totalDelCarrito = this.totalCarrito();

    this.modificarCarrito(this.carrito, this.carrito.id).subscribe(
      {
        next: (datos) => {
          console.log("carrito modificado");
          this.listaProductos = datos.productos;
        }
      }
    )
    
  }

  eliminarProductoDeLaLista(producto: Producto){
    const index = this.listaProductos.indexOf(producto);
    if (index !== -1) {
        this.listaProductos.splice(index, 1);
    }
  }

  totalCarrito():number {
    let total: number = 0;
    
    this.carrito.productos.forEach(producto => {
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
