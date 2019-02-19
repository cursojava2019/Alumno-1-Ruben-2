package es.indra.academia.model.entities;

public class Profesor {
	private Long id;

	private String nombre;
	private String apellido1;
	private String apellido2;
	private String nif;
	private String telefono;
	private String correo;
	private String titulacion;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getNif() {
		return this.nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTitulacion() {
		return this.titulacion;
	}

	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}

	@Override
	public String toString() {
		return "Profesor [id=" + this.id + ", nombre=" + this.nombre + ", apellido1=" + this.apellido1 + ", apellido2="
				+ this.apellido2 + ", nif=" + this.nif + ", telefono=" + this.telefono + ", correo=" + this.correo
				+ ", titulacion=" + this.titulacion + "]";
	}
}
