package es.indra.ejercicio4;

public class Electrodomestico {
	
	protected float preciobase;
	protected Color color;
	protected char clasificacion;
	protected float peso;
	
	static final Color COLOR_BASE =Color.BLANCO;
	static final Float PRECIO_DEFECTO = Float.valueOf(100);
	static final Float PESO_DEFECTO = Float.valueOf(5);
	static final Character CLASIFICACION_DEFECTO = 'F';
	
	
	public Electrodomestico() {
		super();
		this.preciobase=PRECIO_DEFECTO;
		this.color=COLOR_BASE;
		this.clasificacion=CLASIFICACION_DEFECTO;
		this.peso=PESO_DEFECTO;
	}


	public Electrodomestico(float preciobase, float peso) {
		super();
		this.preciobase = preciobase;
		this.peso = peso;
		this.color=COLOR_BASE;
		this.clasificacion=CLASIFICACION_DEFECTO;
	}


	public Electrodomestico(float preciobase, String color, char clasificacion, float peso) {
		super();
		this.preciobase = preciobase;
		comprobarColor(color);
		comprobarConsumoEnergetico(clasificacion);
		this.peso = peso;
	}


	public float getPreciobase() {
		return preciobase;
	}


	public Color getColor() {
		return color;
	}


	public char getClasificacion() {
		return clasificacion;
	}


	public float getPeso() {
		return peso;
	}
	
	
	public void comprobarConsumoEnergetico(char letra) {
		if (clasificacion == 'A' || clasificacion == 'B' || clasificacion == 'C' || clasificacion == 'D' || clasificacion == 'E' || clasificacion == 'F') {
			this.clasificacion = clasificacion;
		} else {
			this.clasificacion = CLASIFICACION_DEFECTO;
		}
		
	}
	
	private void comprobarColor(String color) {
		if (Color.ROJO == this.color || Color.GRIS == this.color || Color.AZUL == this.color || Color.NEGRO == this.color || Color.BLANCO == this.color) {
			this.color = Color.valueOf(color);
		} else {
			this.color = COLOR_BASE;
		}
		
	}
	public float precioFinal() {
		Float precioFinal = Float.valueOf(0);
		switch (this.clasificacion) {
		case 'A':
			precioFinal += 100;
			break;
		case 'B':
			precioFinal += 80;
			break;
		case 'C':
			precioFinal += 60;
			break;
		case 'D':
			precioFinal += 50;
			break;
		case 'E':
			precioFinal += 30;
			break;
		case 'F':
			precioFinal += 20;
			break;
		default:
			precioFinal += 20;
			break;
		}

		if (this.peso <= 19) {
			precioFinal += 10;
		} else if (this.peso > 19 && this.peso <= 49) {
			precioFinal += 50;
		} else if (this.peso > 49 && this.peso <= 79) {
			precioFinal += 80;
		} else {
			precioFinal += 100;
		}
		return precioFinal;
	}
	
	

}


