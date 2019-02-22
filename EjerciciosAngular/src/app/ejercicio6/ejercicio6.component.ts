import { Component, OnInit } from '@angular/core';
import { Articulo } from '../model/articulo';
import { ArticuloService } from '../services/articulo.service';

@Component({
  selector: 'app-ejercicio6',
  templateUrl: './ejercicio6.component.html',
  styleUrls: ['./ejercicio6.component.css'],
  providers: [ArticuloService]
})
export class Ejercicio6Component implements OnInit {

  codigoEntrada: number;
  descripcionEntrada: string;
  precioEntrada: number;

  constructor(private articuloService: ArticuloService) { }

  ngOnInit() {
  }

  crearArticulo() {
    console.log('entrada crear artículo');
    if (this.codigoEntrada !== null) {
      const articulo: Articulo = new Articulo(this.codigoEntrada, this.descripcionEntrada, this.precioEntrada);
      this.articuloService.add(articulo);
      console.log(articulo);
      this.codigoEntrada = null;
      this.descripcionEntrada = '';
      this.precioEntrada = null;
    }
  }

  listarArticulos() {
    return this.articuloService.findAll();
  }

  modificarArticulo(codigo: number) {
    console.log('El artículo a modificar es: ' + codigo);
  }

  eliminarArticulo(codigo: number) {
    console.log('El articulo a borrar es: ' + codigo);
    this.articuloService.deleteArticulo(codigo);
  }



}


