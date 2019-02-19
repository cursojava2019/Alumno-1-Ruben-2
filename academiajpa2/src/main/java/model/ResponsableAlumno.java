package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the responsable_alumno database table.
 * 
 */
@Entity
@Table(name="responsable_alumno")
@NamedQuery(name="ResponsableAlumno.findAll", query="SELECT r FROM ResponsableAlumno r")
public class ResponsableAlumno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private String apellido1;

	private String apellido2;

	private String correo;

	private String nif;

	private String nombre;

	private String telefono;

	//bi-directional many-to-one association to Alumno
	@OneToMany(mappedBy="responsableAlumno", fetch=FetchType.EAGER)
	private List<Alumno> alumnos;

	public ResponsableAlumno() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNif() {
		return this.nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Alumno> getAlumnos() {
		return this.alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public Alumno addAlumno(Alumno alumno) {
		getAlumnos().add(alumno);
		alumno.setResponsableAlumno(this);

		return alumno;
	}

	public Alumno removeAlumno(Alumno alumno) {
		getAlumnos().remove(alumno);
		alumno.setResponsableAlumno(null);

		return alumno;
	}

}