import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ejercicio5bis',
  templateUrl: './ejercicio5bis.component.html',
  styleUrls: ['./ejercicio5bis.component.css']
})
export class Ejercicio5bisComponent implements OnInit {

  num1: number;
  num2: number;
  aux: number;
  resultado = '';
  cadena: string;

  constructor() {


  }

  ngOnInit() {
    this.aux = 0.0;
  }

  sumar() {

    this.aux = parseFloat(this.resultado);
  }

  restar() {

  }
  multiplicar() {

  }

  dividir() {

  }

  cero(){

    this.aux = 0.0;
  }

  press(numero: string) {
    let tri: number;
    tri = parseFloat(numero);
    this.resultado += numero;

  }


}
