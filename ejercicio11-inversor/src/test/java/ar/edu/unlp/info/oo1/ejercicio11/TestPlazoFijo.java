package ar.edu.unlp.info.oo1.ejercicio11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPlazoFijo {
	
	private Inversion inversion1;
	
	@BeforeEach
	public void setUp() {
		this.inversion1 = new PlazoFijo(LocalDate.now().minusDays(10), 1000, 2);
	}

	@Test
	public void testValorActual() {
		assertEquals(1200, this.inversion1.valorActual());
	}
	
}
