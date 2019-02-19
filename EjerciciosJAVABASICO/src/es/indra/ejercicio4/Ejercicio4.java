package es.indra.ejercicio4;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String numero;
		Scanner teclado= new Scanner(System.in);	
		System.out.println("Escribe el numero entero POSITIVO");
		numero=teclado.next();
		while(Integer.valueOf(numero)<0) 
		{
			System.out.println("El numero debe ser positivo. Introducelo de nuevo");
		    numero=teclado.next();
			
		}
		
		System.out.println("El numero de cifras del numero es "+numero.length() );
		
		

	}

}
