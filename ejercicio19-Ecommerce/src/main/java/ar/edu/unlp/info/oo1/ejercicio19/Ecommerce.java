package ar.edu.unlp.info.oo1.ejercicio19;

import java.util.List;

public class Ecommerce {

	private List<Vendedor> vendedores;
	private List<Cliente> clientes;

	public Vendedor registrarVendedor(String nombre, String direccion) {
		return null;
	}

	public Vendedor buscarVendedor(String nombre) {
		return null;
	}

	public Cliente registrarCliente(String nombre, String direccion) {
		return null;
	}

	public Cliente buscarCliente(String nombre) {

		return null;
	}
	
	public Producto ponerProductoEnVenta(String nombre, String descripcion, double precio, Integer unidades, Vendedor vendedor) {
		return null;
	}
	
	public List<Producto> buscarProducto(String nombre) {
		return null;
	}
	
//	Retorna el pedido
	public Pedido crearPedido(Cliente cliente, Producto producto, Integer unidadesProducto, FormaDePago pago, MecanismoDeEnvio envio) {
		return null;
	}
	
	public double costoTotalDeUnPedido(Pedido pedido) {
		return 0;
	}

	public List<Vendedor> getVendedores() {
		return vendedores;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

}
