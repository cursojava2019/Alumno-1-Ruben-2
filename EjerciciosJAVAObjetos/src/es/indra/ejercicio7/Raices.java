package es.indra.ejercicio7;

public class Raices {
	Double valora, valorb, valorc;

	public Raices(Double valora, Double valorb, Double valorc) {
		this.valora = valora;
		this.valorb = valorb;
		this.valorc = valorc;
	}

	public Double getDiscriminante() {
		return (Double) (valorb * valorb - 4 * valora * valorc);
	}

	public boolean tieneRaices() {
		boolean aux = false;
		if (getDiscriminante() > 0) {
			aux = true;
		}
		return aux;
	}

	public boolean tieneRaiz() {
		boolean aux = false;
		if (getDiscriminante() == 0) {
			aux = true;
		}
		return aux;
	}

	public void obtenerRaices() {
		double aux1 = 0, aux2 = 0;
		aux1 = (-valorb + Math.sqrt(getDiscriminante())) / (2 * valora);
		aux2 = (-valorb - Math.sqrt(getDiscriminante())) / (2 * valora);
		System.out.println("Valor de x1: " + aux1);
		System.out.println("Valor de x2: " + aux2);
	}

	public void obtenerRaiz() {
		System.out.println("La solución es: " + (-valorb / 2 * valora));
	}

	public void calcular() {
		if (valora == 0) {
			System.out.println("La ecuación es de primer grado y la solución es " + (-valorc / valorb));
		} else {
			if (tieneRaiz()) {
				obtenerRaiz();
			} else {
				if (tieneRaices()) {
					obtenerRaices();
				} else {
					System.out.println("No tiene solución.");
				}
			}
		}

	}
	
}	