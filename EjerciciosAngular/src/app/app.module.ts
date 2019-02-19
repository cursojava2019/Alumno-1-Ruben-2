import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { Ejercicio1Component } from './ejercicio1/ejercicio1.component';
import { Ejercicio2Component } from './ejercicio2/ejercicio2.component';
import { Ejercicio4Component } from './ejercicio4/ejercicio4.component';
import { Ejercicio3Component } from './ejercicio3/ejercicio3.component';
import { DadoComponent } from './ejercicio3/dado/dado.component';
import { Ejercicio5Component } from './ejercicio5/ejercicio5.component';
import { Ejercicio5bisComponent } from './ejercicio5bis/ejercicio5bis.component';
import { Ejercicio6Component } from './ejercicio6/ejercicio6.component';
import { ArticuloComponent } from './ejercicio6/articulo/articulo.component';


@NgModule({
  declarations: [
    AppComponent,
    Ejercicio1Component,
    Ejercicio2Component,
    Ejercicio4Component,
    Ejercicio3Component,
    DadoComponent,
    Ejercicio5Component,
    Ejercicio5bisComponent,
    Ejercicio6Component,
    ArticuloComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
