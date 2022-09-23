package ar.edu.unlp.info.oo1.ejercicio16;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SistemaAirbnbTest {

	private SistemaAirbnb servicio;
	private Usuario propietario, inquilino, inquilino2;
	private DateLapse periodo, periodo2;
	private Propiedad propiedad, propiedad2, propiedad3;
	private Reserva reserva, reserva2, reserva3;
	private IPoliticaCancelacion politica, politica2, politica3;

	@BeforeEach
	void setUp() throws Exception {
		
		this.servicio = new SistemaAirbnb();
		
		this.propietario = this.servicio.registrarUsuario("Juan", "Av.Las Palmas", 100000000);
		this.inquilino = this.servicio.registrarUsuario("John", "Av.Los Olivos", 200000000);
		this.inquilino2 = this.servicio.registrarUsuario("John2", "Av.Los Olivos", 300000000);
		
		this.politica = new PoliticaFlexible();
		this.politica2 = new PoliticaModerada();
		this.politica3 = new PoliticaEstricta();
		
		this.propiedad = this.servicio.registrarPropiedad("Propiedad1", "asdasdas", 25, "avenida x", propietario, politica);
		this.propiedad2 = this.servicio.registrarPropiedad("Propiedad2", "asdasdas", 25, "avenida x", propietario, politica2);
		this.propiedad3 = this.servicio.registrarPropiedad("Propiedad3", "asdasdas", 25, "avenida x", propietario, politica3);
		
		this.periodo = new DateLapse(LocalDate.of(2001, 9, 11), LocalDate.of(2001, 9, 13));
		this.periodo2 = new DateLapse(LocalDate.now().plusDays(10), LocalDate.now().plusDays(20));
		
		this.reserva = this.servicio.reservar(propiedad, periodo, inquilino);
		this.reserva2 = this.servicio.reservar(propiedad2, periodo2, inquilino2);
		this.reserva3 = this.servicio.reservar(propiedad3, periodo, inquilino);
	}

	@Test
	void testbuscarPropiedadesDisponibles() {
		assertEquals(2, this.servicio.buscarPropiedadesDisponibles(periodo2).size());
	}

	@Test
	void testReservar() {
		assertNull(this.servicio.reservar(propiedad, periodo, inquilino));
		assertNotNull(this.servicio.reservar(propiedad2, periodo, inquilino));
	}

	@Test
	void testPrecioReserva() {
		assertEquals(50, this.servicio.precioReserva(reserva));
	}
	
	@Test
	void testCancelarReserva() {
		assertEquals(50, this.servicio.cancelarReserva(reserva, LocalDate.of(2001, 9, 10)));
		assertEquals(250, this.servicio.cancelarReserva(reserva2, LocalDate.now()));
		assertEquals(0, this.servicio.cancelarReserva(reserva3, LocalDate.of(2001, 9, 10)));
	}
	
	@Test
	void testEliminarReserva() {
		this.servicio.eliminarReserva(reserva2);
		assertEquals(0, this.inquilino2.getReservas().size());
	}

	@Test
	void testObtenerReservasUsuario() {
		this.servicio.reservar(propiedad3, periodo, inquilino);
		assertEquals(2, this.inquilino.getReservas().size());
	}

	@Test
	void ingresosDeUnPropietario() {
		this.servicio.reservar(propiedad3, periodo, inquilino2);
		this.servicio.reservar(propiedad3, periodo2, inquilino);
		assertEquals(100, this.servicio.ingresosDeUnPropietario(propietario, periodo));
	}

}
