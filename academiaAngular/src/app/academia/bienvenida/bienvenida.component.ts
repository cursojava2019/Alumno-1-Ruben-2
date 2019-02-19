import { Component, OnInit } from '@angular/core';
import { routerTransition } from 'src/app/router.animations';

@Component({
  selector: 'app-bienvenida',
  templateUrl: './bienvenida.component.html',
  styleUrls: ['./bienvenida.component.scss'],
  animations: [routerTransition()]
})
export class BienvenidaComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
