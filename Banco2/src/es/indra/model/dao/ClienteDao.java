package es.indra.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.indra.model.entities.Cliente;
import es.indra.model.entities.Cuenta;
import es.indra.model.support.Dao;
import es.indra.model.support.DaoException;
import es.indra.model.support.DatosConexion;

public class ClienteDao implements Dao<String, Cliente> {

	private Connection getConexion() throws SQLException {

		Connection co = DriverManager.getConnection(DatosConexion.URL, DatosConexion.USUARIO_BD,
				DatosConexion.PASSWORD_BD);
		return co;
	}

	@Override
	public void create(Cliente entity) throws DaoException {
		try {
			Connection co = getConexion();
			PreparedStatement ps = co.prepareStatement("INSERT INTO CLIENTE VALUES (?,?,?,?,?) ");
			ps.setString(1, entity.getDni());
			ps.setString(2, entity.getNombre());
			ps.setString(3, entity.getApellidos());
			ps.setString(4, entity.getDireccion());
			ps.setString(5, entity.getTelefono());
			ps.executeUpdate();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error creando objeto en BBDD");
			throw new DaoException();
		}

	}

	@Override
	public void update(Cliente entity) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String key) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public Cliente find(String key) throws DaoException {
		Cliente cliente = null;
		try {
			Connection co = getConexion();
			String query = "SELECT * FROM CLIENTE WHERE dni=?";
			PreparedStatement instruccion = co.prepareStatement(query);
			PreparedStatement ps = co.prepareStatement("SELECT * FROM CUENTA WHERE dni=?");
			instruccion.setString(1, key);
			ResultSet resultados = instruccion.executeQuery();
			if (resultados.next()) {
				cliente = obtenerCliente(resultados);
				ps.setString(1, key);
				ResultSet resultado = ps.executeQuery();
				cliente.setPropiedades(obtenerCuentas(resultado));
			}
			co.close();
			return cliente;
		} catch (SQLException e) {
			System.out.println("Error creando objeto en BBDD");
			throw new DaoException();
		}
	}

	@Override
	public List<Cliente> findAll() throws DaoException {
		try {
			Connection co = getConexion();
			Statement instruccion = co.createStatement();
			PreparedStatement ps = co.prepareStatement("SELECT * FROM CUENTA WHERE dniCliente=?");

			String query = "SELECT * FROM CLIENTE";
			ResultSet resultados = instruccion.executeQuery(query);

			ArrayList<Cliente> listado = new ArrayList<Cliente>();

			while (resultados.next()) {

				Cliente cliente = obtenerCliente(resultados);
				ps.setString(1, cliente.getDni());
				ResultSet resultado = ps.executeQuery();
				cliente.setPropiedades(obtenerCuentas(resultado));

				listado.add(cliente);
			}

			co.close();
			return listado;
		} catch (SQLException e) {
			System.out.println("Error creando objeto en BBDD");
			throw new DaoException();
		}
	}

	private Cliente obtenerCliente(ResultSet resultado) throws SQLException {
		String dni = resultado.getString(1);
		String nombre = resultado.getString(2);
		String apellidos = resultado.getString(3);
		String direccion = resultado.getString(5);
		String tlf = resultado.getString(4);
		Cliente cliente = new Cliente(dni, nombre, apellidos, tlf, direccion);
		return cliente;

	}

	private List<Cuenta> obtenerCuentas(ResultSet resultado) throws SQLException {
		ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
		while (resultado.next()) {

			Cuenta cuenta = CuentaDao.obtenerCuenta(resultado);
			cuentas.add(cuenta);
		}
		return cuentas;
	}

}