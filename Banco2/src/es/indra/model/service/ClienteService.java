package es.indra.model.service;

import es.indra.model.dao.ClienteDao;
import es.indra.model.entities.Cliente;
import es.indra.model.support.Dao;
import es.indra.model.support.Service;

public class ClienteService extends Service<String, Cliente> {

	private ClienteDao dao = null;

	@Override
	protected Dao<String, Cliente> getDao() {
		if (this.dao == null) {
			this.dao = new ClienteDao();
		}
		return this.dao;
	}

}