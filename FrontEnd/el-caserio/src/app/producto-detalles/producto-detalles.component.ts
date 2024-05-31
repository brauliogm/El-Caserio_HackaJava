import { Component } from '@angular/core';
import { Alergeno } from '../models/alergeno';
import { AlergenoService } from '../services/alergeno.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Producto } from '../models/producto';
import { ProductoService } from '../services/producto.service';
import { switchMap } from 'rxjs/operators';
import { CarritoService } from '../services/carrito.service';


@Component({
  selector: 'app-producto-detalles',
  templateUrl: './producto-detalles.component.html',
  styleUrls: ['./producto-detalles.component.css']
})
export class ProductoDetallesComponent {

  producto: Producto;
  productoId: number;

  constructor(
    private route: ActivatedRoute,
    private productoServise: ProductoService,
    private carritoService: CarritoService,
    private enrutador: Router){}

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

  agregarProducto(){
    this.carritoService.agregarProductoALaLista(this.producto);
    console.log(this.carritoService.listaProductos);
    
  }

  zoom(){ //metodo para mostrar la imagen del producto en grande
    console.log("hola");
    
  }
}
