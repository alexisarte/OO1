package ar.edu.unlp.info.oo1.ejercicio9;

public class CajaDeAhorro extends Cuenta {
	
	public double impuesto(double monto) {
		return monto * 0.02;
	}
	
	public void aplicarImpuesto(double monto) {
		this.extraerSinControlar(this.impuesto(monto));
	}
	
	@Override
	protected boolean puedeExtraer(double monto) {
		return this.getSaldo() >= (monto + this.impuesto(monto));
	}

	@Override
	public void depositar(double monto) {
		super.depositar(monto);
		this.aplicarImpuesto(monto);
	}
	
	@Override
	public boolean extraer(double monto) {
		if (super.extraer(monto)) {
			this.aplicarImpuesto(monto);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean transferirACuenta(double monto, Cuenta cuentaDestino) {
		if (super.transferirACuenta(monto, cuentaDestino)) {
			this.aplicarImpuesto(monto);
			return true;
		}
		return false;
	}
	
}
