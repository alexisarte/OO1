package ar.edu.unlp.info.oo1.ejercicio16;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaAirbnb {

	private List<Usuario> usuarios;

	public SistemaAirbnb() {
		this.usuarios = new ArrayList<>();
	}

	public Usuario registrarUsuario(String nombre, String direccion, int dni) {
		Usuario usuario = new Usuario(nombre, direccion, dni);
		this.usuarios.add(usuario);
		return usuario;
	}

	public Propiedad registrarPropiedad(String nombre, String descripcion, double precioNoche, String direccion,
			Usuario propietario, IPoliticaCancelacion politica) {
		Propiedad propiedad = new Propiedad(nombre, descripcion, precioNoche, direccion, politica);
		propietario.agregarPropiedad(propiedad);
		return propiedad;
	}

	public List<Propiedad> buscarPropiedadesDisponibles(DateLapse periodo) {
		List<Propiedad> answer = new ArrayList<>();
		this.usuarios.stream().forEach(usuario -> answer.addAll(usuario.buscarPropiedadesDisponibles(periodo)));
		return answer;
	}

	public Reserva reservar(Propiedad propiedad, DateLapse periodo, Usuario inquilino) {
		if (propiedad.estaDisponible(periodo)) {
			Reserva reserva = new Reserva(propiedad, periodo);
			inquilino.agregarReserva(reserva);
			propiedad.agregarReserva(reserva);
			return reserva;
		}
		return null;
	}

	public double precioReserva(Reserva reserva) {
		return reserva.precio();
	}

	public void eliminarReserva(Reserva reserva) {
		if (reserva.fechaInicio().isAfter(LocalDate.now())) {
			this.usuarios.stream().forEach(u -> u.eliminarReserva(reserva));
			reserva.eliminarse();
		}
	}

	public List<Reserva> obtenerReservasUsuario(Usuario usuario) {
		return usuario.getReservas();
	}

	public double ingresosDeUnPropietario(Usuario usuario, DateLapse periodo) {
		return usuario.ingresosPeriodo(periodo);
	}
	
	public double cancelarReserva(Reserva reserva, LocalDate fecha) {
		return reserva.cancelarse(reserva, fecha);
	}

}
