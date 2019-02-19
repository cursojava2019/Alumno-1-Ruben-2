package es.indra.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.indra.model.entities.Vehiculo;
import es.indra.model.support.Dao;
import es.indra.model.support.DaoException;
import es.indra.model.support.DatosConexion;

public class VehiculoDao implements Dao<Long, Vehiculo> {
	private Connection getConexion() throws SQLException {

		Connection co = DriverManager.getConnection(DatosConexion.URL, DatosConexion.USUARIO_BD,
				DatosConexion.PASSWORD_BD);
		return co;
	}

	@Override
	public void create(Vehiculo entity) throws DaoException {
		try {
			Connection co = getConexion();
			PreparedStatement ps = co.prepareStatement("INSERT INTO VEHICULO VALUES (?,?,?,?,?,?) ");
			ps.setLong(1, entity.getCodigo());
			ps.setString(2, entity.getMarca());
			ps.setString(3, entity.getTipo());
			ps.setFloat(4, entity.getKilometraje());
			ps.setString(5, entity.getModelo());
			ps.setInt(6, entity.getAnio());
			ps.executeUpdate();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error creando objeto en BBDD");
			throw new DaoException();
		}

	}

	@Override
	public void update(Vehiculo entity) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long key) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public Vehiculo find(Long key) throws DaoException {
		Vehiculo vehiculo = null;
		try {
			Connection co = getConexion();
			String query = "SELECT * FROM VEHICULO WHERE codigo=?";
			PreparedStatement instruccion = co.prepareStatement(query);

			instruccion.setLong(1, key);
			ResultSet resultados = instruccion.executeQuery();
			if (resultados.next()) {
				vehiculo = obtenerVehiculo(resultados);

			}
			co.close();
			return vehiculo;
		} catch (SQLException e) {
			System.out.println("Error creando objeto en BBDD");
			throw new DaoException();
		}
	}

	@Override
	public List<Vehiculo> findAll() throws DaoException {
		try {
			Connection co = getConexion();
			Statement instruccion = co.createStatement();

			String query = "SELECT * FROM VEHICULO";
			ResultSet resultados = instruccion.executeQuery(query);

			ArrayList<Vehiculo> listado = new ArrayList<Vehiculo>();

			while (resultados.next()) {

				Vehiculo vehiculo = obtenerVehiculo(resultados);
				listado.add(vehiculo);
			}

			co.close();
			return listado;
		} catch (SQLException e) {
			System.out.println("Error creando objeto en BBDD");
			throw new DaoException();
		}
	}

	public List<Vehiculo> findVehiculosLibres() throws DaoException {
		try {
			Connection co = getConexion();
			Statement instruccion = co.createStatement();

			String query = "SELECT * FROM VEHICULO WHERE dni is null";
			ResultSet resultados = instruccion.executeQuery(query);

			ArrayList<Vehiculo> listado = new ArrayList<Vehiculo>();

			while (resultados.next()) {

				Vehiculo vehiculo = obtenerVehiculo(resultados);
				listado.add(vehiculo);
			}

			co.close();
			return listado;
		} catch (SQLException e) {
			System.out.println("Error creando objeto en BBDD");
			throw new DaoException();
		}

	}

	public List<Vehiculo> findCampo(String campo, String valor) throws DaoException {
		try {
			Connection co = getConexion();
			Statement instruccion = co.createStatement();

			String query = "SELECT * FROM VEHICULO WHERE " + campo + "=" + valor;
			ResultSet resultados = instruccion.executeQuery(query);

			ArrayList<Vehiculo> listado = new ArrayList<Vehiculo>();

			while (resultados.next()) {

				Vehiculo vehiculo = obtenerVehiculo(resultados);
				listado.add(vehiculo);
			}

			co.close();
			return listado;
		} catch (SQLException e) {
			System.out.println("Error creando objeto en BBDD");
			throw new DaoException();
		}
	}

	protected static Vehiculo obtenerVehiculo(ResultSet resultado) throws SQLException {
		Long codigo = resultado.getLong(1);
		String marca = resultado.getString(2);
		String tipo = resultado.getString(3);
		String modelo = resultado.getString(4);
		Float km = resultado.getFloat(5);
		Integer anio = resultado.getInt(6);
		String dni = resultado.getString(7);
		Boolean vendido = false;
		if (dni != null && !dni.equalsIgnoreCase("")) {
			vendido = true;
		}
		Vehiculo vehiculo = new Vehiculo(codigo, marca, modelo, tipo, anio, Math.round(km), vendido);
		return vehiculo;
	}

}