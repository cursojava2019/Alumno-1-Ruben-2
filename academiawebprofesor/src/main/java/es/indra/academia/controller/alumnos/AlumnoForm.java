package es.indra.academia.controller.alumnos;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.indra.academia.model.entities.Alumno;

public class AlumnoForm extends Alumno {

	public AlumnoForm() {
		super();
		setNif("");
		setNombre("");
		setApellido1("");
		setApellido2("");
		setTelefono("");
		setCorreo("");
		setObservaciones("");
		setRepetidor(false);
	}

	public AlumnoForm(Alumno a) {
		super();
		setId(a.getId());
		setNif(a.getNif());
		setNombre(a.getNombre());
		setApellido1(a.getApellido1());
		setApellido2(a.getApellido2());
		setTelefono(a.getTelefono());
		setCorreo(a.getCorreo());
		setObservaciones(a.getObservaciones());
		setRepetidor(a.getRepetidor());
		setFechaAlta(a.getFechaAlta());
		setFechaBaja(a.getFechaBaja());
	}

	public void validar(List<String> errores) {
		if (getNif() == null || getNif().equals("")) {
			errores.add("El nif es obligatorio");

		}
		if (getNif().length() != 9) {
			errores.add("El formato de NIF no es correcto");

		}
		if (getNombre() == null || getNombre().equals("")) {
			errores.add("El Nombre es obligatorio");

		}
		if (getApellido1() == null || getApellido1().equals("")) {
			errores.add("El Primero Apellido es obligatorio");

		}

	}

	public static AlumnoForm obtenerAlumnoForm(HttpServletRequest request) {
		String id = request.getParameter("id");
		String nif = request.getParameter("nif");
		String nombre = request.getParameter("nombre");
		String apellido1 = request.getParameter("apellido1");
		String apellido2 = request.getParameter("apellido2");
		String telefono = request.getParameter("telefono");
		String correo = request.getParameter("email");
		String repetidor = request.getParameter("repetidor");
		String observaciones = request.getParameter("observaciones");
		String fechaBaja = request.getParameter("fechaBaja");
		String fechaAlta = request.getParameter("fechaAlta");

		AlumnoForm alumno = new AlumnoForm();
		Long idLong = null;
		try {
			idLong = Long.parseLong(id);
		} catch (NumberFormatException e) {
			idLong = null;
		}

		if (fechaBaja != null && !fechaBaja.equals("")) {
			alumno.setFechaBajaString(fechaBaja);
		}
		if (fechaAlta != null && !fechaAlta.equals("")) {
			alumno.setFechaAltaString(fechaAlta);
		}

		Boolean repetiBool = Boolean.parseBoolean(repetidor);
		alumno.setId(idLong);
		alumno.setCorreo(correo);
		alumno.setApellido2(apellido2);
		alumno.setApellido1(apellido1);
		alumno.setNif(nif);
		alumno.setNombre(nombre);
		alumno.setTelefono(telefono);
		alumno.setObservaciones(observaciones);
		alumno.setRepetidor(repetiBool);
		return alumno;
	}

	public String getFechaAltaString() {
		if (getFechaAlta() != null) {
			return Long.toString(getFechaAlta().getTime());
		} else {
			return "";
		}
	}

	public String getFechaBajaString() {
		if (getFechaBaja() != null) {
			return Long.toString(getFechaBaja().getTime());
		} else {
			return "";
		}
	}

	public void setFechaAltaString(String fechaString) {
		Long timeStamp = Long.parseLong(fechaString);
		setFechaAlta(new Date(timeStamp));

	}

	public void setFechaBajaString(String fechaString) {
		Long timeStamp = Long.parseLong(fechaString);
		setFechaBaja(new Date(timeStamp));

	}
}