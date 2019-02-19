package es.indra.model.service;

import java.util.List;

import es.indra.model.dao.VehiculoDao;
import es.indra.model.entities.Vehiculo;
import es.indra.model.support.Dao;
import es.indra.model.support.DaoException;
import es.indra.model.support.Service;

public class VehiculoService extends Service<Long, Vehiculo> {

	private VehiculoDao dao = null;

	@Override
	protected Dao<Long, Vehiculo> getDao() {
		if (this.dao == null) {
			this.dao = new VehiculoDao();
		}
		return this.dao;
	}

	public List<Vehiculo> findVehiculosLibres() {
		try {
			getDao();
			return this.dao.findVehiculosLibres();
		} catch (DaoException e) {
			System.out.println("Error Al obtener informacion en la BBDD ");
			return null;
		}

	}

}