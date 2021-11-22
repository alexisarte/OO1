package ar.edu.unlp.info.oo1.ejercicio19;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Vendedor extends Usuario {
	
	private List<Producto> productos;
	
	public Vendedor(String nombre, String direccion) {
		super(nombre, direccion);
		this.productos = new ArrayList<>();
	}

	public List<Producto> getProductos() {
		return new ArrayList<>(this.productos);
	}

	public void agregarProducto(Producto producto) {
		this.productos.add(producto);
	}

	public List<Producto> buscarProducto(String nombre) {
		return this.productos.stream().filter(p -> p.nombreEsIgualA(nombre)).collect(Collectors.toList());
	}

}
