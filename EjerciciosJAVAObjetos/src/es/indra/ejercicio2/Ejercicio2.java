package es.indra.ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {
	
	public static String calculoPeso(Persona p) {
		String texto="";
		int IMC = p.calcularIMC();
		switch (IMC) {
		case 1:
			texto="tiene un peso normal";
			break;
	    case 0:
	       texto="tiene un peso por debajo de lo normal";
	       break;
	    case -1:
	       texto="tiene un peso por encima de lo normal";
	       break;
	      }
		return texto;
		
	   }
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String nombre;
		Integer edad;
		char sexo;
		Float peso;
		Float altura;
		Scanner teclado= new Scanner(System.in);	
		System.out.println("Escribe el nombre");
		nombre=teclado.next();
		System.out.println("Escribe la edad");
		edad=Integer.valueOf(teclado.next());
		System.out.println("Escribe el sexo");
		sexo=(teclado.next()).charAt(0);
		System.out.println("Escribe el peso");
		peso=Float.valueOf(teclado.next());
		System.out.println("Escribe la altura");
	    altura=Float.valueOf(teclado.next());
	    
	    //Primer constructor con las cinco variables
	    Persona persona1= new Persona(nombre, edad, peso, altura, sexo);
		
	    //Segundo constructor con solo tres variables
		
	    Persona persona2 = new Persona(nombre, edad, sexo);
	    
	    Persona persona3 = new Persona();
	    
	    persona3.setNombre("Pepe");
		persona3.setEdad(20);
		persona3.setSexo('H');
		persona3.setPeso((float) 70);
		persona3.setAltura((float) 172);
		
		System.out.println("La persona "+ persona1.getNombre()+ " tiene "+ calculoPeso(persona1) );
		System.out.println("La persona "+ persona2.getNombre()+ " tiene "+ calculoPeso(persona2) );
		System.out.println("La persona "+ persona3.getNombre()+ " tiene "+ calculoPeso(persona3) ); 
		
		System.out.println("¿Persona 1 es mayor de edad?: " + persona1.esMayorEdad());
		System.out.println("¿Persona 2 es mayor de edad?: " + persona2.esMayorEdad());
		System.out.println("¿Persona 3 es mayor de edad?: " + persona3.esMayorEdad());
		
		System.out.println(persona1.toString());
		System.out.println(persona2.toString());
		System.out.println(persona3.toString());
		
		 
		
	}

}
