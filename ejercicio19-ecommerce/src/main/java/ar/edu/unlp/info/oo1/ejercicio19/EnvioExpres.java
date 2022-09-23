package ar.edu.unlp.info.oo1.ejercicio19;

public class EnvioExpres extends MecanismoDeEnvio {

	public EnvioExpres(Vendedor vendedor, Cliente cliente) {
		super(vendedor, cliente);
	}

	@Override
	public double costo() {
		return 0.5 * this.getMapa().distanciaEntre(this.getVendedor().getDireccion(), this.getCliente().getDireccion());
	}
	
}
