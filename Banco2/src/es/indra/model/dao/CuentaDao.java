package es.indra.model.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.indra.model.entities.Cuenta;
import es.indra.model.entities.Cliente;
import es.indra.model.support.Dao;
import es.indra.model.support.DaoException;
import es.indra.model.support.DatosConexion;

public class CuentaDao implements Dao<String, Cuenta> {
	private Connection getConexion() throws SQLException {

		Connection co = DriverManager.getConnection(DatosConexion.URL, DatosConexion.USUARIO_BD,
				DatosConexion.PASSWORD_BD);
		return co;
	}

	@Override
	public void create(Cuenta entity) throws DaoException {
		try {
			Connection co = getConexion();
			PreparedStatement ps = co.prepareStatement("INSERT INTO CUENTA VALUES (?,?,?,?) ");
			ps.setString(1, entity.getId());
			ps.setString(2, entity.getDni());
			ps.setString(3, entity.getTipocuenta());
			ps.setFloat(4, entity.getSaldo());
			ps.executeUpdate();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error creando objeto en BBDD");
			throw new DaoException();
		}

	}

	@Override
	public void update(Cuenta entity) throws DaoException {
		// TODO Auto-generated method stub
		try {
			Connection co = getConexion();
			PreparedStatement ps = co.prepareStatement("UPDATE CUENTA SET saldo=? WHERE id=?");
			ps.setFloat(1, entity.getSaldo());
			ps.setString(2, entity.getId());
			ps.executeUpdate();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error al ingresar el dinero");
			throw new DaoException();
		}	
		

	}

	@Override
	public void delete(String id) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public Cuenta find(String key) throws DaoException {
		Cuenta cuenta = null;
		try {
			Connection co = getConexion();
			String query = "SELECT * FROM CUENTA WHERE id=?";
			PreparedStatement instruccion = co.prepareStatement(query);

			instruccion.setString(1, key);
			ResultSet resultados = instruccion.executeQuery();
			if (resultados.next()) {
				cuenta = obtenerCuenta(resultados);

			}
			co.close();
			return cuenta;
		} catch (SQLException e) {
			System.out.println("Error realizando la consulta de busqueda");
			throw new DaoException();
		}
	}

	@Override
	public List<Cuenta> findAll() throws DaoException {
		try {
			Connection co = getConexion();
			Statement instruccion = co.createStatement();

			String query = "SELECT * FROM CUENTA";
			ResultSet resultados = instruccion.executeQuery(query);

			ArrayList<Cuenta> listado = new ArrayList<Cuenta>();

			while (resultados.next()) {

				Cuenta cuenta = obtenerCuenta(resultados);
				listado.add(cuenta);
			}

			co.close();
			return listado;
		} catch (SQLException e) {
			System.out.println("Error realizando la consulta en BBDD");
			throw new DaoException();
		}
	}
	

	protected static Cuenta obtenerCuenta(ResultSet resultado) throws SQLException {
		
		String id = resultado.getString(1);
		String dni = resultado.getString(2);
		String tipo = resultado.getString(3);
		Float saldo = resultado.getFloat(4);
		
//		Boolean vendido = false;
//		if (dni != null && !dni.equalsIgnoreCase("")) {
//			vendido = true;
//		}
		Cliente cliente=new Cliente(dni);
		Cuenta cuenta = new Cuenta(id, cliente, tipo, saldo);
		return cuenta;
	}
	
	
	
	
}	