package ar.edu.unlp.info.oo1.ejercicio3;

import java.time.LocalDate;
import java.util.*;

public class Presupuesto {

	private LocalDate fecha;
	private String cliente;
	private List<Item> items;
	
	public Presupuesto() {
		this.fecha = LocalDate.now();
		this.items = new ArrayList<Item>();
	}
	
	public void agregarItem(Item item) {
		this.items.add(item);
	}

	public double calcularTotal() {
		return this.items.stream().mapToDouble(Item::costo).sum();
	}
	
	public Presupuesto cliente(String cliente) {
		this.cliente = cliente;
		return this;
	}
	
	
	/** Getters */
	
	public LocalDate getFecha() {
		return fecha;
	}

	public String getCliente() {
		return cliente;
	}

}
