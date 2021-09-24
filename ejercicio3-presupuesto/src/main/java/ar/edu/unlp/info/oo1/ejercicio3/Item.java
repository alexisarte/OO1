package ar.edu.unlp.info.oo1.ejercicio3;

public class Item {

	private String detalle;
	private int cantidad;
	private double costoUnitario;

	public double costo() {
		return this.getCantidad() * this.getCostoUnitario();
	}

	public Item detalle(String detalle) {
		this.detalle = detalle;
		return this;
	}

	public Item cantidad(int cantidad) {
		this.cantidad = cantidad;
		return this;
	}

	public Item costoUnitario(double costoUnitario) {
		this.costoUnitario = costoUnitario;
		return this;
	}

	
	/** Getters */

	public String getDetalle() {
		return detalle;
	}

	public int getCantidad() {
		return cantidad;
	}

	public double getCostoUnitario() {
		return costoUnitario;
	}

}
