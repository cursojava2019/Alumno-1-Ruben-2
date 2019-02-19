import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Task } from 'src/app/model/task';


@Component({
  selector: 'app-tarea',
  templateUrl: './tarea.component.html',
  styleUrls: ['./tarea.component.css'],
})
export class TareaComponent implements OnInit {

  @Input()
  tarea: Task;

  @Input()
  indice: number;

  @Output()
  eventoEliminacion: EventEmitter<number>;

  constructor() {
    this.eventoEliminacion = new EventEmitter<number>();
   }

  ngOnInit() {
  }

  solicitarEliminar() {
    this.eventoEliminacion.next(this.indice);
  }



}
