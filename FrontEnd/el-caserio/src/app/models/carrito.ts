import { Cliente } from "./cliente";
import { Producto } from "./producto";

export class Carrito{
    id : number;
    productos : Array<Producto>;
    cliente : Cliente;
    totalDelCarrito : number;
    fechaHora: string;

    constructor(fechaHora: Date) {
        this.fechaHora = this.formatDateTime(fechaHora);
      }
    
      private formatDateTime(date: Date): string {
        const day = String(date.getDate()).padStart(2, '0');
        const month = String(date.getMonth() + 1).padStart(2, '0'); // Months are zero-based
        const year = date.getFullYear();
        const hours = String(date.getHours()).padStart(2, '0');
        const minutes = String(date.getMinutes()).padStart(2, '0');
        return `${day}-${month}-${year} ${hours}:${minutes}`;
      }
}