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
  }

  closeMenu(): void {
    this.isMenuOpen = false;
  }

  totalCarrito():number {
    return this.carritoServise.totalCarrito();
  }

  eliminarProducto(product: Producto){
    this.carritoServise.eliminarProductoDeLaLista(product);
  }

}
