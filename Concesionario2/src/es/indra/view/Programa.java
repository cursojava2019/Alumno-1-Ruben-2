package es.indra.view;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import es.indra.controller.Concesionario;
import es.indra.model.entities.Comprador;
import es.indra.model.entities.Vehiculo;
import es.indra.model.entities.Venta;

public class Programa {

	private static Scanner ENTRADA;
	private static Concesionario concesionario = null;

	public static void init() throws ClassNotFoundException, IOException {
		ENTRADA = new Scanner(System.in);
		concesionario = new Concesionario();
	}

	public static void fin() throws IOException {

	}

	public static void main(String[] args) {
		try {
			init();
		} catch (ClassNotFoundException | IOException e1) {
			System.out.println("Error al iniciar de disco. Inicializamos el concesioinaro");
			concesionario = new Concesionario();
		}
		System.out.println("BIENVENIDO AL CONCESIONARIO");
		int opcion = 0;
		try {
			do {

				System.out.println("Introduzca la Operacion que desea Realizar");
				System.out.println("1. Añadir Propietario");
				System.out.println("2. Añadir Vehiculo");
				System.out.println("3. Lista Vehiculos disponibles");
				System.out.println("4. Lista Vehiculos por propietario");
				System.out.println("5. Introducir Venta");

				System.out.println("0. Finalizar");
				opcion = ENTRADA.nextInt();
				ENTRADA.nextLine();
				switch (opcion) {
				case 1:
					aniadirPropietario();
					fin();
					break;
				case 2:
					aniadirVehiculo();
					fin();
					break;
				case 3:
					listarVehiculosDisponibles();
					break;
				case 4:
					listarVehiculosPropietario();
					break;
				case 5:
					crearVenta();
					fin();
					break;
				case 0:
					System.out.println("Fin del programa");
				default:
					break;
				}

			} while (opcion != 0);
		} catch (Exception e) {

			System.out.println("Error al guardar en fichero");
			e.printStackTrace();
		}
		try {
			fin();
		} catch (IOException e) {
			System.out.println("NO SE HA PODIDO GUARDAR.  ERROR FATAL");
			e.printStackTrace();
		}
	}

	/*												*/

	public static void aniadirPropietario() {
		System.out.println("Introduzca los datos del usuario");
		System.out.println("Introduzca dni y pulse intro");
		String dni = ENTRADA.nextLine();
		System.out.println("Introduzca nombre y pulse intro");
		String nombre = ENTRADA.nextLine();
		System.out.println("Introduzca apellidos y pulse intro");
		String apellidos = ENTRADA.nextLine();
		System.out.println("Introduzca telefono y pulse intro");
		String telefono = ENTRADA.nextLine();
		System.out.println("Introduzca direccion y pulse intro");
		String direccion = ENTRADA.nextLine();
		System.out.println("Introduzca CP y pulse intro");
		String cp = ENTRADA.nextLine();
		Comprador comprador = new Comprador(dni, nombre, apellidos, telefono, direccion, cp);
		concesionario.aniadirComprador(comprador);
		System.out.println("Comprador Añadido correctamente");

		List<Comprador> lista = concesionario.listarCompradores();
		System.out.println(lista);
	}

	public static void aniadirVehiculo() {
		System.out.println("Introduzca los datos del vehiculo");
		System.out.println("Introduzca codigo y pulse intro");
		Long codigo = ENTRADA.nextLong();
		ENTRADA.nextLine();
		System.out.println("Introduzca anio y pulse intro");
		Integer anio = ENTRADA.nextInt();
		ENTRADA.nextLine();
		System.out.println("Introduzca kilometraje y pulse intro");
		Integer km = ENTRADA.nextInt();
		ENTRADA.nextLine();
		System.out.println("Introduzca marca y pulse intro");
		String marca = ENTRADA.nextLine();
		System.out.println("Introduzca tipo y pulse intro");
		String tipo = ENTRADA.nextLine();
		Vehiculo v = new Vehiculo(codigo, marca, "", tipo, anio, km, false);
		concesionario.aniadirVehiculo(v);
		System.out.println("Vehiculo añadido correctamente");
	}

	public static void listarVehiculosDisponibles() {
		System.out.println("Listado de Vehiculos");
		List<Vehiculo> listado = concesionario.vehiculosDisponibles();
		for (Vehiculo vehiculo : listado) {
			System.out.println(vehiculo);
		}
	}

	public static void listarVehiculosPropietario() {
		System.out.println("Introduzca el dni del propietario");
		String dni = ENTRADA.nextLine();
		Comprador c = concesionario.obtenerComprador(dni);
		if (c != null) {
			List<Vehiculo> listado = concesionario.vehiculosPropietario(dni);

			System.out.println("El comprador indicado es: " + c);
			for (Vehiculo vehiculo : listado) {
				System.out.println(vehiculo);
			}
		} else {
			System.out.println("El comprador indicado no esta en la BBDD");
		}
	}

	public static void crearVenta() {
		System.out.println("Introduzca el codigo del vehiculo a vender");

		Long codigo = ENTRADA.nextLong();
		ENTRADA.nextLine();
		Vehiculo v = concesionario.obtenerVehiculo(codigo);
		if (v == null) {
			System.out.println(" No se ha encontrado el vehiculo. ");
			return;
		}

		System.out.println("Introduzca el dni del comprador");
		String dni = ENTRADA.nextLine();
		Comprador c = concesionario.obtenerComprador(dni);
		if (c == null) {
			System.out.println(" No se ha encontrado el comprador. ");
			return;
		}

		System.out.println("Introduzca el PVP de venta");
		Double precio = ENTRADA.nextDouble();
		ENTRADA.nextLine();
		Venta venta = concesionario.nuevaVenta(dni, codigo, precio);

	}

}