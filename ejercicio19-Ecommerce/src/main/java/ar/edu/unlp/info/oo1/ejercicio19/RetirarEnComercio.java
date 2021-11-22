package ar.edu.unlp.info.oo1.ejercicio19;

public class RetirarEnComercio extends MecanismoDeEnvio {

	public RetirarEnComercio(Vendedor vendedor, Cliente cliente) {
		super(vendedor, cliente);
	}

	@Override
	public double costo() {
		return 0;
	}

}
