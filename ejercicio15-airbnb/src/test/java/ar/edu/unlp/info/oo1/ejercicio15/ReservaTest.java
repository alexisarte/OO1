package ar.edu.unlp.info.oo1.ejercicio15;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReservaTest {

	private DateLapse periodo, periodo2;
	private Reserva reserva;
	private Propiedad propiedad;
	private Usuario usuario;
	
	@BeforeEach
	void setUp() throws Exception {
		this.usuario = new Usuario("John", "Av.Los Olivos", 200000000);
		this.propiedad = new Propiedad("Propiedad1", "asdasdas", 25, "avenida x", usuario);
		this.periodo = new DateLapse(LocalDate.of(2001, 9, 11), LocalDate.of(2001, 9, 13));
		this.periodo2 = new DateLapse(LocalDate.of(2001, 9, 14), LocalDate.of(2001, 9, 30));
		this.reserva = new Reserva(propiedad, periodo, usuario);
		this.propiedad.agregarReserva(reserva);
		
	}
	
//	Solo tester el precio?
	@Test
	void precio() {
		assertEquals(50, this.reserva.precio());
	}
	
	@Test
	void cantidadNoches() {
		assertEquals(2, this.reserva.cantidadNoches());
	}
	
	@Test
	void incluye() {
		assertTrue(this.reserva.incluye(periodo));
		assertFalse(this.reserva.incluye(periodo2));
	}
	
}
