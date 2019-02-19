package es.indra.academia.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import es.indra.academia.configuration.Configuracion;
import es.indra.academia.model.entities.ResponsableAlumno;
import es.indra.academia.model.support.Dao;
import es.indra.academia.model.support.DaoException;

@Repository
public class ResponsableDao implements Dao<Long, ResponsableAlumno> {

	private static final String CAMPOS = "nif,nombre,apellido1,apellido2,telefono,correo";

	@Override
	public void create(ResponsableAlumno entity) throws DaoException {
		try {
			Connection co = Configuracion.getInstance().obtenerConexionBD();
			PreparedStatement p = co
					.prepareStatement("INSERT INTO RESPONSABLE_ALUMNO(" + CAMPOS + ") VALUES (?,?,?,?,?,?) ");

			p.setString(1, entity.getNif());
			p.setString(2, entity.getNombre());
			p.setString(3, entity.getApellido1());
			p.setString(4, entity.getApellido2());
			p.setString(5, entity.getTelefono());
			p.setString(6, entity.getCorreo());
			
			
			p.executeUpdate();
			co.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error creando objeto en BBDD");
			throw new DaoException();
		}

	}

	@Override
	public void update(ResponsableAlumno entity) throws DaoException {

		try {
			Connection co = Configuracion.getInstance().obtenerConexionBD();
			PreparedStatement p = co.prepareStatement("UPDATE RESPONSABLE_ALUMNO " + "SET nif=?," + "nombre=?," + "apellido1=?,"
					+ "apellido2=?," + "telefono=?," + "correo=? WHERE id=?;");

			p.setLong(11, entity.getId());
			p.setString(1, entity.getNif());
			p.setString(2, entity.getNombre());
			p.setString(3, entity.getApellido1());
			p.setString(4, entity.getApellido2());
			p.setString(5, entity.getTelefono());
			p.setString(6, entity.getCorreo());
			
			p.executeUpdate();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error modificando objeto en BBDD");
			e.printStackTrace();
			throw new DaoException();
		}

	}

	@Override
	public void delete(Long key) throws DaoException {
		try {
			Connection co = Configuracion.getInstance().obtenerConexionBD();
			PreparedStatement p = co.prepareStatement("DELETE FROM RESPONSABLE_ALUMNO WHERE id=?");

			p.setLong(1, key);
			p.executeUpdate();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error borrando objeto en BBDD");
			e.printStackTrace();
			throw new DaoException();
		}

	}

	@Override
	public ResponsableAlumno find(Long key) throws DaoException {
		ResponsableAlumno responsable = null;
		try {
			Connection co = Configuracion.getInstance().obtenerConexionBD();
			String query = "SELECT id," + CAMPOS + " FROM RESPONSABLE_ALUMNO WHERE id=?";
			PreparedStatement instruccion = co.prepareStatement(query);

			instruccion.setLong(1, key);
			ResultSet resultados = instruccion.executeQuery();
			if (resultados.next()) {
				responsable = obtenerResponsable(resultados);

			}
			co.close();
			return responsable;
		} catch (SQLException e) {
			System.out.println("Error creando objeto en BBDD");
			e.printStackTrace();
			throw new DaoException();
		}
	}

	@Override
	public List<ResponsableAlumno> findAll() throws DaoException {
		try {
			Connection co = Configuracion.getInstance().obtenerConexionBD();
			Statement instruccion = co.createStatement();

			String query = "SELECT id," + CAMPOS + " FROM ALUMNO";
			ResultSet resultados = instruccion.executeQuery(query);

			ArrayList<ResponsableAlumno> listado = new ArrayList<ResponsableAlumno>();

			while (resultados.next()) {

				ResponsableAlumno responsable = obtenerResponsable(resultados);

				listado.add(responsable);
			}

			co.close();
			return listado;
		} catch (Exception e) {
			System.out.println("Error creando objeto en BBDD");
			e.printStackTrace();
			throw new DaoException();
		}
	}

	private ResponsableAlumno obtenerResponsable(ResultSet resultado) throws SQLException {

		Long id = resultado.getLong(1);
		String nif = resultado.getString(2);
		String nombre = resultado.getString(3);
		String apellido1 = resultado.getString(4);
		String apellido2 = resultado.getString(5);
		String telefono = resultado.getString(6);
		String correo = resultado.getString(7);
		

		ResponsableAlumno responsable = new ResponsableAlumno();
		responsable.setId(id);
		responsable.setNif(nif);
		responsable.setNombre(nombre);
		responsable.setApellido1(apellido1);
		responsable.setApellido2(apellido2);
		responsable.setTelefono(telefono);
		responsable.setCorreo(correo);
		

		return responsable;
	}

	public List<ResponsableAlumno> findResponsable(String patron) throws DaoException {

		try {
			Connection co = Configuracion.getInstance().obtenerConexionBD();
			Statement instruccion = co.createStatement();

			String query = "SELECT id," + CAMPOS + " FROM RESPONSABLE_ALUMNO WHERE LOWER(nif) like LOWER('%" + patron
					+ "%') OR LOWER(nombre) like LOWER('%" + patron + "%') OR LOWER(apellido1) like LOWER('%" + patron
					+ "%')  OR LOWER(apellido2) like LOWER('%" + patron + "%') ;";
			ResultSet resultados = instruccion.executeQuery(query);

			ArrayList<ResponsableAlumno> listado = new ArrayList<ResponsableAlumno>();

			while (resultados.next()) {

				ResponsableAlumno alumno = obtenerResponsable(resultados);

				listado.add(alumno);
			}

			co.close();
			return listado;
		} catch (Exception e) {
			System.out.println("Error creando objeto en BBDD");
			e.printStackTrace();
			throw new DaoException();
		}
	}

	public List<ResponsableAlumno> buscarNif(String nif) throws DaoException {

		ResponsableAlumno responsable = null;
		try {
			Connection co = Configuracion.getInstance().obtenerConexionBD();
			String query = "SELECT id," + CAMPOS + " FROM RESPONSABLE_ALUMNO WHERE nif=?";
			PreparedStatement instruccion = co.prepareStatement(query);

			instruccion.setString(1, nif);
			ResultSet resultados = instruccion.executeQuery();
			ArrayList<ResponsableAlumno> listado = new ArrayList<ResponsableAlumno>();
			if (resultados.next()) {
				responsable = obtenerResponsable(resultados);
				listado.add(responsable);
			}
			co.close();
			return listado;
		} catch (SQLException e) {
			System.out.println("Error creando objeto en BBDD");
			e.printStackTrace();
			throw new DaoException();
		}
	}

}
