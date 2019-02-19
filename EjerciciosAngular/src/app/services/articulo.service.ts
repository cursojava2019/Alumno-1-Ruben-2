import { Injectable } from '@angular/core';
import { Articulo } from '../model/articulo';

@Injectable({
  providedIn: 'root'
})
export class ArticuloService {

 private listado = Array<Articulo>();

  constructor() {
    this.listado.push(new Articulo(1, 'Patatas', 35));
    this.listado.push(new Articulo(2, 'Pan', 6));
    this.listado.push(new Articulo(3, 'Pescado', 15));
   }

  add(articulo: Articulo) {
    this.listado.push(articulo);
  }
  addSimple(codigo: number, descripcion: string, precio: number) {
    const articulo = new Articulo( codigo, descripcion, precio);
    this.listado.push(articulo);
  }
  findAll() {
    return this.listado;
  }

  updateArticulo(codigo: number) {
  }

  deleteArticulo(codigo: number) {
    this.listado.splice(codigo, 1);
  }

}


