import { Component } from '@angular/core';
import { Carrito } from '../models/carrito';
import { CarritoService } from '../services/carrito.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent {

  carritos: Carrito[] = []

  constructor(
    private carritoService: CarritoService,
  ){}

  ngOnInit(){
    this.obtenerCarritos();
    
  }

  private obtenerCarritos(){
    this.carritoService.obtenerCarritos().subscribe(
      (datos => {
        this.carritos = datos;
      })
    );
  }

  obtenerCantidadDeProductos(): number{
    let total: number = 0;
    this.carritos.forEach(platillos => 
      platillos.productos.forEach(plato => 
        total += plato.cantidadRequeridaDelProducto))

    return total;
  }

  
}
