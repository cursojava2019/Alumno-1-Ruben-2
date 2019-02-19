package es.indra.ejercicio6;

public class Ejercicio6Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Libros l1 = new Libros("208889800", "La amenaza de Andromeda", "Michael Crichton", 135);
		Libros l2 = new Libros("320879900", "El capitan Alatriste", "Arturo Reverte", 200);

		System.out.println(l1.toString());
		System.out.println(l2.toString());
		if (l1.numeroDePaginas > l2.numeroDePaginas) {
			System.out.println("Libro con mas páginas es: " + l1.titulo + " de ISBN: " + l1.isbn);
		} else if (l1.numeroDePaginas < l2.numeroDePaginas) {
			System.out.println("libros con mas páginas es: " + l2.titulo + " de ISBN: " + l2.isbn);
		} else {
			System.out.println("Los dos libros tienen el mismo numero de paginas");
		}
	}
	
}

