package es.indra.ejercicio4;

import java.util.ArrayList;

public class Ejercicio4Main {

	public static void main(String[] args) {
		
	Television t1 = new Television(1000, (float)50.0);
	Television t2 = new Television( (float) 200.50, (float) 12.5);
	Television t3 = new Television((float) 70.50, (float) 8.5);
    Television t4 = new Television((float) 100.50, "ROJO", 'A', (float) 10.0, 50, true);
    Television t5 = new Television((float) 180.50, "NEGRO", 'C', (float) 10.0, 50, true);

	Lavadora l1 = new Lavadora();
	Lavadora l2 = new Lavadora((float) 200, (float) 50);
	Lavadora l3 = new Lavadora((float) 300, "ROJO", 'A', (float) 50, (float) 10);

	Electrodomestico e = new Electrodomestico();
	Electrodomestico e2 = new Electrodomestico((float) 100, (float) 100);
		
	
    Electrodomestico[] lista=new Electrodomestico[10];	
    ArrayList<Electrodomestico> listaBuena = new ArrayList<Electrodomestico>();
    
    listaBuena.add(t1);
	listaBuena.add(t2);
	listaBuena.add(t3);
	listaBuena.add(t4);
	listaBuena.add(t5);
	listaBuena.add(l1);
	listaBuena.add(l2);
	listaBuena.add(l3);
	listaBuena.add(e);
	listaBuena.add(e2);
	
	Float totalTV = (float) 0;
	Float totalLavadoras = (float) 0;
	Float totalElectrodomesticos = (float) 0;
	for (Electrodomestico electrodomestico : listaBuena) {

		if (electrodomestico instanceof Television) {
			totalTV += electrodomestico.precioFinal();
		}
		if (electrodomestico instanceof Lavadora) {
			totalLavadoras += electrodomestico.precioFinal();
		}
		System.out.println(electrodomestico.getClass().getName() + " :" + electrodomestico.precioFinal());
		totalElectrodomesticos += electrodomestico.precioFinal();
	}
	System.out.println("El total de las televisiones es: " + totalTV);
	System.out.println("El total de las lavadoras es: " + totalLavadoras);
	System.out.println("El total de los electrodomesticos es: " + totalElectrodomesticos);
    

	}

}