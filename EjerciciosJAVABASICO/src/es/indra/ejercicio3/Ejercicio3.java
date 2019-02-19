package es.indra.ejercicio3;

import java.util.Scanner;

public class Ejercicio3 {
	
	 public static int numdia(String dia) {
	    	
	        int numero=0;
	        String str;
	        str=dia;
	    	switch (str) {
	    	 case "Lunes":
	    	    numero=1;
	    	    break;
	    	 case "Martes":
	    	    numero=2;
	    	   break;
	    	 case "Miercoles":
		        numero=3;
		    	break;
		     case "Jueves":
		    	 numero=4;
		    	 break;  
		     case "Viernes":
			     numero=5;
			     break;
			 case "Sabado":
			     numero=6;
			     break; 
			 case "Domingo":
				 numero=7;
				 break;   	 
			    	 
	    	
	    	}
	      return numero;	
	 }
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dia;
		Scanner teclado= new Scanner(System.in);	
		System.out.println("Escribe el dia de la semana");
		dia=teclado.next();
        if (numdia(dia)>=6) {
        	System.out.println("Dia NO laboral");
        }else {
        	System.out.println("Dia laboral");
        }
		
		
   
		
		
	}

}
