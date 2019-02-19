import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BienvenidaComponent } from './bienvenida.component';

const routes: Routes = [
  {

    path: '',
    component: BienvenidaComponent,
    children: [],
    }

];

@NgModule({

  imports : [RouterModule.forChild(routes)],
  exports : [RouterModule]

})

export class BienvenidaRoutingModule { }
