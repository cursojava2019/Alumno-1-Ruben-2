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
//import es.indra.academia.model.entities.Alumno;
import es.indra.academia.model.entities.Profesor;
import es.indra.academia.model.support.Dao;
import es.indra.academia.model.support.DaoException;

@Repository

public class ProfesorDao implements Dao<Long, Profesor> {
	
	private static final String CAMPOS = "nif,nombre,apellido1,apellido2,telefono,correo,titulacion";

	@Override
	public void create(Profesor entity) throws DaoException {
		try {
			Connection co = Configuracion.getInstance().obtenerConexionBD();
			PreparedStatement p = co
					.prepareStatement("INSERT INTO PROFESOR(" + CAMPOS + ") VALUES (?,?,?,?,?,?,?) ");

			p.setString(1, entity.getNif());
			p.setString(2, entity.getNombre());
			p.setString(3, entity.getApellido1());
			p.setString(4, entity.getApellido2());
			p.setString(5, entity.getTelefono());
			p.setString(6, entity.getCorreo());
			p.setString(7, entity.getTitulacion());
			p.executeUpdate();
			co.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error creando objeto en BBDD");
			throw new DaoException();
		}
		
	}

	@Override
	public void update(Profesor entity) throws DaoException {
		try {
			Connection co = Configuracion.getInstance().obtenerConexionBD();
			PreparedStatement p = co.prepareStatement("UPDATE PROFESOR " + "SET nif=?," + "nombre=?," + "apellido1=?,"
					+ "apellido2=?," + "telefono=?," + "correo=?," + "titulacion=?  WHERE id=?;");

			p.setLong(8, entity.getId());
			p.setString(1, entity.getNif());
			p.setString(2, entity.getNombre());
			p.setString(3, entity.getApellido1());
			p.setString(4, entity.getApellido2());
			p.setString(5, entity.getTelefono());
			p.setString(6, entity.getCorreo());
			p.setString(7, entity.getTitulacion());

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
			PreparedStatement p = co.prepareStatement("DELETE FROM PROFESOR WHERE id=?");

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
	public Profesor find(Long key) throws DaoException {
		Profesor profesor = null;
		try {
			Connection co = Configuracion.getInstance().obtenerConexionBD();
			String query = "SELECT id," + CAMPOS + " FROM PROFESOR WHERE id=?";
			PreparedStatement instruccion = co.prepareStatement(query);

			instruccion.setLong(1, key);
			ResultSet resultados = instruccion.executeQuery();
			if (resultados.next()) {
				profesor = obtenerProfesor(resultados);

			}
			co.close();
			return profesor;
		} catch (SQLException e) {
			System.out.println("Error creando objeto en BBDD");
			e.printStackTrace();
			throw new DaoException();
		}
	}

	@Override
	public List<Profesor> findAll() throws DaoException {
		try {
			Connection co = Configuracion.getInstance().obtenerConexionBD();
			Statement instruccion = co.createStatement();

			String query = "SELECT id," + CAMPOS + " FROM PROFESOR";
			ResultSet resultados = instruccion.executeQuery(query);

			ArrayList<Profesor> listado = new ArrayList<Profesor>();

			while (resultados.next()) {

				Profesor profesor = obtenerProfesor(resultados);

				listado.add(profesor);
			}

			co.close();
			return listado;
		} catch (Exception e) {
			System.out.println("Error creando objeto en BBDD");
			e.printStackTrace();
			throw new DaoException();
		}
	}
	
	private Profesor obtenerProfesor(ResultSet resultado) throws SQLException {

		Long id = resultado.getLong(1);
		String nif = resultado.getString(2);
		String nombre = resultado.getString(3);
		String apellido1 = resultado.getString(4);
		String apellido2 = resultado.getString(5);
		String telefono = resultado.getString(6);
		String correo = resultado.getString(7);
		String titulacion = resultado.getString(8);

		Profesor profesor = new Profesor();
		profesor.setId(id);
		profesor.setNif(nif);
		profesor.setNombre(nombre);
		profesor.setApellido1(apellido1);
		profesor.setApellido2(apellido2);
		profesor.setTelefono(telefono);
		profesor.setCorreo(correo);
		profesor.setTitulacion(titulacion);

		return profesor;
	}
	
	public List<Profesor> findProfesor(String patron) throws DaoException {

		try {
			Connection co = Configuracion.getInstance().obtenerConexionBD();
			Statement instruccion = co.createStatement();

			String query = "SELECT id," + CAMPOS + " FROM PROFESOR WHERE LOWER(nif) like LOWER('%" + patron
					+ "%') OR LOWER(nombre) like LOWER('%" + patron + "%') OR LOWER(apellido1) like LOWER('%" + patron
					+ "%')  OR LOWER(apellido2) like LOWER('%" + patron + "%') ;";
			ResultSet resultados = instruccion.executeQuery(query);

			ArrayList<Profesor> listado = new ArrayList<Profesor>();

			while (resultados.next()) {

				Profesor profesor = obtenerProfesor(resultados);
				listado.add(profesor);
			}

			co.close();
			return listado;
		} catch (Exception e) {
			System.out.println("Error creando objeto en BBDD");
			e.printStackTrace();
			throw new DaoException();
		}
	}
	
	
	public List<Profesor> buscarNif(String nif) throws DaoException {

		Profesor profesor = null;
		try {
			Connection co = Configuracion.getInstance().obtenerConexionBD();
			String query = "SELECT id," + CAMPOS + " FROM PROFESOR WHERE nif=?";
			PreparedStatement instruccion = co.prepareStatement(query);

			instruccion.setString(1, nif);
			ResultSet resultados = instruccion.executeQuery();
			ArrayList<Profesor> listado = new ArrayList<Profesor>();
			if (resultados.next()) {
				profesor = obtenerProfesor(resultados);
				listado.add(profesor);
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
