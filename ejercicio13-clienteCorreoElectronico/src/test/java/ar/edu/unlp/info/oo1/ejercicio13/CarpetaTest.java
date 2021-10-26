package ar.edu.unlp.info.oo1.ejercicio13;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarpetaTest {
	
	private Carpeta carpeta;
	private Email email, email2;
	private Archivo archivo;
	
	
	@BeforeEach
	void setUp() throws Exception {
		this.carpeta = new Carpeta("Destacados");
		this.email = new Email("Saludo", "Hola");
		this.email2 = new Email("Saludo2", "Hola2");
		this.archivo = new Archivo("File");
		this.email.agregarArchivo(archivo);
		this.carpeta.agregarEmail(email2);
		this.carpeta.agregarEmail(email);
	}

	@Test
	void buscarTest() {
		assertNull(this.carpeta.buscar("olaH"));
		assertEquals(this.email2, this.carpeta.buscar("Hola"));
	}
	
	@Test
	void espacioOcupadoTest() {
		assertEquals(26, this.carpeta.espacioOcupado());
	}
	
}
