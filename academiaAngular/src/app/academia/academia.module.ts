import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AcademiaRoutingModule } from './academia-routing.module';
import { AcademiaComponent } from './academia.component';
import { HeaderComponent } from './components/header/header.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';

import { TranslateModule } from '@ngx-translate/core';
import { NgbDropdownModule } from '@ng-bootstrap/ng-bootstrap';


@NgModule({
  declarations: [AcademiaComponent, HeaderComponent, SidebarComponent],
  imports: [
    CommonModule,
    AcademiaRoutingModule,

    TranslateModule,
    NgbDropdownModule
  ]
})
export class AcademiaModule { }
