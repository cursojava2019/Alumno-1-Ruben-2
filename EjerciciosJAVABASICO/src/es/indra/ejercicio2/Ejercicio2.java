package es.indra.ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dato1; 
		int dato2;
		Scanner teclado= new Scanner(System.in);	
		System.out.println("Escribe el primer numero");
		dato1=teclado.nextInt();
		System.out.println("Escribe el primer numero");
		dato2=teclado.nextInt();
		for(int i=dato1;i<=dato2;i++)
		{
			System.out.print(i+" ");
		}
	}

}
