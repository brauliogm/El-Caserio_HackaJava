import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cliente } from '../models/cliente';
import { DireccionClienteService } from './direccion-cliente.service';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  private urlBase = "http://localhost:8080/el-caserio/cliente";

  cliente: Cliente = new Cliente();

  constructor(
    private clientHttp: HttpClient,
    private direccionClienteServise: DireccionClienteService,
  ) {
    this.cliente.direccionCliente = direccionClienteServise.direccion;
   }

  crearCliente(cliente: Cliente): Promise<any> {
    return this.clientHttp.post<any>(this.urlBase, cliente).toPromise();
  }
}
