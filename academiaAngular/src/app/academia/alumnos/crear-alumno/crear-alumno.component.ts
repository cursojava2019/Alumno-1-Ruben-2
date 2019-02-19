import { Component, OnInit } from '@angular/core';
import { routerTransition } from 'src/app/router.animations';
import { Alumno } from 'src/app/shared/entities/alumno';
import { AlumnoService } from 'src/app/shared/services/alumno.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-crear-alumno',
  templateUrl: './crear-alumno.component.html',
  styleUrls: ['./crear-alumno.component.scss'],
  animations: [routerTransition()]
})
export class CrearAlumnoComponent implements OnInit {

  constructor(private alumnoService: AlumnoService, private router: Router ) { }

  ngOnInit() {
  }

   crear(a: Alumno) {
     this.alumnoService.create(a).subscribe(data => {
      this.router.navigate(['alumnos']);
     });

   }

}
