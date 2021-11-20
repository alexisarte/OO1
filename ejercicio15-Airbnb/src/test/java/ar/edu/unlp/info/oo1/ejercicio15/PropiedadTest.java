package ar.edu.unlp.info.oo1.ejercicio15;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropiedadTest {

	private Propiedad propiedad;
	private Reserva reserva;
	private DateLapse periodo, periodo2;
	private Usuario propietario, usuario;

	@BeforeEach
	void setUp() throws Exception {
		this.propietario = new Usuario("Juan", "Av.Las Palmas", 100000000);
		this.usuario = new Usuario("John", "Av.Los Olivos", 200000000);
		this.propiedad = new Propiedad("Propiedad1", "asdasdas", 25, "avenida x", propietario);
		this.periodo = new DateLapse(LocalDate.of(2001, 9, 11), LocalDate.of(2001, 9, 13));
		this.periodo2 = new DateLapse(LocalDate.of(2001, 9, 14), LocalDate.of(2001, 9, 30));
		this.reserva = new Reserva(propiedad, periodo, usuario);
		this.propiedad.agregarReserva(reserva);
	}

	@Test
	void estaDisponible() {
		assertFalse(this.propiedad.estaDisponible(periodo));
		assertTrue(this.propiedad.estaDisponible(periodo2));
	}
	
//	Esta bien pedirle los ingresos a la propiedad de su propietario y enviarle el propietario? no es redundante
	@Test
	void ingresosPropietario() {
		assertEquals(50, this.propiedad.ingresosPropietario(propietario, periodo));
		
	}
	
	@Test
	void obtenerReservasUsuario() {
		assertEquals(1, this.propiedad.obtenerReservasUsuario(usuario).size());
	}
	
	@Test
	void agregarReserva() { 
		this.propiedad.agregarReserva(reserva);
		assertEquals(2, this.propiedad.getReservas().size());
	}
	
	@Test
	void eliminarReserva() {
		this.propiedad.eliminarReserva(this.reserva);
		assertEquals(0, this.propiedad.getReservas().size());
	}
	
}