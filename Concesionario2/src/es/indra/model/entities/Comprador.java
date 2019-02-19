package es.indra.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Comprador implements Serializable {
	private String dni;
	private String nombre;
	private String apellidos;
	private String telefono;
	private String direccion;
	private String cp;
	private List<Vehiculo> propiedades = new ArrayList<Vehiculo>();;

	public Comprador() {
		super();
	}

	public Comprador(String dni, String nombre, String apellidos, String telefono, String direccion, String cP) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.direccion = direccion;
		this.cp = cP;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCp() {
		return this.cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public List<Vehiculo> getPropiedades() {
		return this.propiedades;
	}

	public void setPropiedades(List<Vehiculo> propiedades) {
		this.propiedades = propiedades;
	}

	@Override
	public String toString() {
		return "Comprador [dni=" + this.dni + ", nombre=" + this.nombre + ", apellidos=" + this.apellidos
				+ ", telefono=" + this.telefono + ", direccion=" + this.direccion + ", cp=" + this.cp + ", propiedades="
				+ this.propiedades + "]";
	}

}