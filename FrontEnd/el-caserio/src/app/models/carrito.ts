import { Cliente } from "./cliente";
import { Producto } from "./producto";

export class Carrito{
    id : number;
    productos : Array<Producto>;
    cliente : Cliente;
    totalDelCarrito : number;
}