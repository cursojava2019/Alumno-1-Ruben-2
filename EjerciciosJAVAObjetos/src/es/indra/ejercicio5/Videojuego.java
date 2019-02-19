package es.indra.ejercicio5;

public class Videojuego implements Entregable{

	protected String titulo;
	protected Integer horas_estimadas;
	protected boolean entregado;
	protected String genero;
	protected String compania;
	
	static final Integer HORAS_DEFECTO=10;
	static final boolean ENTREGA_DEFECTO=false;
	
	public Videojuego() {
		super();
		this.titulo="";
		this.horas_estimadas=HORAS_DEFECTO;
		this.entregado=ENTREGA_DEFECTO;
		this.genero="";
		this.compania="";
	}

	public Videojuego(String titulo, Integer horas_estimadas) {
		super();
		this.titulo = titulo;
		this.horas_estimadas = horas_estimadas;
		this.entregado=ENTREGA_DEFECTO;
		this.genero="";
		this.compania="";
		
		
	}

	public Videojuego(String titulo, Integer horas_estimadas, String genero, String compania) {
		super();
		this.titulo = titulo;
		this.horas_estimadas = horas_estimadas;
		this.entregado=ENTREGA_DEFECTO;
		this.genero = genero;
		this.compania = compania;
	}

	public String getTitulo() {
		return titulo;
	}

	public Integer getHoras_estimadas() {
		return horas_estimadas;
	}

	public String getGenero() {
		return genero;
	}

	public String getCompania() {
		return compania;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setHoras_estimadas(Integer horas_estimadas) {
		this.horas_estimadas = horas_estimadas;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	@Override
	public String toString() {
		return "Videojuego [titulo=" + titulo + ", horas_estimadas=" + horas_estimadas + ", entregado=" + entregado
				+ ", genero=" + genero + ", compania=" + compania + "]";
	}

	public void entregar() {
   		this.entregado=true;
   		
   	}
	
   	public void devolver() {
   		this.entregado=false;
   		
   	}
	
   	public boolean isEntregado() {
   		return this.entregado;
   		
   	}
   	
	
	
	@Override
	public int CompareTo(Object a) {
		// TODO Auto-generated method stub
		
		 int resultado=0;
	        if(a instanceof Videojuego) {
	          
			   if (this.horas_estimadas< ((Videojuego) a).horas_estimadas) { resultado = -1;}
	                else 
	                     if (this.horas_estimadas>((Videojuego) a).horas_estimadas) { resultado = 1;}
	                          else {
	                              resultado = 0;
	                           }
	              
	        
	        }
	    return resultado ;
		
	}
	
	
	
	
	
	
	
}
