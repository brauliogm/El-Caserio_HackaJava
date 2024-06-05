import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Producto } from '../models/producto';
import { ProductoService } from '../services/producto.service';
import { CarritoService } from '../services/carrito.service';


@Component({
  selector: 'app-producto-detalles',
  templateUrl: './producto-detalles.component.html',
  styleUrls: ['./producto-detalles.component.css']
})
export class ProductoDetallesComponent {

  producto: Producto;
  productoId: number;
  cantidadProductosSolicitados: number = 1;

  constructor(
    private route: ActivatedRoute,
    private productoServise: ProductoService,
    private carritoService: CarritoService,
    private enrutador: Router
  ){}

  ngOnInit(){
    this.productoId = this.route.snapshot.params['id'];
    this.obtenerProductoPorId();
  }


  private obtenerProductoPorId(){
    this.productoServise.obtenerProductoPorId(this.productoId).subscribe(
      (datos => {
        this.producto = datos;
      })
    )
  }  

  cantidadProductos(event: Event): number {
    const selectElement = event.target as HTMLSelectElement;
    return this.cantidadProductosSolicitados = parseInt(selectElement.value);
  }

  agregarProducto(){
    console.log(this.producto.cantidadRequeridaDelProducto);
    this.producto.cantidadRequeridaDelProducto += this.cantidadProductosSolicitados;

    console.log("cantidad" + this.cantidadProductosSolicitados);   

    this.carritoService.armadoDelCarrito(this.producto);

    console.log(this.carritoService.listaProductos);
  }

  zoom(){ //metodo para mostrar la imagen del producto en grande
    console.log("hola");
    
  }
}
