package ar.edu.unlp.info.oo1.ejercicio15;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ServicioDePropiedadesTest {

	private ServicioDePropiedades servicioPropiedades;
//	Debo usar ServicioDeUsuarios para crear usuarios en todos los tests?
	private ServicioDeUsuarios servicioUsuarios;
	private Usuario propietario, usuario;
	private DateLapse periodo, periodo2;
	private Propiedad propiedad, propiedad2, propiedad3;
	private Reserva reserva, reserva2, reserva3;

	@BeforeEach
	void setUp() throws Exception {
		this.servicioPropiedades = new ServicioDePropiedades();
		this.servicioUsuarios = new ServicioDeUsuarios();
		
		this.usuario = this.servicioUsuarios.registrarUsuario("John", "Av.Los Olivos", 200000000);
		this.propietario = this.servicioUsuarios.registrarUsuario("Juan", "Av.Las Palmas", 100000000);

		this.propiedad = this.servicioPropiedades.registrarPropiedad("Propiedad1", "asdasdas", 25, "avenida x", propietario);
		this.propiedad2 = this.servicioPropiedades.registrarPropiedad("Propiedad2", "asdasdas", 25, "avenida x", propietario);
		this.propiedad3 = this.servicioPropiedades.registrarPropiedad("Propiedad3", "asdasdas", 25, "avenida x", propietario);

		this.periodo = new DateLapse(LocalDate.of(2001, 9, 11), LocalDate.of(2001, 9, 13));
		this.periodo2 = new DateLapse(LocalDate.now().plusDays(10), LocalDate.now().plusDays(20));

		this.reserva = this.servicioPropiedades.reservar(propiedad, periodo, usuario);
		this.reserva2 = this.servicioPropiedades.reservar(propiedad, periodo2, usuario);
	}
	
	@Test
	void buscarPropiedadesDisponibles() {
		var propiedades = this.servicioPropiedades.buscarPropiedadesDisponibles(periodo);
		assertEquals(2, propiedades.size());
		assertFalse(propiedades.contains(propiedad));	
	}
	
	@Test
	void reservar() {
		this.reserva3 = this.servicioPropiedades.reservar(propiedad, periodo, usuario);
		assertFalse(this.propiedad.getReservas().contains(reserva3));
		this.reserva3 = this.servicioPropiedades.reservar(propiedad3, periodo, usuario);
		assertTrue(this.propiedad3.getReservas().contains(reserva3));
	}

	@Test
	void eliminarReserva() {
		this.servicioPropiedades.eliminarReserva(reserva2);
		assertEquals(1, this.propiedad.getReservas().size());
		assertFalse(this.propiedad.getReservas().contains(reserva2));
		this.servicioPropiedades.eliminarReserva(reserva);
		assertTrue(this.propiedad.getReservas().contains(reserva));
	}

	@Test
	void obtenerReservasUsuario() {
		var reservas = this.servicioPropiedades.obtenerReservasUsuario(usuario);
		assertEquals(2, reservas.size());
		assertTrue(reservas.contains(reserva));
	}

	@Test
	void ingresosDeUnPropietario() {
		assertEquals(50, this.servicioPropiedades.ingresosPropietario(propietario, periodo));
	}

}
