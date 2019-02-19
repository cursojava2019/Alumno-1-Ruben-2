package es.indra.ejercicio8;

public class Estudiante extends Persona {

	protected Float calificacion;
	protected boolean falta;
	
	public Estudiante(String nombre, Integer edad, Character sexo, Float calificacion) {
		super(nombre, edad, sexo);
		// TODO Auto-generated constructor stub
	    this.calificacion=calificacion;
	    this.falta=haceNovillos();
		
	}

   public boolean haceNovillos() {
	   
	    Boolean falta = null;
		Integer aux = (int) (Math.random() * 100 + 1);
		if (aux <= 50) {
			falta = true;
		} else {
			falta = false;
		}
		return falta;
	   
   }

   public float getCalificacion() {
	return calificacion;
   }

  public void setCalificacion(float calificacion) {
	this.calificacion = calificacion;
   }

   public boolean isFalta() {
	return falta;
   }

   public void setFalta(boolean falta) {
	 this.falta = falta;
   }
   
   
	
}