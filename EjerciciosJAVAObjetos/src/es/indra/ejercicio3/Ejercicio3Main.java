package es.indra.ejercicio3;

import java.util.Scanner;

public class Ejercicio3Main {

	public static void main(String[] args) {
	
		Scanner teclado= new Scanner(System.in);	
		
        System.out.println("Introduce el numero de contraseñas");
        int tamano=teclado.nextInt();
        System.out.println("Introduce la longitud de la contraseña");
        int longitud=teclado.nextInt();
        Password listaPassword[]=new Password[tamano];
        boolean fortaleza[]=new boolean[tamano];
        
        for(int i=0;i<listaPassword.length;i++){
        	listaPassword[i]=new Password(longitud);
        	fortaleza[i]=listaPassword[i].esFuerte();
             System.out.println(listaPassword[i].getContrasena()+" "+fortaleza[i]);
        }

	}

}
