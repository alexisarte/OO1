package ar.edu.unlp.info.oo1.ejercicio7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GerenteTest {

	private Gerente alan;

	@BeforeEach
	public void setUp() {
		this.alan = new Gerente("Alan Turing");
	}
	
	@Test
	public void testAportes() {
		assertEquals(2850.0, this.alan.aportes());
	}
	
	@Test
	public void testMontoBasico() {
		assertEquals(43000, this.alan.sueldoBasico());
	}
	
}
