package es.indra.academia.model.support;

import java.util.List;

import org.apache.logging.log4j.Logger;

public abstract class Service<K, O> {

	protected abstract Dao<K, O> getDao();

	protected abstract Logger getLog();

	public void create(O entity) {
		try {
			getLog().info("Creando Objeto");
			getDao().create(entity);
		} catch (DaoException e) {
			getLog().error("Error al crear en base de datos " + entity.getClass().getName());
		}
	}

	public void update(O entity) {
		try {
			getLog().info("Actualizando Objeto");
			getDao().update(entity);
		} catch (DaoException e) {
			getLog().error("Error al modificar en base de datos " + entity.getClass().getName());
		}
	}

	public void delete(K key) {
		try {
			getLog().info("borrando Objeto");
			getDao().delete(key);
		} catch (DaoException e) {
			getLog().error("Error al eliminar en base de datos ");
		}
	}

	public O find(K key) {
		try {
			getLog().info("buscando");
			O entidad = getDao().find(key);
			return entidad;
		} catch (DaoException e) {
			getLog().error("Error Al realizar la busqueda ");
			return null;
		}
	}

	public List<O> findAll() {
		try {
			getLog().info("Obtener todos");
			return getDao().findAll();
		} catch (DaoException e) {
			getLog().error("Error Al realizar la busqueda ");
			return null;
		}

	}
}
