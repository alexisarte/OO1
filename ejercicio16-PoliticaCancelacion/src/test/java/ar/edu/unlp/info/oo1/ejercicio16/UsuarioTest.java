package ar.edu.unlp.info.oo1.ejercicio16;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsuarioTest {
	
	private Usuario propietario, inquilino;
	private Propiedad propiedad, propiedad2;
	private Reserva reserva;
	private DateLapse periodo;
	
	@BeforeEach
	void setUp() throws Exception {
		this.propietario = new Usuario("Juan", "Av.Las Palmas", 100000000);
		this.inquilino = new Usuario("John", "Av.Los Olivos", 200000000);
		this.periodo = new DateLapse(LocalDate.of(2001, 9, 11), LocalDate.of(2001, 9, 13));
		this.propiedad = new Propiedad("Propiedad1", "asdasdas", 25, "avenida x");
		this.propiedad2 = new Propiedad("Propiedad2", "asdasdas", 25, "avenida x");
		this.reserva = new Reserva(propiedad, periodo);
		
		this.propiedad.agregarReserva(reserva);
		this.propietario.agregarPropiedad(propiedad);
		this.propietario.agregarPropiedad(propiedad2);
		this.propietario.agregarReserva(reserva);
		
//		El propietario deberia verse afectado?
		this.inquilino.agregarReserva(reserva);
	}

	@Test
	void buscarPropiedadesDisponibles() {
		assertEquals(1, this.propietario.buscarPropiedadesDisponibles(periodo).size());
	}
	
	@Test
	void ingresosPeriodo() {
		assertEquals(50, this.propietario.ingresosPeriodo(periodo));
	}
//	Es necesario testear esto?
	@Test
	void agregarReserva() {
		this.propietario.agregarReserva(reserva);
		assertEquals(2, this.propietario.getReservas().size());
	}
//	Es necesario testear esto?
	@Test
	void eliminarReserva() {
		this.inquilino.eliminarReserva(reserva);
		assertEquals(0, this.inquilino.getReservas().size());
	}
	
}
