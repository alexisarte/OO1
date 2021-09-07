package ar.edu.unlp.info.oo1.ejercicio2_balanzaElectronica;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import ar.edu.unlp.info.oo1.ejercicio2_balanzaElectronica.Producto;

public class ProductoTest {

	private Producto queso;

	@Before
	public void setUp() throws Exception {
		queso = new Producto();
	}

	@Test
	public void testDescripcion() {
		queso.setDescripcion("Queso crema");
		assertEquals("Queso crema", queso.getDescripcion());
	}

	@Test
	public void testPeso() {
		queso.setPeso(100);
		assertEquals(100, queso.getPeso(), 0.01);
	}

	@Test
	public void testPrecioPorKilo() {
		queso.setPrecioPorKilo(100);
		assertEquals(100, queso.getPrecioPorKilo(), 0.01);
	}

	@Test
	public void testPrecio() {
		queso.setPeso(0.1);
		queso.setPrecioPorKilo(140);
		assertEquals(14, queso.getPrecio(), 0.01);
	}
}
