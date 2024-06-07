import { Component } from '@angular/core';
import { CarritoService } from '../services/carrito.service';
import { Producto } from '../models/producto';
import { NavigationEnd, Router } from '@angular/router';
  

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent {
  
  isMenuOpen = false;
  listaDeProductos: Array<Producto> = [];
  rutaActual: string;

  constructor(
    private carritoServise: CarritoService,
    private router: Router,
  ){}

  ngOnInit(){
    this.listaDeProductos = this.carritoServise.listaProductos;
    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        this.rutaActual = event.urlAfterRedirects;
        console.log('Current URL:', this.rutaActual);
      }
    });
  }

  toggleMenu(): void {
    this.isMenuOpen = !this.isMenuOpen;
  }

  closeMenu(): void {
    this.isMenuOpen = false;
  }

  sumarProducto(id: number){
    this.carritoServise.sumarProducto(id)
  }

  restarProducto(id: number, producto: Producto){
    this.carritoServise.restarProducto(id, producto)
  }

  totalCarrito():number {
    return this.carritoServise.totalCarrito();
  }

  totalElementosCarrito():number {
    return this.carritoServise.totalElementosCarrito();
  }

  eliminarProducto(product: Producto){
    this.carritoServise.eliminarProductoDeLaLista(product);
  }

}
