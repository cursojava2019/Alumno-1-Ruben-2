package es.indra.ejercicio1;

import java.util.Scanner;

public class Ejercicio1Main {
	
	private static Scanner teclado;
	private static Cuenta cuenta;
	
	
	public static void inicio() {
		
		teclado=new Scanner(System.in);
		cuenta=null;
	}

	public static void main(String[] args) {
	    inicio();
		int opcion=0;
		do {
			 
		    System.out.flush();
			System.out.println("Introduzca la operación a realizar");
			System.out.println("1. Inicializar Cuenta");
			System.out.println("2. Añadir Saldo");
			System.out.println("3. Retirar Saldo");
			System.out.println("0. Finalizar");
			opcion=teclado.nextInt();
			teclado.nextLine();
			switch(opcion) {
			case 1:
				inicializarCuenta();
				break;
			case 2:
				anadirSaldo();
			    break;
			case 3:
			    retirarSaldo();
			    break;
			case 0:
				System.out.println("Fin del programa");
		        break;
		    default:
		    	break;
			}
		}while(opcion != 0);
		

	}

	private static void retirarSaldo() {
	
		 if(cuenta!=null) {	
				System.out.println("Introduzca la cantidad que desea retirar y pulse INTRO");
				double saldo=teclado.nextDouble();
				cuenta.retirar(saldo);
				System.out.println("El resultado de la operacion es"+cuenta.toString());
			 }else {
				 System.out.println("Debe inicializar la cuenta antes de hacer el ingreso");
				 
			 }
		
	}

	private static void anadirSaldo() {
	 if(cuenta!=null) {	
		System.out.println("Introduzca la cantidad que desea añadir y pulse INTRO");
		double saldo=teclado.nextDouble();
		cuenta.ingresar(saldo);
		System.out.println("El resultado de la operacion es"+cuenta.toString());
	 }else {
		 System.out.println("Debe inicializar la cuenta antes de hacer el ingreso");
		 
	 }
		
	}

	private static void inicializarCuenta() {
		// TODO Auto-generated method stub
		System.out.println("Introduzca el nombre del titular y pulse INTRO");
		String titular=teclado.nextLine();
		System.out.println("Introduzca la cantidad de saldo");
		double saldo=teclado.nextDouble();
		cuenta=new Cuenta(titular, saldo);
		System.out.println("El resultado de la operacion es"+cuenta.toString());
		//System.out.println("Pule);
	}

}
