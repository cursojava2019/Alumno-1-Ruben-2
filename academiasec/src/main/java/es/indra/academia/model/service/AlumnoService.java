package es.indra.academia.model.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import es.indra.academia.model.dao.AlumnoDao;
import es.indra.academia.model.entities.Alumno;
import es.indra.academia.model.support.Dao;
import es.indra.academia.model.support.DaoException;
import es.indra.academia.model.support.Service;

@org.springframework.stereotype.Service
public class AlumnoService extends Service<Long, Alumno> {
	@Autowired
	private AlumnoDao dao;
	private Logger log = LogManager.getLogger(AlumnoService.class);

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

	@Override
	protected Logger getLog() {
		return this.log;

	}

	public List<Alumno> buscarNif(String nif) {
		try {
			return this.dao.buscarNif(nif);
		} catch (DaoException e) {
			this.log.error("Error buscando NIF", e);
			return null;
		}
	}

}
