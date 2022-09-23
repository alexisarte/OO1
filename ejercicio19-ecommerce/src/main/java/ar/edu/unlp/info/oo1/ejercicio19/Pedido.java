package ar.edu.unlp.info.oo1.ejercicio19;

public class Pedido {
	
	private Producto producto;
	private Integer cantidadSolicitada;
	private FormaDePago pago;
	private MecanismoDeEnvio envio;
	
	public Pedido(Producto producto, Integer cantidadSolicitada, FormaDePago pago, MecanismoDeEnvio envio) {
		this.producto = producto;
		this.cantidadSolicitada = cantidadSolicitada;
		this.pago = pago;
		this.envio = envio;
	}

	public double costoTotal() {
		return this.pago.precioFinal() + this.envio.costo();
	}

	public Producto getProducto() {
		return producto;
	}

	public Integer getCantidadSolicitada() {
		return cantidadSolicitada;
	}	
	
}
