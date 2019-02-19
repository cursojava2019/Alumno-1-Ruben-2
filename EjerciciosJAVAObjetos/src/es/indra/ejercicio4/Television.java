package es.indra.ejercicio4;

public class Television extends Electrodomestico{
	
	private int pulgadas;
	private boolean sintonizador;
	
	static final Integer PULGADAS_BASE = 50;
	static final boolean TDT_BASE= false;
	
	
	public Television() {
		super();
		// TODO Auto-generated constructor stub
		this.pulgadas=PULGADAS_BASE;
		this.sintonizador=TDT_BASE;
	}


	public Television(float preciobase, Float peso) {
		super(preciobase, peso);
		this.pulgadas = PULGADAS_BASE;
		this.sintonizador = TDT_BASE;
	}


	public Television(float preciobase, String color, char clasificacion, float peso, int pulgadas, boolean sintonizador) {
		super(preciobase, color, clasificacion, peso);
		this.pulgadas=pulgadas;
		this.sintonizador=sintonizador;
		// TODO Auto-generated constructor stub
	}


	public int getPulgadas() {
		return pulgadas;
	}


	public boolean isSintonizador() {
		return sintonizador;
	}


	@Override
	public float precioFinal() {
		// TODO Auto-generated method stub
		Float preciofinal = super.precioFinal();
		if (this.pulgadas > 40 ) {
			preciofinal = preciofinal * Float.valueOf("1.3");
		}
		if (this.sintonizador)
		{
			preciofinal = preciofinal+ 50;
		}
		
		return preciofinal;
	}
	
	
	


}