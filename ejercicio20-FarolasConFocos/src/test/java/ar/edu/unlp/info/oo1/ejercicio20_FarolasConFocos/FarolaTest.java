package ar.edu.unlp.info.oo1.ejercicio20_FarolasConFocos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FarolaTest {

	private Farola farolaUno;
	private Farola farolaDos;

	@BeforeEach
	void setUp() throws Exception {
		this.farolaUno = new Farola("PHILIPS", 2);
		this.farolaDos = new Farola("PHILIPS", 2);
	}

	@Test
	void testConstructor() {
		assertFalse(farolaUno.isOn(), "La farolaUno no está apagada");
		assertFalse(farolaUno.isOn(), "La farolaUno no está apagada");
		assertTrue(farolaUno.getNeighbors().isEmpty(), "La farolaUno no debería tener vecinos");
	}

	@Test
	void testPairWithNeighbor() {
		farolaUno.pairWithNeighbor(farolaDos);
		assertTrue(farolaUno.getNeighbors().contains(farolaDos));
		assertTrue(farolaDos.getNeighbors().contains(farolaUno));
	}

	@Test
	void testTurnOnAndOff() {
		farolaUno.pairWithNeighbor(farolaDos);
		farolaUno.turnOn();
		assertTrue(farolaUno.isOn());
		assertTrue(farolaDos.isOn());
		farolaUno.turnOff();
		assertFalse(farolaUno.isOn());
		assertFalse(farolaDos.isOn());

		farolaDos.turnOn();
		assertTrue(farolaUno.isOn());
		assertTrue(farolaDos.isOn());
		farolaDos.turnOff();
		assertFalse(farolaUno.isOn());
		assertFalse(farolaDos.isOn());

	}
	
	@Test
	void testFarolasConFocosVencidos() {
		var farolaTres = new Farola("PHILIPS", 2);
		farolaUno.pairWithNeighbor(farolaDos);
		farolaDos.pairWithNeighbor(farolaTres);
		farolaUno.turnOn();
		farolaUno.turnOff();
		farolaDos.turnOn();
		var farolas = this.farolaUno.farolasConFocosVencidos();
		assertTrue(farolas.contains(farolaUno));
		assertTrue(farolas.contains(farolaDos));
		assertTrue(farolas.contains(farolaTres));
	}
	
}