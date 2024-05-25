import { Component } from '@angular/core';
import { Producto } from '../models/producto';
import { ProductoService } from '../services/producto.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent {

  productos: Producto[];
  page: number = 1;
  pageSize: number = 6;

  constructor(private productoService: ProductoService,
            private enrutador: Router){}

  ngOnInit(){
    this.obtenerProductos();
  }

  private obtenerProductos(){
    this.productoService.obtenerProductosLista().subscribe(
      (datos => {
        this.productos = datos;
      })
    );
  }

}
