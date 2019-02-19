package es.indra.ejercicio8;

public class Persona {
	
	static final Character SEXO_DEFECTO='H';
	
	protected String nombre;
	protected Integer edad;
	protected Character sexo;
	
	
	public Persona(String nombre, Integer edad, Character sexo) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setEdad(Integer edad) {
		this.edad = edad;
	}


	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}


	public String getNombre() {
		return nombre;
	}


	public Integer getEdad() {
		return edad;
	}


	public Character getSexo() {
		return sexo;
	}
	
	

}
