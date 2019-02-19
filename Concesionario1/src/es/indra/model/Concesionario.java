package es.indra.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class Concesionario implements Serializable {

	private TreeMap<String, Comprador> compradores;
	private TreeMap<Long, Vehiculo> vehiculos;
	private ArrayList<Venta> ventas;

	public Concesionario() {
		this.compradores = new TreeMap<String, Comprador>();
		this.vehiculos = new TreeMap<Long, Vehiculo>();
		this.ventas = new ArrayList<Venta>();

	}

	public TreeMap<Long, Vehiculo> getVehiculos() {
		return this.vehiculos;
	}

	public void setVehiculos(TreeMap<Long, Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public Boolean aniadirComprador(Comprador p) {
		this.compradores.put(p.getDni(), p);
		return true;
	}

	public Comprador obtenerComprador(String dni) {
		return this.compradores.get(dni);
	}

	public Boolean aniadirVehiculo(Vehiculo v) {
		this.vehiculos.put(v.getCodigo(), v);
		return true;
	}

	public Vehiculo obtenerVehiculo(Long codigo) {
		return this.vehiculos.get(codigo);
	}

	public List<Vehiculo> vehiculosDisponibles() {
		ArrayList<Vehiculo> listado = new ArrayList<Vehiculo>(this.vehiculos.values());
		LinkedList<Vehiculo> disponibles = new LinkedList<Vehiculo>();

		for (Vehiculo vehiculo : listado) {
			if (!vehiculo.getVendido()) {
				disponibles.add(vehiculo);
			}
		}
		return disponibles;
	}

	public List<Vehiculo> vehiculosPropietario(String dni) {
		Comprador c = this.compradores.get(dni);
		if (c != null) {
			return c.getPropiedades();

		} else {
			return null;
		}
	}

	public Venta nuevaVenta(String dni, Long codigo, Double precio) {
		Comprador comprador = this.compradores.get(dni);
		Vehiculo vehiculo = this.vehiculos.get(codigo);
		if (comprador != null && vehiculo != null) {
			Venta v = new Venta();
			v.setComprador(comprador);
			v.setVehiculo(vehiculo);
			v.setPrecioVenta(precio);
			vehiculo.setVendido(true);
			comprador.getPropiedades().add(vehiculo);
			this.ventas.add(v);
			return v;

		} else {

			return null;
		}

	}

}