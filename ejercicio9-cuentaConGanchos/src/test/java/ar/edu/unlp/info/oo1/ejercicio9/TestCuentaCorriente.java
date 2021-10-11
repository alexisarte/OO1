package ar.edu.unlp.info.oo1.ejercicio9;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCuentaCorriente {
	
	private CuentaCorriente cuentaCorriente1;
	private CuentaCorriente cuentaCorriente2;
	
	@BeforeEach
	public void setUp() {
		this.cuentaCorriente1 = new CuentaCorriente();
		this.cuentaCorriente2 = new CuentaCorriente();
		this.cuentaCorriente1.depositar(10000);
		this.cuentaCorriente1.setDescubierto(10000);
	}
	
	@Test
	public void TestDepositar() {
		this.cuentaCorriente1.depositar(10000);
		assertEquals(20000, this.cuentaCorriente1.getSaldo());
	}
	
	@Test
	public void TestExtraer() {
		assertFalse(this.cuentaCorriente1.extraer(20001));
		assertTrue(this.cuentaCorriente1.extraer(20000));
		assertEquals(-10000, this.cuentaCorriente1.getSaldo());
	}
	
	@Test
	public void TestTransferirACuenta() {
		assertFalse(this.cuentaCorriente1.transferirACuenta(20001, this.cuentaCorriente2));
		assertTrue(this.cuentaCorriente1.transferirACuenta(20000, this.cuentaCorriente2));
		assertEquals(-10000, this.cuentaCorriente1.getSaldo());
		assertEquals(20000, this.cuentaCorriente2.getSaldo());
	}
	
}
