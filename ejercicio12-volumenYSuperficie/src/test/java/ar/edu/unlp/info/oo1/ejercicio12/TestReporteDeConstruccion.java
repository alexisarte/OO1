package ar.edu.unlp.info.oo1.ejercicio12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestReporteDeConstruccion {

	private ReporteDeConstruccion reporte1;
	private Pieza cilindro;
	private Pieza esfera;
	private Pieza prisma;

	@BeforeEach
	public void setUp() {
		 this.cilindro = new Cilindro("Acero", "Plateado", 30, 150);
		 this.esfera = new Esfera("Hierro", "Gris", 7);
		 this.prisma = new PrismaRectangular("Hierro", "Gris", 9, 9, 4);
		 this.reporte1 = new ReporteDeConstruccion();
		 this.reporte1.agregarPieza(this.cilindro);
		 this.reporte1.agregarPieza(this.esfera);
		 this.reporte1.agregarPieza(this.prisma);
	}

	@Test
	public void testVolumenDeMaterial() {
		assertEquals(this.cilindro.volumen(), this.reporte1.volumenDeMaterial("Acero"));
		assertEquals((this.esfera.volumen() + this.prisma.volumen()), this.reporte1.volumenDeMaterial("Hierro"));
	}
	
	@Test
	public void testSuperficieDeMaterial() {
		assertEquals(this.cilindro.superficie(), this.reporte1.superficiDeColor("Plateado"));
		assertEquals((this.esfera.superficie() + this.prisma.superficie()), this.reporte1.superficiDeColor("Gris"));
	}
	
}
