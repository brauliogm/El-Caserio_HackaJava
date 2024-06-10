import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { DireccionCliente } from '../models/direccionCliente';

@Injectable({
  providedIn: 'root'
})
export class DireccionClienteService {

  private urlBase = "http://localhost:8080/el-caserio/direccion-cliente";

  direccion: DireccionCliente = new DireccionCliente();

  constructor(private clientHttp: HttpClient) { }

  crearDireccionCliente(direccion: DireccionCliente): Promise<any> {
    return this.clientHttp.post<any>(this.urlBase, direccion).toPromise();
  }
}
