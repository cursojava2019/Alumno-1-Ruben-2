import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MiComponenteComponent } from './mi-componente/mi-componente.component';
import { GestorTareasComponent } from './gestor-tareas/gestor-tareas.component';



const routes: Routes = [
  { path: '', component: MiComponenteComponent },
  { path: 'path', component: GestorTareasComponent },
  { path: '*', component: MiComponenteComponent }


];


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FeatureRoutingModule {}

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
