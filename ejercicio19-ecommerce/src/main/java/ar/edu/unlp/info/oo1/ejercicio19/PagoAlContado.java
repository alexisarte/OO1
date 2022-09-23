package ar.edu.unlp.info.oo1.ejercicio19;

public class PagoAlContado extends FormaDePago {

	public PagoAlContado(Producto producto) {
		super(producto);
	}

	@Override
	public double precioFinal() {
		return this.getProducto().getPrecio();
	}
	
}
