package ar.edu.unlp.info.oo1.ejercicio19;

public class RetirarEnSucursal extends MecanismoDeEnvio {

	public RetirarEnSucursal(Vendedor vendedor, Cliente cliente) {
		super(vendedor, cliente);
	}

	@Override
	public double costo() {
		return 50;
	}
	
}
