package es.indra.academia.model.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import es.indra.academia.model.dao.ProfesorDao;
import es.indra.academia.model.entities.Profesor;
import es.indra.academia.model.support.Dao;
import es.indra.academia.model.support.DaoException;
import es.indra.academia.model.support.Service;

@org.springframework.stereotype.Service
public class ProfesorService extends Service<Long, Profesor> {
	@Autowired
	private ProfesorDao dao;
	private Logger log = LogManager.getLogger(ProfesorService.class);

	@Override
	protected Dao<Long, Profesor> getDao() {
		return this.dao;
	}

	public List<Profesor> findProfesorPatron(String patron) {
		try {
			return this.dao.findProfesor(patron);
		} catch (DaoException e) {
			e.printStackTrace();
			return new ArrayList<Profesor>();
		}

	}

	@Override
	protected Logger getLog() {
		return this.log;

	}

	public List<Profesor> buscarNif(String nif) {
		try {
			return this.dao.buscarNif(nif);
		} catch (DaoException e) {
			this.log.error("Error buscando NIF", e);
			return null;
		}
	}

}