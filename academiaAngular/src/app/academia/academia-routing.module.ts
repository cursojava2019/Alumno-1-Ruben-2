import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AcademiaComponent } from './academia.component';

const routes: Routes = [
  {
  path: '',
  component: AcademiaComponent,
  children: [
    { path: '', loadChildren: './bienvenida/bienvenida.module#BienvenidaModule' },
      { path: 'alumnos', loadChildren: './alumnos/alumnos.module#AlumnosModule' },
      { path: 'profesores', loadChildren: './profesores/profesores.module#ProfesoresModule' },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AcademiaRoutingModule { }
