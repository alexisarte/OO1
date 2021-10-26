package ar.edu.unlp.info.oo1.ejercicio12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCilindro {

	private Pieza cilindro;

	@BeforeEach
	public void setUp() {
		this.cilindro = new Cilindro("Acero", "Plateado", 30, 150);
	}

	@Test
	public void testVolumenDeMaterial() {
		assertEquals(424115.00823462208719245685674273, this.cilindro.volumen());
	}
	
	@Test
	public void testSuperficieDeMaterial() {
		assertEquals(33929.20065876976, this.cilindro.superficie());
	}

}
