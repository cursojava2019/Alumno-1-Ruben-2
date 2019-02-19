package es.indra.model;

import java.io.Serializable;

public class Venta implements Serializable {

	private Vehiculo vehiculo;
	private Comprador comprador;
	private Double precioVenta;

	public Venta() {
		super();

	}

	public Venta(Vehiculo vehiculo, Comprador comprador, Double precioVenta) {
		super();
		this.vehiculo = vehiculo;
		this.comprador = comprador;
		this.precioVenta = precioVenta;
	}

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Comprador getComprador() {
		return this.comprador;
	}

	public void setComprador(Comprador comprador) {
		this.comprador = comprador;
	}

	public Double getPrecioVenta() {
		return this.precioVenta;
	}

	public void setPrecioVenta(Double precioVenta) {
		this.precioVenta = precioVenta;
	}

	@Override
	public String toString() {
		return "Venta [vehiculo=" + this.vehiculo + ", comprador=" + this.comprador + ", precioVenta="
				+ this.precioVenta + "]";
	}

}