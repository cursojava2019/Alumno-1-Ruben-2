import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AlumnosComponent } from './alumnos.component';
import { CrearAlumnoComponent } from './crear-alumno/crear-alumno.component';
import { ModificarAlumnoComponent } from './modificar-alumno/modificar-alumno.component';

const routes: Routes = [
  {
      path: '',
      component: AlumnosComponent,
   },
   { path: 'crear', component: CrearAlumnoComponent },
   { path: 'modificar/:idAlumno', component: ModificarAlumnoComponent }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AlumnosRoutingModule { }
