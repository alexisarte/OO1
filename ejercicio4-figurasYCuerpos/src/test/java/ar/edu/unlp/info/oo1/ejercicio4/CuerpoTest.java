package ar.edu.unlp.info.oo1.ejercicio4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CuerpoTest {
	private Cuerpo3D cilindro;
	private Cuerpo3D prisma;
	
	@BeforeEach
	public void setUp() {
		Circulo circulo = new Circulo();
		circulo.setRadio(3);	

		Cuadrado cuadrado = new Cuadrado();
		cuadrado.setLado(3);
		
		cilindro = new Cuerpo3D();
		cilindro.setAltura(5);
		cilindro.setCaraBasal(circulo);
		
		prisma = new Cuerpo3D();
		prisma.setAltura(7);
		prisma.setCaraBasal(cuadrado);
	}
	
	@Test
	public void testAltura() {
		assertEquals(7, prisma.getAltura());
		assertEquals(5, cilindro.getAltura());
	}
	
	@Test
	public void testSuperficieExterior() {
		assertEquals( 2*9 + (12*7), prisma.getSuperficieExterior());
		double superficieRedondeado = Math.round(cilindro.getSuperficieExterior()*100.0)/100.0; 
		double esperadoRedondeado = Math.round((2 * 28.2743 + (18.8495 * 5))*100.0)/ 100.0; 		
				
		assertEquals(superficieRedondeado, esperadoRedondeado);
	}
	
	@Test
	public void testVolumen() {
		double volumenRedondeado = Math.round(cilindro.getVolumen() * 100.0)/100.0;
		double esperadoRedondeado = Math.round(28.2743 * 5 * 100.0)/100.0;
		assertEquals(volumenRedondeado, esperadoRedondeado);
		
		assertEquals(63, prisma.getVolumen());
	}
	
}
