package ar.edu.unlp.info.oo1.ejercicio2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Ticket {

	private LocalDate fecha;
	private List<Producto> productos;

	public Ticket(List<Producto> productos) {
		this.fecha = LocalDate.now();
		this.productos = new ArrayList<>(productos);
	}

	public double impuesto() {
		return ((this.getPrecioTotal() * 21) / 100);
	}
	
	
	/** Getters */
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public List<Producto> getProductos() {
		return productos;
	}
	
	public int getCantidadDeProductos() {
		return this.productos.size();
	}
	
	public double getPrecioTotal() {
		return this.productos.stream().mapToDouble(Producto::getPrecio).sum();
	}

	public double getPesoTotal() {
		return this.productos.stream().mapToDouble(Producto::getPeso).sum();
	}
	
}