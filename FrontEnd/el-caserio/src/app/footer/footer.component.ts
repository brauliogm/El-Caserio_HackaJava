import { Component } from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent {

  fecha: Date;

  constructor(){
    this.fecha = new Date();
  }

  obtenerFecha(): string{
    let year: string = this.fecha.getFullYear().toString();;
    return year;
  }

}
