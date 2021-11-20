package ar.edu.unlp.info.oo1.ejercicio18_LiquidacionDeHaberes;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LiquidadoraTest {

	private Liquidadora liquidadora;
	private Empleado empleado, empleado2, empleado3;
	
	@BeforeEach
	void setUp() throws Exception {
		this.liquidadora = new Liquidadora();
		this.empleado = this.liquidadora.registrarEmpleado("Juan", "Perez", "20123456789", LocalDate.now(), false, false);
		this.empleado2 = this.liquidadora.registrarEmpleado("John", "Doe", "20123456788", LocalDate.now(), true, false);
		this.empleado3 = this.liquidadora.registrarEmpleado("Maria", "Doe", "20123456787", LocalDate.now(), true, true);
		this.liquidadora.cargarContratoPorHoras(empleado, LocalDate.now().minusMonths(11), LocalDate.now(), 10, 160);
		this.liquidadora.cargarContratoDePlanta(empleado, LocalDate.now(), 2000, 10, 10);		
		this.liquidadora.cargarContratoPorHoras(empleado2, LocalDate.now().minusYears(8), LocalDate.now().minusYears(3), 10, 160);
		this.liquidadora.cargarContratoPorHoras(empleado3, LocalDate.now().minusYears(10), LocalDate.now().minusYears(5), 10, 160);
	}

//	@Test
//	void registrarEmpleado() {
//		assertEquals(, this.liquidadora.getEmpleados().size());
//	}
	
	@Test
	void buscarEmpleado() {
		assertEquals(this.empleado, this.liquidadora.buscarEmpleado("20123456789"));
	}
	
//	@Test
//	void eliminarEmpleado() {
//		assertEquals(0, this.liquidadora.getEmpleados().size());
//	}
	
	@Test
	void cargarContratoPorHoras() {
		var contrato = this.liquidadora.cargarContratoPorHoras(empleado, LocalDate.now(), LocalDate.now().plusYears(1), 11, 159);
		assertTrue(this.empleado.getContratos().contains(contrato));
	}
	
	@Test
	void cargarContratoDePlanta() {
		var contrato = this.liquidadora.cargarContratoDePlanta(empleado, LocalDate.now(), 2000, 9, 9);
		assertTrue(this.empleado.getContratos().contains(contrato));
	}
	
	@Test
	void obtenerEmpleadosContratosVencidos() {
		var empleados = this.liquidadora.obtenerEmpleadosContratosVencidos();
		assertFalse(empleados.contains(this.empleado));
	}
	
	@Test
	void generarRecibos() {
		assertEquals(2, this.liquidadora.generarRecibos().size());
	}
	

}
