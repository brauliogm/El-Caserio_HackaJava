import { Component } from '@angular/core';
import { Alergeno } from '../models/alergeno';
import { AlergenoService } from '../services/alergeno.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Producto } from '../models/producto';

@Component({
  selector: 'app-producto-detalles',
  templateUrl: './producto-detalles.component.html',
  styleUrls: ['./producto-detalles.component.css']
})
export class ProductoDetallesComponent {

  producto: Producto;
  productoId: number;
  alergenos: Alergeno[];

  constructor(
    private route: ActivatedRoute,
    private alergenoServise: AlergenoService,
    private enrutador: Router){}

  ngOnInit(){
    this.obtenerAlergenos();
    this.productoId = +this.route.snapshot.paramMap.get('id'); // Obtén el ID de la ruta
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
