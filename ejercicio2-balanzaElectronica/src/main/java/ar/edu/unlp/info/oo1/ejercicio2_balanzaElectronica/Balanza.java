package ar.edu.unlp.info.oo1.ejercicio2_balanzaElectronica;

import ar.edu.unlp.info.oo1.ejercicio2_balanzaElectronica.Producto;
import ar.edu.unlp.info.oo1.ejercicio2_balanzaElectronica.Ticket;

public class Balanza {
	
	private int cantidadDeProductos = 0;
	private double precioTotal;
	private double pesoTotal;

	public int getCantidadDeProductos() {
		return cantidadDeProductos;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public double getPesoTotal() {
		return pesoTotal;
	}

	public void ponerEnCero() {
		this.cantidadDeProductos = 0;
		this.precioTotal = 0.0;
		this.pesoTotal = 0.0;
	}

	public void agregarProducto(Producto producto) {
		++this.cantidadDeProductos;
		this.precioTotal += producto.getPrecio();
		this.pesoTotal += producto.getPeso();
	}

	public Ticket emitirTicket() {
		Ticket ticket1 = new Ticket();
		ticket1.setCantidadDeProductos(this.cantidadDeProductos);
		ticket1.setPesoTotal(this.pesoTotal);
		ticket1.setPrecioTotal(this.precioTotal);
		return ticket1;
	}

}