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

  // Definir las opciones del grupo de radio
  options = [
    { id: '0', value: 'total', label: 'Todos' },
    { id: '1', value: 'burgers', label: 'Burguers' },
    { id: '2', value: 'entrantes', label: 'Entrantes' },
    { id: '3', value: 'combinados especiales', label: 'Combinados Especiales' },
    { id: '4', value: 'ensaladas', label: 'Ensaladas' },
    { id: '5', value: 'sandwiches', label: 'Sandwiches' },
    { id: '6', value: 'bocadillos', label: 'Bocadillos' },
    { id: '7', value: 'perritos', label: 'Perritos' },
    { id: '8', value: 'postres', label: 'Postres' },
  ];

  // Variable para almacenar la opción seleccionada
  selectedOption: string = this.options[0].value;
  resultado: string = '';

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

  filtrado(): number{
    return this.productos.length;
  }

  cantidadCategoria(categoria: string){

  }

}
