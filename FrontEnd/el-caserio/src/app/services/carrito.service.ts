import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Producto } from '../models/producto';
import { Carrito } from '../models/carrito';
import { ClienteService } from './cliente.service';
import { DireccionClienteService } from './direccion-cliente.service';
import { DireccionCliente } from '../models/direccionCliente';
import { Cliente } from '../models/cliente';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CarritoService {

  private urlBase = "http://localhost:8080/el-caserio/carrito";
  private updateCarritosSource = new Subject<void>();

  listaProductos: Array<Producto> = [];
  updateCarritos$ = this.updateCarritosSource.asObservable();
  hayError: boolean = false;

  constructor(
    private clientHttp: HttpClient,
    private clienteServise: ClienteService,
    private direccionClienteServise: DireccionClienteService,
  ) { }

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

  dosDecimales(cantidad: number, precio:number):number{
    let total: number = cantidad * precio;
    return parseFloat(total.toFixed(2));
  }

  totalElementosCarrito(): number{
    let totalElementos: number = 0;

    this.listaProductos.forEach(elemento => {
      totalElementos += elemento.cantidadRequeridaDelProducto;
    })

    return totalElementos;
  }

  listaCompleta(): Array<Producto> {
    let listaProductosFinal: Array<Producto> = [];

    this.listaProductos.forEach(producto => {
      let i = 0;
      while (i < producto.cantidadRequeridaDelProducto) {
        listaProductosFinal.push(producto);
        i++;
      }
    })
    return listaProductosFinal;
  }


  async armarPedido(direccion: DireccionCliente, cliente: Cliente) {
    const fechaActual = new Date();
    this.hayError = false;
    

    let carrito: Carrito = new Carrito(fechaActual);
  
    carrito.productos = this.listaCompleta();
    carrito.totalDelCarrito = this.totalCarrito();
    
    if (!direccion || !cliente) {
      this.hayError = true;
      console.log("Error: La dirección o el cliente están vacíos.");
      throw new Error("La dirección o el cliente no pueden estar vacíos.");
    }
    
    const validacionDireccion = !direccion.calle || direccion.codigoPostal <= 0 || !direccion.localidad || !direccion.provincia;
    const validacionCliente = !cliente.nombre || !cliente.apellido || !cliente.telefono || !cliente.email || !cliente.direccionCliente;
  
    if (validacionDireccion || validacionCliente) {
        this.hayError = true;
        console.log("Error: Alguno de los campos obligatorios de dirección o cliente están vacíos.");
        throw new Error("Alguno de los campos obligatorios de dirección o cliente están vacíos.");
    }
  
    if (carrito.productos.length === 0 || carrito.totalDelCarrito <= 0) {
        this.hayError = true;
        console.log("Error: La lista de productos está vacía o el total del carrito es cero.");
        throw new Error("La lista de productos está vacía o el total del carrito es cero.");
    }

    try {      
      let direccionGuardada = await this.direccionClienteServise.crearDireccionCliente(direccion);
      
      carrito.cliente = cliente;
      carrito.cliente.direccionCliente = direccionGuardada;
      
      let clienteGuardado = await this.clienteServise.crearCliente(carrito.cliente);
      
      carrito.cliente = clienteGuardado;
  
      let carritoGuardado = await this.crearCarrito(carrito);
      console.log("Carrito creado");      
      this.listaProductos.splice(0, this.listaProductos.length) // limpia la lista

    } catch (error) {
      console.error("Error guardando el carrito:", error);
    }
  }

  crearCarrito(carrito: Carrito): Promise<any>  {
    return this.clientHttp.post<Carrito>(this.urlBase, carrito).toPromise();
  }

  obtenerCarritos(){
    return this.clientHttp.get<Carrito[]>(this.urlBase);
  }

  updateCarritos() {
    this.updateCarritosSource.next();
  }
  
  obtenerCarritoPorId(id: number){
    return this.clientHttp.get<Carrito>(`${this.urlBase}/${id}`);
  }

  modificarCarrito(carrito : Carrito, id: number){
    return this.clientHttp.put<Carrito>(`${this.urlBase}/${id}`, carrito);
  }

  eliminarCarritoPorId(id: number){
    return this.clientHttp.delete<String>(`${this.urlBase}/${id}`);
  }

  limpiarCarrito(){
    return this.clientHttp.delete<String>(this.urlBase);
  }

}
