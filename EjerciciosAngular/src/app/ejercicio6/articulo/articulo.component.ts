import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Articulo } from 'src/app/model/articulo';

@Component({
  selector: 'app-articulo',
  templateUrl: './articulo.component.html',
  styleUrls: ['./articulo.component.css']
})
export class ArticuloComponent implements OnInit {

  @Input()
  articulo: Articulo;
  @Input()
  codigo: number;

  @Output()
  eventoEliminacion: EventEmitter<number>;
  @Output()
  eventoModificar: EventEmitter<number>;

  constructor() {
    this.eventoEliminacion = new EventEmitter<number>();
  }

  ngOnInit() {
  }

  seleccionar(codigo: number) {
    // console.log('seleccionar artículo ' + codigo);
    this.eventoModificar.next(this.codigo);
  }

  solicitarEliminar() {
    // console.log('solicitar eliminar');
    this.eventoEliminacion.next(this.codigo);
  }
}
