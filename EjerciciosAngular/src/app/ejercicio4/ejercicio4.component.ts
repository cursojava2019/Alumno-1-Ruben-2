import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ejercicio4',
  templateUrl: './ejercicio4.component.html',
  styleUrls: ['./ejercicio4.component.css']
})
export class Ejercicio4Component implements OnInit {
  nombre: string;
  password: string;



  constructor() { }

  ngOnInit() {
  }

  esValido() {


   return true;
  }


}
