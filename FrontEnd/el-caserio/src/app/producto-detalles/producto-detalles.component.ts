import { Component } from '@angular/core';
import { Alergeno } from '../models/alergeno';
import { AlergenoService } from '../services/alergeno.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-producto-detalles',
  templateUrl: './producto-detalles.component.html',
  styleUrls: ['./producto-detalles.component.css']
})
export class ProductoDetallesComponent {
  alergenos: Alergeno[];

  constructor(private alergenoServise: AlergenoService,
            private enrutador: Router){}

  ngOnInit(){
    this.obtenerAlergenos();
  }

  private obtenerAlergenos(){
    this.alergenoServise.obtenerAlergenosLista().subscribe(
      (datos => {
        this.alergenos = datos;
      })
    );
  }
  

  zoom(){
    console.log("hola");
    
  }
}
