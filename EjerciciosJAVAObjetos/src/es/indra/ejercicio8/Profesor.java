package es.indra.ejercicio8;

public class Profesor extends Persona {
	
	protected String materia;
	protected Boolean falta;

	public Profesor(String nombre, Integer edad, Character sexo, String materia) {
		super(nombre, edad, sexo);
		// TODO Auto-generated constructor stub
		this.materia=materia;
		this.falta=estaAusente();
	}
	
	public boolean estaAusente() {
		   
		    Boolean falta = null;
			Integer aux = (int) (Math.random() * 100 + 1);
			if (aux <= 20) {
				falta = true;
			} else {
				falta = false;
			}
			return falta;
		   
	   }

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public Boolean getFalta() {
		return falta;
	}

	public void setFalta(Boolean falta) {
		this.falta = falta;
	}
	
	
	

}