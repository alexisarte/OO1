package ar.edu.unlp.info.oo1.ejercicio11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestInversionEnAcciones {
	
	private InversionEnAcciones inversion1;
	
	@BeforeEach
	public void setUp() {
		this.inversion1 = new InversionEnAcciones("SpaceX", 1000, 676);
	}

	@Test
	public void testValorActual() {
		assertEquals(676000, this.inversion1.valorActual());
	}
	
}
