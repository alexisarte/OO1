package ar.edu.unlp.info.oo1.ejercicio17_ServicioTelefonico;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ServicioTelefonicoTest {

	private ServicioTelefonico servicio;
	private Cliente emisor, receptor;
	private Llamada llamada;

	@BeforeEach
	void setUp() throws Exception {
		this.servicio = new ServicioTelefonico();
		this.servicio.agregarNumero("990000000");
		this.servicio.agregarNumero("990000001");
		this.servicio.agregarNumero("990000002");
		this.emisor = this.servicio.registrarPersonaFisica("Teofilo", "Av.Los Olivos", 4000000);
		this.receptor = this.servicio.registrarPersonaJuridica("Pancracio", "Av.Los Olivos2", "4000001", "S.A.");
		this.servicio.registrarLlamadaLocal(LocalDateTime.now().minusHours(21), 3, "990000000", "990000001");
		this.servicio.registrarLlamadaInterurbana(LocalDateTime.now().minusHours(20), 5, "990000000", "990000001", 60);
		this.servicio.registrarLlamadaInternacional(LocalDateTime.of(2001, 8, 11, 8, 30), 60, "990000000", "990000001",
				"Argentina", "Uruguay");
	}

	@Test
	void agregarNumero() {
		this.servicio.agregarNumero("990000003");
		assertEquals(2, this.servicio.getNumerosTelefonicos().size());
		assertTrue(this.servicio.getNumerosTelefonicos().contains("990000003"));
	}

	@Test
	void registrarPersonaFisica() {
		var cliente = this.servicio.registrarPersonaFisica("Juanito", "Av.Los Olivares", 1000000);
		assertEquals(3, this.servicio.getClientes().size());
		assertTrue(this.servicio.getClientes().contains(cliente));
	}

	@Test
	void registrarPersonaJuridica() {
		var cliente = this.servicio.registrarPersonaJuridica("Juan Perez", "Av.Los Olivos3", "3000000", "Reparticion Provincial");
		assertEquals(3, this.servicio.getClientes().size());
		assertTrue(this.servicio.getClientes().contains(cliente));
	}
	
	@Test
	void registrarLlamadaLocal() {
		this.llamada = this.servicio.registrarLlamadaLocal(LocalDateTime.now().minusHours(21), 3, "990000000", "990000001");
		assertTrue(this.emisor.getLlamadas().contains(llamada));
	}
	
	@Test
	void registrarLlamadaInterurbana() {
		this.llamada = this.servicio.registrarLlamadaInterurbana(LocalDateTime.now().minusHours(20), 5, "990000000", "990000001", 60);		
		assertTrue(this.emisor.getLlamadas().contains(llamada));
	}

	@Test
	void registrarLlamadaInternacional() {
		this.llamada = this.servicio.registrarLlamadaInternacional(LocalDateTime.of(2001, 8, 11, 8, 30), 60, "990000000", "990000001",
				"Argentina", "Uruguay");
		assertTrue(this.emisor.getLlamadas().contains(llamada));
	}

	@Test
	void facturarLlamadas() {
		Factura factura = this.servicio.facturarLlamadas(emisor, LocalDateTime.now().minusHours(22), LocalDateTime.now());
		assertEquals(16.2, factura.getMontoTotal());
	}

}
