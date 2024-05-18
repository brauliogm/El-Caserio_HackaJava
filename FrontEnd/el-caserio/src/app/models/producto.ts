import { Alergeno } from "./alergeno";

export class Producto{
    id : number;
    nombre : string;
    categoria : string;
    subcategoria : string;
    descripcion : string;
    listaAlergenos : Array<Alergeno>;
    precio : number;
}