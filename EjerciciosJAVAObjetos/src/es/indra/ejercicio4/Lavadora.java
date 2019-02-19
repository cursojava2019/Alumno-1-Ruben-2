package es.indra.ejercicio4;

public class Lavadora extends Electrodomestico {
	
	protected float carga;
	
	static final Integer CARGA_BASE = 50;

	public Lavadora() {
		super();
		this.carga=CARGA_BASE;
	}
	
	
	public Lavadora(float preciobase, Float peso) {
		super(preciobase, peso);
		this.carga=CARGA_BASE;
	}


	public Lavadora(float preciobase, String color, char clasificacion, float peso, float carga) {
		super(preciobase, color, clasificacion, peso);
		this.carga=carga;
		// TODO Auto-generated constructor stub
	}


	public float getCarga() {
		return carga;
	}


	@Override
	public float precioFinal() {
		// TODO Auto-generated method stub
		
		Float preciofinal = super.precioFinal();
		if (this.carga > 30) {
			preciofinal += 50;
		}
		return preciofinal;
		
	}
	

}