package ar.edu.unlp.info.oo1.ejercicio18_LiquidacionDeHaberes;

import java.time.LocalDate;

public class ContratoDePlanta extends Contrato {

	private double sueldo;
	private double montoConyuge;
	private double montoHijos;
	
	public ContratoDePlanta(LocalDate fechaInicio, double sueldo, double montoConyuge, double montoHijos) {
		super(fechaInicio);
		this.sueldo = sueldo;
		this.montoConyuge = montoConyuge;
		this.montoHijos = montoHijos;
	}

	public double montoACobrar() {
		return 0;
	}

	@Override
	protected boolean estaVencido() {
		return false;
	}
	
}
