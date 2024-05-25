import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Alergeno } from '../models/alergeno';

@Injectable({
  providedIn: 'root'
})
export class AlergenoService {

  private urlBase = "http://localhost:8080/el-caserio/alergeno";

  constructor(private clientHttp: HttpClient) { }

  obtenerAlergenosLista(){
    return this.clientHttp.get<Alergeno[]>(this.urlBase);
  }

  obtenerAlergenoPorId(id: number){
    return this.clientHttp.get<Alergeno>(`${this.urlBase}/${id}`);
  }

}
