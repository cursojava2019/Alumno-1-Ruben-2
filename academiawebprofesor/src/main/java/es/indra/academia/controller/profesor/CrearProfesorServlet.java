package es.indra.academia.controller.profesor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.indra.academia.model.service.ProfesorService;

/**
 * Servlet implementation class CrearAlumnoServlet
 */
@WebServlet("/admin/profesor/nuevo.html")
public class CrearProfesorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CrearProfesorServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/jsp/profesor/nuevo.jsp");
		dispacher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<String> errores = new ArrayList<String>();

		String nif = request.getParameter("nif");
		String nombre = request.getParameter("nombre");
		String apellido1 = request.getParameter("apellido1");
		String apellido2 = request.getParameter("apellido2");
		String telefono = request.getParameter("telefono");
		String correo = request.getParameter("email");
		String titulacion = request.getParameter("titulacion");
		//String observaciones = request.getParameter("observaciones");

		ProfesorForm profesor = new ProfesorForm();
		profesor.setCorreo(correo);
		profesor.setApellido2(apellido2);
		profesor.setApellido1(apellido1);
		profesor.setNif(nif);
		profesor.setNombre(nombre);
		profesor.setTelefono(telefono);
		profesor.setTitulacion(titulacion);

		/*
		if (repetidor != null && !repetidor.equals("")) {
			Boolean repetidorB = Boolean.parseBoolean(repetidor);
			alumno.setRepetidor(repetidorB);
		} else {
			alumno.setRepetidor(false);
		}
		alumno.setObservaciones(observaciones);
		alumno.setFechaAlta(new Date());*/
		
		profesor.validar(errores);
		if (errores.size() > 0) {
			request.setAttribute("formulario", profesor);
			request.setAttribute("errores", errores);

			RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/jsp/profesor/nuevo.jsp");
			dispacher.forward(request, response);
		} else {
			ProfesorService profesorService = ProfesorService.getInstance();
			profesorService.create(profesor);

			response.sendRedirect("./listado.html?mensaje=correcto");
		}
	}

}
