package es.indra.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.indra.model.entities.Comprador;
import es.indra.model.entities.Vehiculo;
import es.indra.model.support.Dao;
import es.indra.model.support.DaoException;
import es.indra.model.support.DatosConexion;

public class CompradorDao implements Dao<String, Comprador> {

	private Connection getConexion() throws SQLException {

		Connection co = DriverManager.getConnection(DatosConexion.URL, DatosConexion.USUARIO_BD,
				DatosConexion.PASSWORD_BD);
		return co;
	}

	@Override
	public void create(Comprador entity) throws DaoException {
		try {
			Connection co = getConexion();
			PreparedStatement ps = co.prepareStatement("INSERT INTO COMPRADOR VALUES (?,?,?,?,?) ");
			ps.setString(1, entity.getDni());
			ps.setString(2, entity.getNombre());
			ps.setString(3, entity.getApellidos());
			ps.setString(4, entity.getTelefono());
			ps.setString(5, entity.getDireccion());
			ps.executeUpdate();
			co.close(); 
		} catch (SQLException e) {
			System.out.println("Error creando objeto en BBDD");
			e.printStackTrace();
			throw new DaoException();
		}

	}

	@Override
	public void update(Comprador entity) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String key) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public Comprador find(String key) throws DaoException {
		Comprador comprador = null;
		try {
			Connection co = getConexion();
			String query = "SELECT * FROM COMPRADOR WHERE dni=?";
			PreparedStatement instruccion = co.prepareStatement(query);
			PreparedStatement ps = co.prepareStatement("SELECT * FROM VEHICULO WHERE dni=?");
			instruccion.setString(1, key);
			ResultSet resultados = instruccion.executeQuery();
			if (resultados.next()) {
				comprador = obtenerComprador(resultados);
				ps.setString(1, key);
				ResultSet resultado = ps.executeQuery();
				comprador.setPropiedades(obtenerVehiculos(resultado));
			}
			co.close();
			return comprador;
		} catch (SQLException e) {
			System.out.println("Error creando objeto en BBDD");
			throw new DaoException();
		}
	}

	@Override
	public List<Comprador> findAll() throws DaoException {
		try {
			Connection co = getConexion();
			Statement instruccion = co.createStatement();
			PreparedStatement ps = co.prepareStatement("SELECT * FROM VEHICULO WHERE dni=?");

			String query = "SELECT * FROM COMPRADOR";
			ResultSet resultados = instruccion.executeQuery(query);

			ArrayList<Comprador> listado = new ArrayList<Comprador>();

			while (resultados.next()) {

				Comprador comprador = obtenerComprador(resultados);
				ps.setString(1, comprador.getDni());
				ResultSet resultado = ps.executeQuery();
				comprador.setPropiedades(obtenerVehiculos(resultado));

				listado.add(comprador);
			}

			co.close();
			return listado;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error listando ");
			throw new DaoException();
		}
	}

	private Comprador obtenerComprador(ResultSet resultado) throws SQLException {
		String nif = resultado.getString(1);
		String nombre = resultado.getString(2);
		String apellidos = resultado.getString(3);
		String telefono = resultado.getString(4);
		String direccion = resultado.getString(5);
		Comprador comprador = new Comprador(nif, nombre, apellidos, telefono, direccion, "");
		return comprador;

	}

	private List<Vehiculo> obtenerVehiculos(ResultSet resultado) throws SQLException {
		ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
		while (resultado.next()) {

			Vehiculo vehiculo = VehiculoDao.obtenerVehiculo(resultado);
			vehiculos.add(vehiculo);
		}
		return vehiculos;
	}

}