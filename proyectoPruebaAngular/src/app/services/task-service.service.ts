import { Injectable } from '@angular/core';
import { Task } from '../model/task';

@Injectable({
  providedIn: 'root'
})
export class TaskServiceService {
 private listado = Array<Task>();
  constructor() {
    this.listado.push(new Task(false, 'Comprar Pan'));
    this.listado.push(new Task(false, 'Comprar Chocolate'));
    this.listado.push(new Task(false, 'Comprar Mantequilla'));


   }

  add(tarea: Task) {
    this.listado.push(tarea);
  }
  addSimple(nombre: string , estado: boolean) {
    const tarea = new Task( estado, nombre);
    this.listado.push(tarea);
  }
  findAll() {
    return this.listado;
  }
  deleteTarea(indice: number) {
    this.listado.splice(indice, 1);
  }
}
