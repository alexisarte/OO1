package ar.edu.unlp.info.oo1.ejercicio15;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Propiedad {

	private String nombre;
	private String descripcion;
	private double precioNoche;
	private String direccion;
	private Usuario propietario;
	private List<Reserva> reservas;

	public Propiedad(String nombre, String descripcion, double precioNoche, String direccion, Usuario propietario) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioNoche = precioNoche;
		this.direccion = direccion;
		this.propietario = propietario;
		this.reservas = new ArrayList<>();
	}

	public boolean estaDisponible(DateLapse periodo) {
		return this.reservas.stream().noneMatch(reserva -> reserva.overlaps(periodo));
	}

	public List<Reserva> obtenerReservasUsuario(Usuario usuario) {
		return this.reservas.stream().filter(r -> r.usuarioEsIgualA(usuario)).collect(Collectors.toList());
	}
	
//	El usuario deberia compararse asi mismo?
	public double ingresosPropietario(Usuario usuario, DateLapse periodo) {
		if (this.propietario.equals(usuario))
			return this.reservas.stream().filter(r -> r.incluye(periodo)).mapToDouble(Reserva::precio).sum();
		return 0;
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
