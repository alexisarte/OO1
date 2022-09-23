package ar.edu.unlp.info.oo1.ejercicio16;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Usuario {

	private String nombre;
	private String direccion;
	private int dni;
	private List<Propiedad> propiedades;
	private List<Reserva> reservas;

	public Usuario(String nombre, String direccion, int dni) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.dni = dni;
		this.propiedades = new ArrayList<>();
		this.reservas = new ArrayList<>();
	}

	public List<Propiedad> buscarPropiedadesDisponibles(DateLapse periodo) {
		return this.propiedades.stream().filter(propiedad -> propiedad.estaDisponible(periodo))
				.collect(Collectors.toList());
	}

	public double ingresosPeriodo(DateLapse periodo) {
		return this.propiedades.stream().mapToDouble(p -> p.montoTotalAlquiler(periodo)).sum();
	}

	public void agregarPropiedad(Propiedad propiedad) {
		this.propiedades.add(propiedad);
	}

	public void agregarReserva(Reserva reserva) {
		this.reservas.add(reserva);
	}

	public void eliminarReserva(Reserva reserva) {
		this.reservas.remove(reserva);
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public int getDni() {
		return dni;
	}

	public List<Reserva> getReservas() {
		return new ArrayList<>(this.reservas);
	}

}
