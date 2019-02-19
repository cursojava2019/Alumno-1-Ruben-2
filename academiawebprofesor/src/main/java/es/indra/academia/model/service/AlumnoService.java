package es.indra.academia.model.service;

import java.util.ArrayList;
import java.util.List;

import es.indra.academia.model.dao.AlumnoDao;
import es.indra.academia.model.entities.Alumno;
import es.indra.academia.model.support.Dao;
import es.indra.academia.model.support.DaoException;
import es.indra.academia.model.support.Service;

public class AlumnoService extends Service<Long, Alumno> {

	private static AlumnoService singleton = null;
	private AlumnoDao dao;

	public static AlumnoService getInstance() {
		if (singleton == null) {
			singleton = new AlumnoService();
		}
		return singleton;

	}

	private AlumnoService() {
		super();
		this.dao = new AlumnoDao();
	}

	@Override
	protected Dao<Long, Alumno> getDao() {
		return this.dao;
	}

	public List<Alumno> findAlumnosPatron(String patron) {
		try {
			return this.dao.findAlumnos(patron);
		} catch (DaoException e) {
			e.printStackTrace();
			return new ArrayList<Alumno>();
		}

	}

}
