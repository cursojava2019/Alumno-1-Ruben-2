package es.indra.academia.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.indra.academia.model.dao.ProfesorJpaDao;
import es.indra.academia.model.entities.Profesor;
import es.indra.academia.model.support.jpa.JpaDao;
import es.indra.academia.model.support.jpa.ServiceJpa;

@Service
public class ProfesorJpaService extends ServiceJpa<Long, Profesor> {
	@Autowired
	private ProfesorJpaDao dao;

	@Override
	public JpaDao<Long, Profesor> getDao() {
		return this.dao;
	}

}
