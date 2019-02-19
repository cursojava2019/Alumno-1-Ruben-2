package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the alumno database table.
 * 
 */
@Entity
@NamedQuery(name="Alumno.findAll", query="SELECT a FROM Alumno a")
public class Alumno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private String apellido1;

	private String apellido2;

	private String correo;

	private Timestamp fechaalta;

	private Timestamp fechabaja;

	private String nif;

	private String nombre;

	private String observaciones;

	private Boolean repetidor;

	private String telefono;

	//bi-directional many-to-one association to ResponsableAlumno
	@ManyToOne
	@JoinColumn(name="responsable")
	private ResponsableAlumno responsableAlumno;

	//bi-directional many-to-many association to Clase
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.EAGER)
	@JoinTable(
		name="alumno_clase"
		, joinColumns={
			@JoinColumn(name="id_alumno")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_clase")
			}
		)
	private List<Clase> clases;

	public Alumno() {
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

	public Timestamp getFechaalta() {
		return this.fechaalta;
	}

	public void setFechaalta(Timestamp fechaalta) {
		this.fechaalta = fechaalta;
	}

	public Timestamp getFechabaja() {
		return this.fechabaja;
	}

	public void setFechabaja(Timestamp fechabaja) {
		this.fechabaja = fechabaja;
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

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Boolean getRepetidor() {
		return this.repetidor;
	}

	public void setRepetidor(Boolean repetidor) {
		this.repetidor = repetidor;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public ResponsableAlumno getResponsableAlumno() {
		return this.responsableAlumno;
	}

	public void setResponsableAlumno(ResponsableAlumno responsableAlumno) {
		this.responsableAlumno = responsableAlumno;
	}

	public List<Clase> getClases() {
		return this.clases;
	}

	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}

}