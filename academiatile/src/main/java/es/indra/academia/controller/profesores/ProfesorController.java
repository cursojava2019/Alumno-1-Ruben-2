package es.indra.academia.controller.profesores;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.indra.academia.authentication.MyUserDetails;
import es.indra.academia.model.entities.Profesor;
import es.indra.academia.model.service.ProfesorService;

@Controller
@RequestMapping("/admin/profesor")
public class ProfesorController {
	@Autowired
	ProfesorService profesorService;

	@Autowired
	ProfesorFormValidator validador;
	private Logger log = LogManager.getLogger(ProfesorController.class);

	@RequestMapping(value = "/listado.html", method = RequestMethod.GET)
	public String listado(Model model) {
		MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String name = user.getUsername(); // get logged in username

		this.log.info("listado Profesor");
		List<Profesor> listado = this.profesorService.findAll();
		model.addAttribute("listado", listado);
		return "profesor/listado";
	}
	


	@RequestMapping(value = "/nuevo.html", method = RequestMethod.GET)
	public String nuevo(Model model) {
		model.addAttribute("profesor", new ProfesorForm(new Profesor()));
		return "profesor/nuevo";
	}

	@RequestMapping(value = "/nuevo.html", method = RequestMethod.POST)
	public String nuevoPost(@Valid @ModelAttribute("profesor") ProfesorForm form, BindingResult result) {
		ArrayList<String> errores = new ArrayList<String>();
		this.validador.validate(form, result);
		if (result.hasErrors()) {
			return "profesor/nuevo";

		} else {

			this.profesorService.create(form.obtenerProfesor());
			return "redirect:/admin/profesor/listado.html?mensaje=correcto";

		}

	}

	@RequestMapping(value = "/modificar.html", method = RequestMethod.GET)
	public String modificar(@RequestParam("id") Long id, Model model) {
		if (id == null) {
			return "redirect:/admin/profesor/listado.html?mensaje=errorId";

		} else {
			Profesor profesor = this.profesorService.find(id);
			if (profesor != null) {
				ProfesorForm form = new ProfesorForm(profesor);
				model.addAttribute("profesor", form);
				return "profesor/modificar";

			} else {
				return "redirect:/admin/profesor/listado.html?mensaje=errorId";
			}

		}

	}

	@RequestMapping(value = "/modificar.html", method = RequestMethod.POST)
	public String modificarPost(@ModelAttribute("formulario") ProfesorForm alumno, Model model) {
		ArrayList<String> errores = new ArrayList<String>();

		// alumno.validar(errores);
		if (errores.size() > 0) {

			model.addAttribute("errores", errores);

			return "profesor/modificar";
		} else {

			this.profesorService.update(alumno.obtenerProfesor());

			return "redirect:/admin/profesor/listado.html?mensaje=correcto";
		}

	}

	@RequestMapping(value = "/eliminar.html", method = RequestMethod.GET)
	public String eliminar(@RequestParam("id") Long id, Model model) {

		if (id == null) {
			return "redirect:/admin/profesor/listado.html?mensaje=errorId";
		} else {
			Profesor profesor = this.profesorService.find(id);
			if (profesor != null) {
				this.profesorService.delete(id);
				return "redirect:/admin/profesor/listado.html?mensaje=correcto";
			} else {
				return "redirect:/admin/profesor/listado.html?mensaje=errorId";
			}

		}

	}

}
