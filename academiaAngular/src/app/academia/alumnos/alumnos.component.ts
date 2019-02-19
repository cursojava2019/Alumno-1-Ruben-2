import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';
import { AlumnoService } from '../../shared/services/alumno.service';
import { Alumno } from '../../shared/entities/alumno';
import { Router } from '@angular/router';

@Component({
  selector: 'app-alumnos',
  templateUrl: './alumnos.component.html',
  styleUrls: ['./alumnos.component.scss'],
  animations: [routerTransition()]
})
export class AlumnosComponent implements OnInit {
  alumnos: Array<Alumno>;

  constructor(private alumnoService: AlumnoService, private router: Router) {
     alumnoService.findAll().subscribe(data => {
       this.alumnos = data;
     });

   }

  ngOnInit() {

  }

  irCrearAlumno() {
    this.router.navigate(['alumnos/crear']);
  }
  modificar(id: number) {
    this.router.navigate(['alumnos/modificar', id]);
  }

  eliminar (id: number) {
     if (confirm('Está seguro que desea borrar el alumno con id ' + id)) {
      this.alumnoService.delete(id).subscribe(data => {
          this.alumnoService.findAll().subscribe(data => {
               this.alumnos = data;
        });

      });

     }
  }

}
