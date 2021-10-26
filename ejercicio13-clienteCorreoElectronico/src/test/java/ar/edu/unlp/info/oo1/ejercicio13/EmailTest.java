package ar.edu.unlp.info.oo1.ejercicio13;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmailTest {
	
	private Email email;
	private Archivo archivo;
	
	@BeforeEach
	void setUp() throws Exception {
		this.email = new Email("Saludo", "Hola");
		this.archivo = new Archivo("File");
	}

	@Test
	void contieneTest() {
		assertTrue(this.email.contiene("Hola"));
		assertNotEquals(this.email, this.email.contiene("aloH"));
	}
	
	@Test
	void espacioOcupadoTest() {
		this.email.agregarArchivo(this.archivo);
		assertEquals(14, this.email.espacioOcupado());
		
	}
	
}
