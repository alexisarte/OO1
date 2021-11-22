package ar.edu.unlp.info.oo1.ejercicio19;

public abstract class MecanismoDeEnvio {
	
	private Vendedor vendedor;
	private Cliente cliente;
	private Mapa mapa;
	
	public MecanismoDeEnvio(Vendedor vendedor, Cliente cliente) {
		this.vendedor = vendedor;
		this.cliente = cliente;
	}

	public abstract double costo();

	public Mapa getMapa() {
		return mapa;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
}
