package es.indra.model.entities;

import es.indra.model.service.CuentaService;

//serializable
public class Cuenta{
	
	public static Float COMISION_DEFECTO =  (float) 0.6;
	
	public static String CUENTA_CORRIENTE="CC";
	public static String CUENTA_VIVIENDA="CV";
	public static String FONDO_INVERSION="FI";
	
	protected String id; //id unico para la cuenta
	protected Float comision;
	protected Cliente cliente;
	protected String tipocuenta; // CC, CV, FI
	protected Float saldo;
	
	private CuentaService cuentaService;
	
	//cuenta de inicio, a cero para la creacion

	
	public Cuenta(String id, Cliente cliente,  String tipocuenta, Float saldo) {
		super();
		this.id=id;
		this.cliente=cliente;
		this.comision = COMISION_DEFECTO;
		this.tipocuenta = tipocuenta;
		this.saldo=saldo;
	}


	public Cuenta() {
		super();
		
	}	
	
	
	public Float getComision() {
		return comision;
	}


	public String getTipocuenta() {
		return tipocuenta;
	}


	public void setComision(Float comision) {
		this.comision = comision;
	}


	public void setTipocuenta(String tipocuenta) {
		this.tipocuenta = tipocuenta;
	}
	

	
	public Float getSaldo() {
		return saldo;
	}

	
	public void setSaldo(Float saldo) {
		this.saldo=saldo;
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	
	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
   
	
	//para obtener el dni de la cuenta
	public String getDni() {
		return this.cliente.getDni();
	}
	
	
	
	
	public Float interes(String tipocuenta) {
		Float aux = (float) 0;
		if (tipocuenta.equalsIgnoreCase("CC")) {
			aux = (float) 0.1;
			return aux;
		} else if (tipocuenta.equalsIgnoreCase("CV")) {
			aux = (float) 0.2;
			return aux;
		} else {
			aux = (float) 0.34;
			return aux;
		}
	}
	
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
		
	}
	
	
	

	@Override
	public String toString() {
		return "Cuenta [id=" + id + ", comision=" + comision + ", cliente=" + cliente.getDni() + ", tipocuenta=" + tipocuenta
				+ ", saldo=" + saldo + "]";
	}



	
   
	
	
	
}