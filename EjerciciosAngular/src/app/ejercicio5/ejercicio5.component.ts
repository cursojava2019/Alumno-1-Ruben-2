import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ejercicio5',
  templateUrl: './ejercicio5.component.html',
  styleUrls: ['./ejercicio5.component.css']
})
export class Ejercicio5Component implements OnInit {
  num1: number;
  num2: number;
  resultado: number;


  constructor() {
  }

  ngOnInit() {
  }

  sumar() {
    this.resultado = this.num1 + this.num2;
  }

  restar() {
    this.resultado = this.num1 - this.num2;
  }
  multiplicar() {
    this.resultado = this.num1 * this.num2;
  }

  dividir() {
    this.resultado = this.num1 / this.num2;
  }





}




