import { Component, OnInit } from '@angular/core';
import { tryParse } from 'selenium-webdriver/http';

@Component({
  selector: 'app-ejercicio5',
  templateUrl: './ejercicio5.component.html',
  styleUrls: ['./ejercicio5.component.css']
})
export class Ejercicio5Component implements OnInit {
  n1 = 0;
  n2 = 0;
  operacion = '';
  total = 0;
  constructor() { }

  ngOnInit() {
  }
  operar(num: string) {
    let tri: number;
    tri = parseInt(num, 10);
    this.operacion += num;
    console.log(this.operacion);
  }
  igual() {
    let resultado: string[];
    resultado = this.operacion.split('+');
    if (resultado.length === 2) {
      this.n1 = parseInt(resultado[0], 10);
      this.n2 = parseInt(resultado[1], 10);
      this.total = this.n1 + this.n2;
      this.operacion = '' + this.total;
      console.log(this.operacion);
    }
    resultado = this.operacion.split('-');
    if (resultado.length === 2) {
      this.n1 = parseInt(resultado[0], 10);
      this.n2 = parseInt(resultado[1], 10);
      this.total = this.n1 - this.n2;
      this.operacion = '' + this.total;
      console.log(this.operacion);
    }

    resultado = this.operacion.split('*');
    if (resultado.length === 2) {
      this.n1 = parseInt(resultado[0], 10);
      this.n2 = parseInt(resultado[1], 10);
      this.total = this.n1 * this.n2;
      this.operacion = '' + this.total;
      console.log(this.operacion);
    }

    resultado = this.operacion.split('/');
    if (resultado.length === 2) {
      this.n1 = parseInt(resultado[0], 10);
      this.n2 = parseInt(resultado[1], 10);
      this.total = this.n1 / this.n2;
      this.operacion = '' + this.total;
      console.log(this.operacion);
    }
  }

  limpiar() {
    this.operacion = '';
  }
}
