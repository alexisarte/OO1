package ar.edu.unlp.info.oo1.ejercicio9;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCajoDeAhorro {
	
	private CajaDeAhorro cajaDeAhorro1;
	private CajaDeAhorro cajaDeAhorro2;
	
	@BeforeEach
	public void setUp() {
		this.cajaDeAhorro1 = new CajaDeAhorro();
		this.cajaDeAhorro1.depositar(10000);
		this.cajaDeAhorro2 = new CajaDeAhorro();
	}
	
	@Test
	public void TestDepositar() {
		this.cajaDeAhorro1.depositar(10000);
		assertEquals(19600, this.cajaDeAhorro1.getSaldo());
	}
	
	@Test
	public void TestExtraer() {
		assertFalse(this.cajaDeAhorro1.extraer(9800));
		assertTrue(this.cajaDeAhorro1.extraer(1000));
		assertEquals(8780, this.cajaDeAhorro1.getSaldo());
	}
	
	@Test
	public void TestTransferirACuenta() {
		assertFalse(this.cajaDeAhorro1.transferirACuenta(9800, this.cajaDeAhorro2));
		assertTrue(this.cajaDeAhorro1.transferirACuenta(1000, this.cajaDeAhorro2));
		assertEquals(8780, this.cajaDeAhorro1.getSaldo());
		assertEquals(980, this.cajaDeAhorro2.getSaldo());
	}

}
	
	

