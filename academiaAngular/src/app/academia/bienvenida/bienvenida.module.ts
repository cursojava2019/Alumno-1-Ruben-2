import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BienvenidaRoutingModule } from './bienvenida-routing.module';
import { BienvenidaComponent } from './bienvenida.component';
import { PageHeaderModule } from '../../shared/';

@NgModule({
  declarations: [BienvenidaComponent ],
  imports: [
    CommonModule,
    BienvenidaRoutingModule, PageHeaderModule
  ]
})
export class BienvenidaModule { }
