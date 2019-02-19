import { Injectable } from '@angular/core';
import { MapType } from '@angular/compiler';
import { Alumno } from '../entities/alumno';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AlumnoService {
  url = 'http://192.168.1.19:8080/academiamvc/services/alumnos/';
  constructor(private http: HttpClient) {

  }

  findAll(): Observable<Alumno[]> {
    return this.http.get<Alumno[]>(this.url);
  }

  findById(id: number): Observable<Alumno> {
    console.log('id FindById ' + id);
    return this.http.get<Alumno>(this.url + id);
  }
  create(a: Alumno): Observable<Alumno> {
   return this.http.post<Alumno>(this.url, a);
  }
  delete(id: number): Observable<any> {
    return this.http.delete(this.url + id);
  }
  modificar(a: Alumno): Observable<any> {
    console.log(a);
    return this.http.put(this.url + a.id, a);
  }
}
