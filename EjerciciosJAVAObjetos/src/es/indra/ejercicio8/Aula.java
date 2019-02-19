package es.indra.ejercicio8;

import java.util.ArrayList;

public class Aula {
	
	protected Integer id;
	protected Profesor profesor;
	protected Integer num_maximo;
	protected String materia; //3 materias
	protected ArrayList<Estudiante> estudiante;
	
	
	public Aula(Integer id, Profesor profesor, Integer num_maximo, String materia, ArrayList<Estudiante> estudiante) {
		super();
		this.id = id;
		this.profesor = profesor;
		this.num_maximo = num_maximo;
		this.materia = materia;
		this.estudiante = estudiante;
	}
	
	public boolean darClase() {
		
		Boolean hayclase = null;

		if (this.profesor.falta == false && this.profesor.materia.equals(this.materia)
				&& (this.estudiante.size() > this.num_maximo / 2)  ) {
			hayclase = true;
		} else {
			hayclase = false;
			System.out.println("No se puede dar clase");
		}
		return hayclase;
		
		
	}
	
	public void darNotas() {
		
		if (darClase() == true) {
			for (Estudiante e : estudiante) {
				System.out.println(e.nombre + " tienes un " + e.calificacion + " en la asignatura de " + this.materia);
			}
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNum_maximo() {
		return num_maximo;
	}

	public void setNum_maximo(Integer num_maximo) {
		this.num_maximo = num_maximo;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}
	
	

}