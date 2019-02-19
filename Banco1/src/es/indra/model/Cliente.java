package es.indra.model;

//import java.io.Serializable;

//serializable
public class Cliente {
	
	protected String dni;
	protected String nombre;
	protected String apellidos;
	protected String direccion;
	protected String telefono;
	
	
	public Cliente() {
		super();

		
	}
	
	
	public Cliente(String dni, String nombre, String apellidos, String direccion, String telefono) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getDni() {
		return dni;
	}


	public String getNombre() {
		return nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public String getDireccion() {
		return direccion;
	}


	public String getTelefono() {
		return telefono;
	}


	
	
	
	
	

}