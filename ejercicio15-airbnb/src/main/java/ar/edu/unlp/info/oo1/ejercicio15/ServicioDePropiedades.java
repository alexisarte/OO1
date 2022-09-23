package ar.edu.unlp.info.oo1.ejercicio15;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ServicioDePropiedades {

	private List<Propiedad> propiedades;

	public ServicioDePropiedades() {
		this.propiedades = new ArrayList<>();
	}

	public Propiedad registrarPropiedad(String nombre, String descripcion, double precioNoche, String direccion,
			Usuario propietario) {
		Propiedad propiedad = new Propiedad(nombre, descripcion, precioNoche, direccion, propietario);
		this.propiedades.add(propiedad);
		return propiedad;
	}

	public List<Propiedad> buscarPropiedadesDisponibles(DateLapse periodo) {
		return this.propiedades.stream().filter(p -> p.estaDisponible(periodo)).collect(Collectors.toList());
	}
	
	public Reserva reservar(Propiedad propiedad, DateLapse periodo, Usuario inquilino) {
		if (propiedad.estaDisponible(periodo)) {
			Reserva reserva = new Reserva(propiedad, periodo, inquilino);
			propiedad.agregarReserva(reserva);
			return reserva;
		}
		return null;
	}
	
	public void eliminarReserva(Reserva reserva) {
		if (reserva.fechaInicio().isAfter(LocalDate.now())) {
			this.propiedades.stream().forEach(p -> p.eliminarReserva(reserva));
		}
	}

	public List<Reserva> obtenerReservasUsuario(Usuario usuario) {
		return this.propiedades.stream().flatMap(p -> p.obtenerReservasUsuario(usuario).stream()).collect(Collectors.toList());
	}

	public double ingresosPropietario(Usuario usuario, DateLapse periodo) {
		return this.propiedades.stream().mapToDouble(p -> p.ingresosPropietario(usuario, periodo)).sum();
	}

}
