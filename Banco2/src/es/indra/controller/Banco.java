package es.indra.controller;

import java.io.Serializable;
import java.util.TreeMap;

import es.indra.model.entities.Cliente;
import es.indra.model.entities.Cuenta;
import es.indra.model.service.ClienteService;
import es.indra.model.service.CuentaService;


import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;



//serializable
public class Banco implements Serializable {
	
	private ClienteService clienteService;  //ojo
	private CuentaService cuentaService;
	private TreeMap<String, Cliente> cliente;
	private TreeMap<String, Cuenta> cuenta;

	public Banco() {
		super();
		this.cliente = new TreeMap<String, Cliente>();
		this.cuenta = new TreeMap<String, Cuenta>();
		this.clienteService = new ClienteService();  //ojo
		this.cuentaService = new CuentaService();
	}

	public TreeMap<String, Cliente> getCliente() {
		return this.cliente;
	}

	public void setCliente(TreeMap<String, Cliente> cliente) {
		this.cliente = cliente;
	}

	public TreeMap<String, Cuenta> getCuenta() {
		return this.cuenta;
	}

	public void setCuenta(TreeMap<String, Cuenta> cuenta) {
		this.cuenta = cuenta;
	}

	public Cliente obtenerCliente(String dni) {
		
		return this.clienteService.find(dni); //cambio importante
		//return this.cliente.get(dni);
	}

	public Cuenta obtenerCuenta(String id) {
		return this.cuentaService.find(id); //cambio importante
		//return this.cuenta.get(numero);
	}
	
	

	public Boolean introducirCliente(Cliente c) {
		this.clienteService.create(c); //cambio importante
		//this.cliente.put(c.getDni(), c);
		return true;
	}

	public Boolean crearCuenta(Cuenta c) {
		this.cuentaService.create(c); //cambio importante
		//this.cuenta.put(c.getId(), c);
		return true;
	}

	public Cuenta realizarIngreso(String dni, String id, Float cantidad) {
		
		Float s;
		Cliente cliente = this.clienteService.find(dni);
		Cuenta cuenta = this.cuentaService.find(id);
		if (cliente != null && cuenta != null && cuenta.getDni().equals(cliente.getDni())) {
			s = cuenta.getSaldo() + cantidad;
			cuenta.setSaldo(s);
			this.cuentaService.update(cuenta);
			System.out.println(cuenta.toString());
			System.out.println("Realizado el ingreso en la cuenta");
			return cuenta;
		} else {
			return null;
		}
	}

	public Cuenta sacarDinero(String dni, String id, Float cantidad) {
		Float s;
		Cliente cliente = this.clienteService.find(dni);
		Cuenta cuenta = this.cuentaService.find(id);
		if (cliente != null && cuenta != null &&  cuenta.getDni().equals(cliente.getDni()) && comprobarOperacion(id,cantidad, cuenta.getTipocuenta())) {
		     	s = cuenta.getSaldo() - cantidad;
		     	cuenta.setSaldo(s);
		     	this.cuentaService.update(cuenta);
		     	System.out.println(cuenta.toString());
				System.out.println("Realizada la retirada de dinero en la cuenta");
			    return cuenta;		  
		} 
		else {
			return null;
		}
	}

	public Cuenta revisionMensual(String dni, String id) {
		Cliente cliente = this.clienteService.find(dni);
		Cuenta cuenta = this.cuentaService.find(id);
		Float s = (float) 0;
		Float interes= (float) 0;
		if (cliente != null && cuenta != null  &&  cuenta.getDni().equals(cliente.getDni())) {
			
			if (cuenta.getTipocuenta()!="FI") {
			   interes=	cuenta.interes(cuenta.getTipocuenta());
			   s = cuenta.getSaldo()+interes  - cuenta.getComision();
			   cuenta.setSaldo(s); //IMPORTANTE
			   this.cuentaService.update(cuenta);
			   System.out.println(cuenta.toString());
			   System.out.println("Revision mensual realizada");
			   
			}else {
				System.out.println("Revision mensual NO realizada");
			}
			
			
			
			//cuenta.forzarRevision(cuenta);
			//System.out.println("Revision mensual realizada");
			return cuenta;
		} else {
			return null;
		}
	}
	
	public Boolean comprobarOperacion(String codigo, Float cantidad, String tipocuenta) {
		boolean aux=true;
		Cuenta cuenta = this.cuentaService.find(codigo);
		if (tipocuenta.equalsIgnoreCase("CC")) {
			
			if( (cuenta.getSaldo() - cantidad) < 0) {
				System.out.println("Saldo negativo. No es posible realizarla");
				aux=false;
			}
		}
		
	   if (tipocuenta.equalsIgnoreCase("CV")) {
				System.out.println("No es posible sacar dinero");
				aux=false;		
		}
		
	   if (tipocuenta.equalsIgnoreCase("FI")) {
		   if( ( cuenta.getSaldo() - cantidad) < (float) -500) { 
			 System.out.println("Excedes el valor limite");
			 aux=false;
		   }	
		}
		return aux;
	}
	
	/*
	 * Funcion para Obtener cuenta
	 */
	public Cuenta obtenerCuenta(String dni, String id) {
		Cuenta c = null;
		//CuentaCorriente cc;
		//CuentaVivienda cv;
		//FondoInversion fi;
		if (this.cuentaService.find(id) != null && this.cuentaService.find(id).getDni().equals(dni)) {
			c = this.cuentaService.find(id);
		//	if (c.getTipo().equals("corriente")) {
		//		cc = (CuentaCorriente) this.cuentaService.find(codigo);
		//		this.cuentasCorriente.put(codigo, cc);
			}

//		
		return c;
	}

 /*   
	public void forzarRevision(Cuenta c) {
		Float s = (float) 0;
		if (c.getTipocuenta()!="FI") {
		   s = c.getSaldo()* c.interes(c.getTipocuenta()) - c.getComision();
		   c.setSaldo(s); //IMPORTANTE
		   this.cuentaService.update(c);
		  
		   System.out.println("Revision mensual realizada");
		}else {
			System.out.println("Revision mensual NO realizada");
		}
		
	}*/
	
	

	
	
	
	/*
	 * Funcion para visualizar el estado de la cuenta
	 */
	public Cuenta visualizarCuenta(String codigo) {
		Cuenta c = null;
		c = this.cuentaService.find(codigo);
		return c;
	}

	
	
	
}