package ar.edu.unlp.info.oo1.ejercicio2_balanzaElectronica;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlp.info.oo1.ejercicio2_balanzaElectronica.Producto;
import ar.edu.unlp.info.oo1.ejercicio2_balanzaElectronica.Ticket;

public class BalanzaTest {

	private Balanza balanza;

	private Producto queso;

	private Producto jamon;

	@Before
	public void setUp() throws Exception {
		balanza = new Balanza();
		queso = new Producto();
		queso.setPeso(0.1);
		queso.setPrecioPorKilo(140);
		queso.setDescripcion("Queso");

		jamon = new Producto();
		jamon.setDescripcion("Jamón");
		jamon.setPeso(0.1);
		jamon.setPrecioPorKilo(90);
	}

	@Test
	public void testAgregarProducto() {

		balanza.agregarProducto(queso);
		assertEquals(0.1, balanza.getPesoTotal(), 0.01);
		assertEquals(14, balanza.getPrecioTotal(), 0.01);
		assertEquals(1, balanza.getCantidadDeProductos());

		balanza.agregarProducto(jamon);
		assertEquals(0.2, balanza.getPesoTotal(), 0.01);
		assertEquals(23, balanza.getPrecioTotal(), 0.01);
		assertEquals(2, balanza.getCantidadDeProductos());
	}

	@Test
	public void testCantidadDeProductos() {
		assertEquals(0, balanza.getCantidadDeProductos());
		balanza.agregarProducto(queso);
		assertEquals(1, balanza.getCantidadDeProductos());
		balanza.agregarProducto(jamon);
		assertEquals(2, balanza.getCantidadDeProductos());
	}

	@Test
	public void testEmitirTicket() {
		balanza.agregarProducto(queso);
		balanza.agregarProducto(jamon);
		Ticket ticket = balanza.emitirTicket();
		assertEquals(0.2, ticket.getPesoTotal(), 0.01);
		assertEquals(23, ticket.getPrecioTotal(), 0.01);
		assertEquals(2, ticket.getCantidadDeProductos());
		assertEquals(23 * 0.21, ticket.impuesto(), 0.01);
		assertEquals(LocalDate.now(), ticket.getFecha());
	}

	@Test
	public void testConstructor() {
		assertEquals(0, balanza.getPesoTotal(), 0.01);
		assertEquals(0, balanza.getPrecioTotal(), 0.01);
		assertEquals(0, balanza.getCantidadDeProductos());
	}

	@Test
	public void testPesoTotal() {
		assertEquals(0, balanza.getPesoTotal(), 0.01);
		balanza.agregarProducto(queso);
		assertEquals(0.1, balanza.getPesoTotal(), 0.01);
		balanza.agregarProducto(jamon);
		assertEquals(0.2, balanza.getPesoTotal(), 0.01);
	}

	@Test
	public void testPonerEnCero() {
		balanza.agregarProducto(queso);
		balanza.ponerEnCero();
		assertEquals(0, balanza.getPesoTotal(), 0.01);
		assertEquals(0, balanza.getPrecioTotal(), 0.01);
		assertEquals(0, balanza.getCantidadDeProductos());
	}

	@Test
	public void testPrecioTotal() {
		assertEquals(0, balanza.getPrecioTotal(), 0.01);
		balanza.agregarProducto(queso);
		assertEquals(14, balanza.getPrecioTotal(), 0.01);
		balanza.agregarProducto(jamon);
		assertEquals(23, balanza.getPrecioTotal(), 0.01);
	}
}
