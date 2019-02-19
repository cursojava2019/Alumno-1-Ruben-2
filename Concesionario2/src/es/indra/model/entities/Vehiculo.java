package es.indra.model.entities;

import java.io.Serializable;

public class Vehiculo implements Serializable {

	public static String COCHE = "coche";
	public static String MOTO = "moto";
	public static String CAMION = "camion";

	private Long codigo;
	private String marca;
	private String modelo;
	private String tipo;
	private Integer anio;
	private Integer kilometraje;
	private Boolean vendido;

	public Vehiculo() {
		super();
	}

	public Vehiculo(Long codigo, String marca, String modelo, String tipo, Integer anio, Integer kilometraje,
			Boolean vendido) {
		super();
		this.codigo = codigo;
		this.marca = marca;
		this.tipo = valideTipo(tipo);
		this.anio = anio;
		this.kilometraje = kilometraje;
		this.vendido = vendido;
		this.modelo = modelo;
	}

	private String valideTipo(String s) {
		if (s.equals(CAMION) || s.equals(COCHE) || s.equals(MOTO)) {
			return s;
		} else {
			return COCHE;
		}

	}

	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = valideTipo(tipo);
	}

	public Integer getAnio() {
		return this.anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Integer getKilometraje() {
		return this.kilometraje;
	}

	public void setKilometraje(Integer kilometraje) {
		this.kilometraje = kilometraje;
	}

	public Boolean getVendido() {
		return this.vendido;
	}

	public void setVendido(Boolean vendido) {
		this.vendido = vendido;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Vehiculo [codigo=" + this.codigo + ", marca=" + this.marca + ", modelo=" + this.modelo + ", tipo="
				+ this.tipo + ", anio=" + this.anio + ", kilometraje=" + this.kilometraje + ", vendido=" + this.vendido
				+ "]";
	}

}
