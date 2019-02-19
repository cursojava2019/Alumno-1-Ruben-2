package es.indra.ejercicio8;

import java.util.ArrayList;

public class Ejercicio8Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		Profesor p1 = new Profesor("Pepe", 36, 'H', "Filosofia");

		Estudiante e1 = new Estudiante("Raul", 24, 'H', (float) 4.0);
		Estudiante e2 = new Estudiante("Marcos", 16, 'H', (float) 3.5);
		Estudiante e3 = new Estudiante("Sara", 21, 'M', (float) 7.5);
		Estudiante e4 = new Estudiante("Maria", 21, 'M', (float) 2.5);

		ArrayList<Estudiante> Listae = new ArrayList<Estudiante>();
		Listae.add(e1);
		Listae.add(e2);
		Listae.add(e3);
		Listae.add(e4);

		Aula aula1 = new Aula(1, p1, 7, "Filosofia", Listae);

		System.out.println(aula1.darClase());
		aula1.darNotas();

	}

}
