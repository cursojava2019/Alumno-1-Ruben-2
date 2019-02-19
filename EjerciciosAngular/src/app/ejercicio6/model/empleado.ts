export class Empleado {
  nombre: string;
  apellido: string;
  edad: number;
  sueldos: Array<number>;

  constructor(nombre: string, apellido: string, edad: number, sueldos: Array<number>) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.edad = edad;
    this.sueldos = sueldos;
  }
}
