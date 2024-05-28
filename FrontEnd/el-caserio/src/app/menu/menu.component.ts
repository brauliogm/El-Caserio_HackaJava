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
  productosFiltrados: Producto[];
  filtrado: boolean = false;

  // variables para la paginacion
  page: number = 1;
  pageSize: number = 6;

  sortOrder: string = ''; // variables para ordenar los productos

  // Definir las opciones del grupo de radio
  options = [
    { id: '0', value: 'todos', label: 'Todos' },
    { id: '1', value: 'hamburguesa', label: 'Hamburguesa' },
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

  cantidadCategoria(categoria: string): number{
    let cantidad: number = 0;

    if (categoria == 'Todos') {
      return this.productos.length;
    }

    this.productos.forEach(producto => {
      if (producto.categoria == categoria) {
        cantidad++;
      }
    });

    return cantidad;
  }

  filtradoCategoria(categoria: string){
    this.filtrado = true;

    this.productosFiltrados = this.productos.filter(producto => producto.categoria == categoria);
    
    if (categoria == 'Todos') {
      this.filtrado = false;
    }
  }

  onSortOrderChange(event: Event) {
    const selectElement = event.target as HTMLSelectElement;
    this.sortOrder = selectElement.value;
  }
  onPageSize(event: Event) {
    const selectElement = event.target as HTMLSelectElement;
    this.pageSize = parseInt(selectElement.value);
  }
}
