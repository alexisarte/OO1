package ar.edu.unlp.info.oo1.ejercicio19;

public abstract class FormaDePago {
	
	private Producto producto;
	
	public FormaDePago(Producto producto) {
		this.producto = producto;
	}

	public abstract double precioFinal();

	public Producto getProducto() {
		return producto;
	}

}
