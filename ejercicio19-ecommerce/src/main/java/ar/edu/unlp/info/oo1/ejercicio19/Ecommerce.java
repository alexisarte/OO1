package ar.edu.unlp.info.oo1.ejercicio19;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ecommerce {

	private List<Vendedor> vendedores;
	private List<Cliente> clientes;
	
	
	public Ecommerce() {
		this.vendedores = new ArrayList<>();
		this.clientes = new ArrayList<>();
	}

	public Vendedor registrarVendedor(String nombre, String direccion) {
		var vendedor = new Vendedor(nombre, direccion);
		this.vendedores.add(vendedor);
		return vendedor;
	}

	public Vendedor buscarVendedor(String nombre) {
		return this.vendedores.stream().filter(v -> v.nombreEsIgualA(nombre)).findAny().orElse(null);
	}

	public Cliente registrarCliente(String nombre, String direccion) {
		var cliente = new Cliente(nombre, direccion);
		this.clientes.add(cliente);
		return cliente;
	}

	public Cliente buscarCliente(String nombre) {
		return this.clientes.stream().filter(c -> c.nombreEsIgualA(nombre)).findAny().orElse(null);
	}
	
	public Producto ponerProductoEnVenta(String nombre, String descripcion, double precio, Integer unidades, Vendedor vendedor) {
		var producto = new Producto(nombre, descripcion, precio, unidades);
		vendedor.agregarProducto(producto);
		return producto;
	}
	
	public List<Producto> buscarProducto(String nombre) {
		return this.vendedores.stream().flatMap(v -> v.buscarProducto(nombre).stream()).collect(Collectors.toList());
	}
	
	public Pedido crearPedido(Cliente cliente, Producto producto, Integer cantidadSolicitada, FormaDePago pago, MecanismoDeEnvio envio) {
		if (producto.abastece(cantidadSolicitada)) {
			var pedido = new Pedido(producto, cantidadSolicitada, pago, envio);
			producto.actualizarUnidades(cantidadSolicitada);
			cliente.agregarPedido(pedido);
			return pedido;
		}
		return null;
	}
	
	public double costoTotalDeUnPedido(Pedido pedido) {
		return pedido.costoTotal();
	}

	public List<Vendedor> getVendedores() {
		return vendedores;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

}
