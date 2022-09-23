package ar.edu.unlp.info.oo1.ejercicio19;

public class Pago6Cuotas extends FormaDePago {

	public Pago6Cuotas(Producto producto) {
		super(producto);
	}

	@Override
	public double precioFinal() {
		return this.getProducto().getPrecio() + (this.getProducto().getPrecio() * 0.2) ;
	}
	
}
