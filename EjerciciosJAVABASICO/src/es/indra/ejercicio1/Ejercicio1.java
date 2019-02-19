package es.indra.ejercicio1;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  int leido;
	  Scanner teclado= new Scanner(System.in);	
      System.out.println("Introduzca un numero para ver si es divisible por 2");
      
      leido=teclado.nextInt();
      if(leido%2==0) {
    	  System.out.println("Divisible entre 2!");
      }else {
    	  System.out.println("NO es divisible entre 2!");
      }
      
	}

}
