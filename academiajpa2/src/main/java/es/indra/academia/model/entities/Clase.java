package es.indra.academia.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the clase database table.
 * 
 */
@Entity
@NamedQuery(name="Clase.findAll", query="SELECT c FROM Clase c")
public class Clase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	//bi-directional many-to-many association to Alumno
	@ManyToMany(mappedBy="clases", cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.EAGER)
	private List<Alumno> alumnos;

	//bi-directional many-to-one association to Asignatura
	@ManyToOne
	@JoinColumn(name="id_asignatura")
	private Asignatura asignatura;

	//bi-directional many-to-one association to Profesor
	@ManyToOne
	@JoinColumn(name="id_profesor")
	private Profesor profesor;

	//bi-directional many-to-one association to Tarifa
	@ManyToOne
	@JoinColumn(name="id_tarifa")
	private Tarifa tarifa;

	public Clase() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Alumno> getAlumnos() {
		return this.alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public Asignatura getAsignatura() {
		return this.asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public Profesor getProfesor() {
		return this.profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Tarifa getTarifa() {
		return this.tarifa;
	}

	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}

}