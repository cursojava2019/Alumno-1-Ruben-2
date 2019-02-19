package es.indra.model.service;

import java.util.List;

import es.indra.model.dao.CuentaDao;
import es.indra.model.entities.Cuenta;
import es.indra.model.support.Dao;
import es.indra.model.support.DaoException;
import es.indra.model.support.Service;

public class CuentaService extends Service<String, Cuenta> {

	private CuentaDao dao = null;

	@Override
	protected Dao<String, Cuenta> getDao() {
		if (this.dao == null) {
			this.dao = new CuentaDao();
		}
		return this.dao;
	}

}	
/*	
	public List<Cuenta> findVehiculosLibres() {
		try {
			getDao();
			return this.dao.findVehiculosLibres();
		} catch (DaoException e) {
			System.out.println("Error Al obtener informacion en la BBDD ");
			return null;
		}

	}

}*/