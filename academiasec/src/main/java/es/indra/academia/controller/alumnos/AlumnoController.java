package es.indra.academia.controller.alumnos;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.indra.academia.model.entities.Alumno;
import es.indra.academia.model.service.AlumnoService;

@Controller
@RequestMapping("/admin/alumnos")
public class AlumnoController {
	@Autowired
	AlumnoService alumnoService;

	@Autowired
	AlumnoFormValidator validador;
	private Logger log = LogManager.getLogger(AlumnoController.class);

	@RequestMapping(value = "/listado.html", method = RequestMethod.GET)
	public String listado(Model model) {
		this.log.info("listado Alumnos");
		List<Alumno> listado = this.alumnoService.findAll();
		model.addAttribute("listado", listado);
		return "alumnos/listado";
	}

	@RequestMapping(value = "/nuevo.html", method = RequestMethod.GET)
	public String nuevo(Model model) {
		model.addAttribute("alumno", new AlumnoForm(new Alumno()));
		return "alumnos/nuevo";
	}

	@RequestMapping(value = "/nuevo.html", method = RequestMethod.POST)
	public String nuevoPost(@Valid @ModelAttribute("alumno") AlumnoForm form, BindingResult result) {
		ArrayList<String> errores = new ArrayList<String>();
		this.validador.validate(form, result);
		if (result.hasErrors()) {
			return "alumnos/nuevo";

		} else {

			this.alumnoService.create(form.obtenerAlumno());
			return "redirect:/admin/alumnos/listado.html?mensaje=correcto";

		}

	}

	@RequestMapping(value = "/modificar.html", method = RequestMethod.GET)
	public String modificar(@RequestParam("id") Long id, Model model) {
		if (id == null) {
			return "redirect:/admin/alumnos/listado.html?mensaje=errorId";

		} else {
			Alumno alumno = this.alumnoService.find(id);
			if (alumno != null) {
				AlumnoForm form = new AlumnoForm(alumno);
				model.addAttribute("formulario", form);
				return "alumnos/modificar";

			} else {
				return "redirect:/admin/alumnos/listado.html?mensaje=errorId";
			}

		}

	}

	@RequestMapping(value = "/modificar.html", method = RequestMethod.POST)
	public String modificarPost(@ModelAttribute("formulario") AlumnoForm alumno, Model model) {
		ArrayList<String> errores = new ArrayList<String>();

		// alumno.validar(errores);
		if (errores.size() > 0) {

			model.addAttribute("errores", errores);

			return "alumnos/modificar";
		} else {

			this.alumnoService.update(alumno.obtenerAlumno());

			return "redirect:/admin/alumnos/listado.html?mensaje=correcto";
		}

	}

	@RequestMapping(value = "/eliminar.html", method = RequestMethod.GET)
	public String eliminar(@RequestParam("id") Long id, Model model) {

		if (id == null) {
			return "redirect:/admin/alumnos/listado.html?mensaje=errorId";
		} else {
			Alumno alumno = this.alumnoService.find(id);
			if (alumno != null) {
				this.alumnoService.delete(id);
				return "redirect:/admin/alumnos/listado.html?mensaje=correcto";
			} else {
				return "redirect:/admin/alumnos/listado.html?mensaje=errorId";
			}

		}

	}

}
