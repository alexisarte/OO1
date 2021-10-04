package ar.edu.unlp.info.oo1.ejercicio4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCirculo {

	private Circulo circulo;
	
	@BeforeEach
	public void setUp() {
		circulo = new Circulo();
		circulo.setRadio(3);
	}
	
	@Test
	public void testDiametro() {
		assertEquals(6, circulo.getDiametro());
	}
	@Test
	public void testArea() {
		double areaRedondeo = Math.round(circulo.getArea()*100.0)/100.0;
		assertEquals(28.27, areaRedondeo);
	}
	@Test
	public void testPerimetro() {
		double perimetroRedondeo = Math.round(circulo.getPerimetro()*100.0)/100.0;
		assertEquals(18.85, perimetroRedondeo);
	}
	@Test
	public void testRadio() {
		assertEquals(3, circulo.getRadio());
	}
}