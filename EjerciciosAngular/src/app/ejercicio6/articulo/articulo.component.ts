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
  eventoEliminacion = new EventEmitter<number>();
 

  constructor() {
  }

  ngOnInit() {
  }

  seleccionar(codigo: number) {
    console.log('seleccionar artículo ' + codigo);
    this.codigo = codigo;
  }

  solicitarEliminar() {
    console.log('solicitar eliminar');
    this.eventoEliminacion.emit(this.codigo);
  }
}

