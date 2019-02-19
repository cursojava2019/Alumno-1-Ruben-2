package es.indra.ejercicio5;

public class Serie implements Entregable {

	
	protected String titulo;
	protected int num_temporadas;
	protected boolean entregado;
	protected String genero;
	protected String creador;
	
	
	static final Integer TEMP_DEFECTO=3;
	static final boolean ENTREGA_DEFECTO=false;
	
	public Serie() {
		super();
		this.titulo="";
		this.num_temporadas=TEMP_DEFECTO;
		this.entregado=ENTREGA_DEFECTO;
		this.genero="";
		this.creador="";
	}

	public Serie(String titulo, String creador) {
		super();
		this.titulo = titulo;
		this.creador = creador;
		this.num_temporadas=TEMP_DEFECTO;
		this.entregado=ENTREGA_DEFECTO;
		this.genero="";
		
	}

	public Serie(String titulo, int num_temporadas, String genero, String creador) {
		super();
		this.titulo = titulo;
		this.num_temporadas = num_temporadas;
		this.genero = genero;
		this.creador = creador;
		this.entregado=ENTREGA_DEFECTO;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getNum_temporadas() {
		return num_temporadas;
	}

	public String getGenero() {
		return genero;
	}

	public String getCreador() {
		return creador;
	}

	public static Integer getTempDefecto() {
		return TEMP_DEFECTO;
	}

	public static boolean isEntregaDefecto() {
		return ENTREGA_DEFECTO;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setNum_temporadas(int num_temporadas) {
		this.num_temporadas = num_temporadas;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}

	@Override
	public String toString() {
		return "Serie [titulo=" + titulo + ", num_temporadas=" + num_temporadas + ", entregado=" + entregado
				+ ", genero=" + genero + ", creador=" + creador + "]";
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
	        if(a instanceof Serie) {
	          
			   if (this.num_temporadas< ((Serie) a).num_temporadas) { resultado = -1;}
	                else 
	                     if (this.num_temporadas>((Serie) a).num_temporadas) { resultado = 1;}
	                          else {
	                              resultado = 0;
	                           }
	              
	        
	        }
	    return resultado ;
		
	}
	
   	
	
	
	
}
