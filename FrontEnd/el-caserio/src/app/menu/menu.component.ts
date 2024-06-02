import { Component } from '@angular/core';
import { Producto } from '../models/producto';
import { ProductoService } from '../services/producto.service';
import { Router } from '@angular/router';
import { CarritoService } from '../services/carrito.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent {

  productos: Producto[];
  originalProductos: Producto[] = []; // para crear una copia del array
  productosFiltrados: Producto[];
  filtrado: boolean = false;

  // variables para la paginacion
  page: number = 1;
  pageSize: number = 6;

  sortOrder: string = ''; // variables para ordenar los productos

  // Definir las opciones del grupo de radio
  categorias = [
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
  selectedOption: string = this.categorias[0].value;

  constructor(
    private productoService: ProductoService,
    private carritoService: CarritoService,
    private enrutador: Router){}

  ngOnInit(){
    this.obtenerProductos();
    
  }

  private obtenerProductos(){
    this.productoService.obtenerProductosLista().subscribe(
      (datos => {
        this.productos = datos;
        this.originalProductos = [...datos]; // con los [...] de crea una copia para no afectar al array original
      })
    );
  }

  agregarProducto(id: number){
    let productoParaAgregar: Producto;

    this.productoService.obtenerProductoPorId(id).subscribe(
      (datos=> {
        productoParaAgregar = datos;
        productoParaAgregar.cantidadRequeridaDelProducto = 1;
        this.carritoService.agregarProductoALaLista(productoParaAgregar);
      })
    )
    
    console.log(this.carritoService.listaProductos);
    
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

    if (this.sortOrder === '') {
      // Si se selecciona "Default", restablecer el array de productos al original
      this.productos = [...this.originalProductos];
      
      // Para manejar el array de los filtrados
      this.filtrado = false;
      this.selectedOption = this.categorias[0].value;
    }
  }

  onPageSize(event: Event) {
    const selectElement = event.target as HTMLSelectElement;
    this.pageSize = parseInt(selectElement.value);
  }
}
