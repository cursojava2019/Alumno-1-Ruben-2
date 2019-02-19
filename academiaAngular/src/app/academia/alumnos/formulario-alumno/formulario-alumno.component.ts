import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Alumno } from 'src/app/shared/entities/alumno';


@Component({
  selector: 'app-formulario-alumno',
  templateUrl: './formulario-alumno.component.html',
  styleUrls: ['./formulario-alumno.component.scss']
})
export class FormularioAlumnoComponent implements OnInit {

  miFormulario: FormGroup;
  @Input()
  modificar = false;
  @Input()
  alumnoModificar: Alumno;

  @Output()
  modificado = new EventEmitter<Alumno>();


  constructor(private fb: FormBuilder) {

}



  ngOnInit() {
    this.miFormulario = this.fb.group({
      id: this.fb.control(''),
      nombre: this.fb.control('', [
        Validators.required,
        Validators.minLength(3)
      ]),
      apellido1: this.fb.control('', [
        Validators.required,
        Validators.minLength(3)
      ]),
      apellido2: this.fb.control('', [
        Validators.required,
        Validators.minLength(3)
      ]),
      nif: this.fb.control('', [
        Validators.required,
        Validators.minLength(9),
        Validators.maxLength(9)
      ]),
      telefono: this.fb.control('', [
        Validators.required,
      ]),
      correo: this.fb.control('', [
        Validators.required,
        Validators.email
      ]),
      repetidor: this.fb.control(false, [
      ]),
      observaciones: this.fb.control('', [
        Validators.maxLength(1000)
      ]),
      fechaAlta: this.fb.control('', [

      ])

  });

  if (this.modificar === true) {
       this.miFormulario.patchValue (this.alumnoModificar);
  }
  }

  guardarCambios() {
   if (this.modificar === false) {
      const alumnoForm: Alumno = this.miFormulario.value;
      alumnoForm.fechaAlta = new Date();
      this.modificado.next(alumnoForm);
   } else {
    const alumnoForm: Alumno = this.miFormulario.value;

     this.modificado.next(alumnoForm);
   }
  }

}
