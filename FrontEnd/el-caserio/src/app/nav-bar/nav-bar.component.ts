import { Component } from '@angular/core';
import { CarritoService } from '../services/carrito.service';
import { Producto } from '../models/producto';
  

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent {
  
  isMenuOpen = false;
  listaDeProductos: Array<Producto> = [];

  constructor(
    private carritoServise: CarritoService,
  ){}

  ngOnInit(){
    this.listaDeProductos = this.carritoServise.listaProductos;
  }

  toggleMenu(): void {
    this.isMenuOpen = !this.isMenuOpen;
    console.log('Toggle menu:', this.isMenuOpen);
  }

  closeMenu(): void {
    this.isMenuOpen = false;
    console.log('Close menu');
  }

}
