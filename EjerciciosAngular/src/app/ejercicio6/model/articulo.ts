export class Articulo {
  codigo: number;
  descripcion: string;
  precio: number;

 constructor(codigo: number, descripcion: string, precio: number) {
    this.codigo = codigo;
    this.descripcion = descripcion;
    this.precio = precio;
  }
}
