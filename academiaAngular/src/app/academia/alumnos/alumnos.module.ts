import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AlumnosRoutingModule } from './alumnos-routing.module';
import { AlumnosComponent } from './alumnos.component';
import { PageHeaderModule } from '../../shared';
import { CrearAlumnoComponent } from './crear-alumno/crear-alumno.component';

import { FormularioAlumnoComponent } from './formulario-alumno/formulario-alumno.component';
import { ReactiveFormsModule } from '@angular/forms';
import { ModificarAlumnoComponent } from './modificar-alumno/modificar-alumno.component';



@NgModule({
  declarations: [AlumnosComponent, CrearAlumnoComponent,  FormularioAlumnoComponent, ModificarAlumnoComponent],
  imports: [
    CommonModule,
    AlumnosRoutingModule, PageHeaderModule, ReactiveFormsModule
  ]
})
export class AlumnosModule { }
