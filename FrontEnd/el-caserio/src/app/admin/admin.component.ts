import { Component } from '@angular/core';
import { Carrito } from '../models/carrito';
import { CarritoService } from '../services/carrito.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent {

  carritos: Carrito[];
  idActualPedido = 0;

  constructor(
    private carritoService: CarritoService,
  ){}

  ngOnInit(){
    this.obtenerCarritos();
    this.carritoService.updateCarritos$.subscribe(() => {
      // Refresh the list or perform any necessary action
      this.refreshCarritos();
    });
  }

  refreshCarritos() {
    // Implement logic to refresh the list from the database
    this.obtenerCarritos();
  }

  private obtenerCarritos(){
    this.carritoService.obtenerCarritos().subscribe(
      (datos => {
        this.carritos = datos;
        console.log(datos);
        
      })
    );
  }

  idPedidoGuardado(id: number){
    this.idActualPedido = id;
  }
  
  eliminarPedidio(id: number){
    this.carritoService.eliminarCarritoPorId(id).subscribe(
      (datos => {
        console.log(datos);
        this.obtenerCarritos();
      })
    );
  }
  
  completarPedidos(){
    this.carritoService.limpiarCarrito().subscribe(
      (datos => {
        console.log("Carrito limpio");
        this.obtenerCarritos();
      })
    );
  }
}
