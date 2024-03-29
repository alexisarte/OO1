package ar.edu.unlp.info.oo1.ejercicio18_LiquidacionDeHaberes;

import java.time.LocalDate;

public class ContratoPorHoras extends Contrato {

	private LocalDate fechaFin;
	private double valorHora;
	private int horas;
	
	public ContratoPorHoras(Empleado empleado, LocalDate fechaInicio, LocalDate fechaFin, double valorHora, int horas) {
		super(empleado, fechaInicio);
		this.fechaFin = fechaFin;
		this.valorHora = valorHora;
		this.horas = horas;
	}

	public double montoBasico() {
		return this.getValorHora() * this.getHoras();
	}
	
	@Override
	protected boolean estaVencido() {
		if (this.getFechaFin().compareTo(LocalDate.now()) > 0) {
			return false;
		} 
		return true;
	}
	
	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public double getValorHora() {
		return valorHora;
	}

	public int getHoras() {
		return horas;
	}
	
}
