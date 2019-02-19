package es.indra.academia.configuration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Inicializador implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		// DOMConfigurator.configure("log4j2.xml");
		System.out.println("LISTENER DE PRUEBA");

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}
