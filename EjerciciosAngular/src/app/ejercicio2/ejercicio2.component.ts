import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ejercicio2',
  templateUrl: './ejercicio2.component.html',
  styleUrls: ['./ejercicio2.component.css']
})
export class Ejercicio2Component implements OnInit {
  empleado: Empleado;
  salario = [1600, 1700, 1900];


  constructor( ) {
     this.empleado = new Empleado('pepe', 19, this.salario);
  }

  ngOnInit() {
  }




}


export class Empleado  {

  nombre: string;
  edad: number;
  salario: number[];

  constructor(nombre: string, edad: number, salario ) {
    this.nombre = nombre;
    this.edad = edad;
    this.salario = salario;
  }

}
