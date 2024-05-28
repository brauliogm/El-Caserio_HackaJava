import { Pipe, PipeTransform } from '@angular/core';
import { Producto } from './models/producto';

@Pipe({
    name: 'productSort'
  })
  export class MenuSortPipe implements PipeTransform {
    transform(productos: Producto[], order: string): Producto[] {
      if (!productos || !order) {
        return productos;
      }
  
      return productos.sort((a, b) => {
        if (order === 'asc') {
          return a.precio - b.precio;
        } else if (order === 'desc') {
          return b.precio - a.precio;
        } else {
          return 0;
        }
      });
    }
  }