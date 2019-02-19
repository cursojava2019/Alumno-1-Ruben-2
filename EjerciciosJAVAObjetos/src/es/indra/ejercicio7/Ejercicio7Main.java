package es.indra.ejercicio7;
import java.util.Scanner;

public class Ejercicio7Main {


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub


			Scanner teclado = new Scanner(System.in);

			System.out.println("Termino cuadrático de la ecuación: ");
			double a = teclado.nextInt();
			System.out.println("Termino lineal de la ecuación: ");
			double b = teclado.nextInt();
			System.out.println("Termino independiente de la ecuación: ");
			double c = teclado.nextInt();
			Raices ecuacion = new Raices(a, b, c);
			ecuacion.calcular();

		
		
		

	}

}
