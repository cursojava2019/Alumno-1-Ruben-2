package es.indra.academia.controller.login;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class PublicoController {

	@RequestMapping(value = "/login.html", method = RequestMethod.POST)
	public String inicio(HttpSession sesion, @RequestParam("usuario") String usuario,
			@RequestParam("password") String password) {

		if (usuario.equals(password)) {
			sesion.setAttribute("identificado", "si");
			return "redirect:/admin/index.html";
		} else {
			return "redirect:/index.html?mensaje=error";
		}
	}

	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public String index(ModelMap model) {
		return "index";
	}

	@RequestMapping(value = "/admin/index.html", method = RequestMethod.GET)
	public String indexAdmin(ModelMap model) {
		return "inicio";
	}

	@RequestMapping(value = "/admin/sinPermisos.html", method = RequestMethod.GET)
	public String sinPermisos(ModelMap model) {
		return "base/sinPermisos";
	}

}
