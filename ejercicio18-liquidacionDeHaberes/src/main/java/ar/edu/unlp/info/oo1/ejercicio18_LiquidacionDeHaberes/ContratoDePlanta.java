package ar.edu.unlp.info.oo1.ejercicio18_LiquidacionDeHaberes;

import java.time.LocalDate;

public class ContratoDePlanta extends Contrato {

	private double sueldo;
	private double montoConyuge;
	private double montoHijos;
	
	public ContratoDePlanta(Empleado empleado, LocalDate fechaInicio, double sueldo, double montoConyuge, double montoHijos) {
		super(empleado, fechaInicio);
		this.sueldo = sueldo;
		this.montoConyuge = montoConyuge;
		this.montoHijos = montoHijos;
	}

	@Override
	public double montoBasico() {
		double monto = this.getSueldo();
		if (this.getEmpleado().isTieneConyuge()) {
			monto += this.getMontoConyuge();
		}
		if (this.getEmpleado().isTieneHijos()) {
			monto += this.getMontoHijos();
		}
		return monto;
	}
	
	@Override
	protected boolean estaVencido() {
		return false;
	}

	public double getSueldo() {
		return sueldo;
	}

	public double getMontoConyuge() {
		return montoConyuge;
	}

	public double getMontoHijos() {
		return montoHijos;
	}
	
}
