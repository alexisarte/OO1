package ar.edu.unlp.info.oo1.ejercicio19;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EcommerceTest {
	
	private Ecommerce ecommerce;
	private Vendedor vendedor, vendedor2;
	private Cliente cliente, cliente2;
	private Producto producto, producto2;
	private Pedido pedido;
	private FormaDePago pago;
	private MecanismoDeEnvio envio;
	
	@BeforeEach
	void setUp() throws Exception {
		this.ecommerce = new Ecommerce();
		this.vendedor = this.ecommerce.registrarVendedor("Jose", "4321");
		this.cliente = this.ecommerce.registrarCliente("Arturito", "1234");
		this.producto = this.ecommerce.ponerProductoEnVenta("Monopoly", "Juego de Mesa", 25, 1000, vendedor);
		this.pago = new PagoAlContado(producto);
		this.envio = new RetirarEnComercio(vendedor, cliente);
		this.pedido = this.ecommerce.crearPedido(cliente, producto, 50, pago, envio);
	}

	@Test
	void registrarVendedor() {
		this.vendedor2 = this.ecommerce.registrarVendedor("John", "9876");
		assertEquals(this.vendedor2, this.ecommerce.buscarVendedor("John"));
//		assertTrue(this.ecommerce.getVendedores().contains(vendedor2));
	}
	
	@Test
	void buscarVendedor() {
		assertEquals(this.vendedor, this.ecommerce.buscarVendedor("Jose"));
	}
	
	@Test
	void registrarCliente() {
		this.cliente2 = this.ecommerce.registrarCliente("Juanito", "1010");
		assertTrue(this.ecommerce.getClientes().contains(cliente2));
	}
	
	@Test
	void buscarCliente() {
		assertEquals(this.cliente, this.ecommerce.buscarCliente("Arturito"));
	}
	
	@Test
	void ponerProductoEnVenta() {
		this.producto2 = this.ecommerce.ponerProductoEnVenta("Celular", "Smartphone", 200, 100, vendedor);
		assertTrue(this.vendedor.getProductos().contains(producto2));
	}
	
	@Test
	void buscarProducto() {
		var productos = this.ecommerce.buscarProducto("Monopoly");
		assertTrue(productos.contains(producto));
	}
	
	@Test
	void crearPedido() {
		assertTrue(this.cliente.getPedidos().contains(pedido));
		var pedido2 = this.ecommerce.crearPedido(cliente, producto, 951, pago, envio);
		assertFalse(this.cliente.getPedidos().contains(pedido2));
	}
	
	@Test
	void costoTotalDeUnPedido() {
		assertEquals(this.producto.getPrecio(), this.ecommerce.costoTotalDeUnPedido(pedido));
	}
	
}
