package ar.edu.unlp.info.oo1.ejercicio13;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArchivoTest {
	
	private Archivo archivo;
	
	@BeforeEach
	void setUp() throws Exception {
		this.archivo = new Archivo("File");
	}

	@Test
	void tamanioTest() {
		assertEquals(4, this.archivo.tamanio());
	}

}
