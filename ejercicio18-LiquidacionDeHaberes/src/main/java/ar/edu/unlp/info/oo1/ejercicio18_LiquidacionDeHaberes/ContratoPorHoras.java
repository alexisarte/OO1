package ar.edu.unlp.info.oo1.ejercicio18_LiquidacionDeHaberes;

import java.time.LocalDate;

public class ContratoPorHoras extends Contrato {

	private LocalDate fechaFin;
	private double valorHora;
	private int horas;
	
	public ContratoPorHoras(LocalDate fechaInicio, LocalDate fechaFin, double valorHora, int horas) {
		super(fechaInicio);
		this.fechaFin = fechaFin;
		this.valorHora = valorHora;
		this.horas = horas;
	}

	public double montoACobrar() {
		return 0;
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

	@Override
	protected boolean estaVencido() {
		if (this.getFechaFin().compareTo(LocalDate.now()) > 0) {
			return false;
		} 
		return true;
	}
	
}
