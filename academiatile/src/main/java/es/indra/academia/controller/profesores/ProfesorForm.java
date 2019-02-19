package es.indra.academia.controller.profesores;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import es.indra.academia.model.entities.Profesor;

public class ProfesorForm {
	@Positive
	private Long id;
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 100)
	private String nombre;
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 100)
	private String apellido1;
	private String apellido2;
	@Size(min = 9, max = 9)
	private String nif;

	private String telefono;
	@Email
	@NotEmpty
	private String correo;
	
	@Size(min = 0, max = 500)
	private String titulacion;

	public ProfesorForm() {
		super();
		this.nif = "";
		this.nombre = "";
		this.apellido1 = "";
		this.apellido2 = "";
		this.telefono = "";
		this.correo = "";
		this.titulacion = "";
		
	}

	public ProfesorForm(Profesor a) {
		super();
		this.id = a.getId();
		this.nif = (a.getNif());
		this.nombre = (a.getNombre());
		this.apellido1 = (a.getApellido1());
		this.apellido2 = (a.getApellido2());
		this.telefono = (a.getTelefono());
		this.correo = (a.getCorreo());
		this.titulacion = (a.getTitulacion());
		
	}

	public Profesor obtenerProfesor() {
		Profesor a = new Profesor();
		a.setId(getId());
		a.setNif(getNif());
		a.setNombre(getNombre());
		a.setApellido1(getApellido1());
		a.setApellido2(getApellido2());
		a.setTelefono(getTelefono());
		a.setCorreo(getCorreo());
		a.setTitulacion(getTitulacion());
		
		return a;
	}

//	public void validar(List<String> errores) {
//		if (nif == null || nif.equals("")) {
//			errores.add("El nif es obligatorio");
//
//		}
//		if (nif.length() != 9) {
//			errores.add("El formato de NIF no es correcto");
//
//		}
//		if (nombre=() == null || getNombre().equals("")) {
//			errores.add("El Nombre es obligatorio");
//
//		}
//		if (getApellido1() == null || getApellido1().equals("")) {
//			errores.add("El Primero Apellido es obligatorio");
//
//		}
//
//	}

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

	
}
