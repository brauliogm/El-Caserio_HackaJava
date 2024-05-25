import { Component } from '@angular/core';
import { Alergeno } from '../models/alergeno';
import { AlergenoService } from '../services/alergeno.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Producto } from '../models/producto';
import { ProductoService } from '../services/producto.service';
import { switchMap } from 'rxjs/operators';


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

  zoom(){ //metodo para mostrar la imagen del producto en grande
    console.log("hola");
    
  }
}
