package ar.edu.unlp.info.oo1.ejercicio16;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Propiedad {

	private String nombre;
	private String descripcion;
	private double precioNoche;
	private String direccion;
	private  IPoliticaCancelacion politica;
	private List<Reserva> reservas;

	public Propiedad(String nombre, String descripcion, double precioNoche, String direccion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioNoche = precioNoche;
		this.direccion = direccion;
		this.reservas = new ArrayList<>();
	}
	
	public Propiedad(String nombre, String descripcion, double precioNoche, String direccion, IPoliticaCancelacion politica) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioNoche = precioNoche;
		this.direccion = direccion;
		this.politica = politica;
		this.reservas = new ArrayList<>();
	}
	
	public double cancelarReserva(Reserva reserva, LocalDate fecha) {
		return this.politica.reembolsar(reserva, fecha);
	}
	
	public boolean estaDisponible(DateLapse periodo) {
		return this.reservas.stream().noneMatch(reserva -> reserva.overlaps(periodo));
	}
	
	public void agregarReserva(Reserva reserva) {
		this.reservas.add(reserva);
	}
	
//	public Reserva agregarReserva(DateLapse periodo, Usuario inquilino) {
//		if (this.estaDisponible(periodo)) {
//			Reserva reserva = new Reserva(this, periodo);
//			inquilino.agregarReserva(reserva);
//			this.reservas.add(reserva);
//			return reserva;
//		}
//		return null;
//	}

	public void eliminarReserva(Reserva reserva) {
		this.reservas.remove(reserva);
	}

	public double montoTotalAlquiler(DateLapse periodo) {
		return this.reservas.stream().filter(reserva -> reserva.incluye(periodo)).mapToDouble(r -> r.precio()).sum();
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public double getPrecioNoche() {
		return precioNoche;
	}

	public String getDireccion() {
		return direccion;
	}

	public List<Reserva> getReservas() {
		return new ArrayList<>(this.reservas);
	}

}
