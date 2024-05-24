import { Injectable } from '@angular/core';
import { Producto } from '../models/producto';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  private urlBase = "http://localhost:8080/el-caserio/producto";

  constructor(private clientHttp: HttpClient) { }

  obtenerProductosLista(){
    return this.clientHttp.get<Producto[]>(this.urlBase);
  }

  obtenerProductoPorId(id: number){
    return this.clientHttp.get<Producto>(`${this.urlBase}/${id}`);
  }
}
