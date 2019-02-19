package es.indra.academia.model.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import es.indra.academia.model.entities.Profesor;
import es.indra.academia.model.support.jpa.AbstracJpaDao;

@Repository
public class ProfesorJpaDao extends AbstracJpaDao<Long, Profesor> {

	@Override
	protected Class<Profesor> getClase() {
		return Profesor.class;
	}

	List<Profesor> findAlumnosPatron(String patron) {
		String queryString = "SELECT o From Profesor o Where WHERE LOWER(o.nif) like LOWER('%" + patron
				+ "%') OR LOWER(o.nombre) like LOWER('%" + patron + "%') OR LOWER(o.apellido1) like LOWER('%" + patron
				+ "%')  OR LOWER(o.apellido2) like LOWER('%" + patron + "%') ;";

		Query query = this.entityManager.createQuery(queryString);
		return query.getResultList();
	}

}
