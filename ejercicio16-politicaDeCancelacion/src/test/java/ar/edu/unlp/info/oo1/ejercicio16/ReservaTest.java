package ar.edu.unlp.info.oo1.ejercicio16;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReservaTest {

	private DateLapse periodo, periodo2;
	private Reserva reserva;
	private Propiedad propiedad;
	
	@BeforeEach
	void setUp() throws Exception {
		this.periodo = new DateLapse(LocalDate.of(2001, 9, 11), LocalDate.of(2001, 9, 13));
		this.propiedad = new Propiedad("Propiedad1", "asdasdas", 25, "avenida x");
		this.periodo = new DateLapse(LocalDate.of(2001, 9, 11), LocalDate.of(2001, 9, 13));
		this.periodo2 = new DateLapse(LocalDate.of(2001, 9, 14), LocalDate.of(2001, 9, 30));
		this.reserva = new Reserva(propiedad, periodo);
		this.propiedad.agregarReserva(reserva);
		
	}

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
	
	@Test
	void eliminarse() {
		assertEquals(1, this.propiedad.getReservas().size());
		this.reserva.eliminarse();
		assertEquals(0, this.propiedad.getReservas().size());
	}
	
}
