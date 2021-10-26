package ar.edu.unlp.info.oo1.ejercicio11;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PlazoFijo implements Inversion {

	private LocalDate fechaDeConstitucion;
	private double montoDepositado;
	private double porcentajeDeInteresDiario;
	
	public PlazoFijo(LocalDate fechaDeConstitucion, double montoDepositado, double porcentajeDeInteresDiario) {
		this.fechaDeConstitucion = fechaDeConstitucion;
		this.montoDepositado = montoDepositado;
		this.porcentajeDeInteresDiario = porcentajeDeInteresDiario;
	}

	public double valorActual() {
		long cantidadDias = ChronoUnit.DAYS.between(this.getFechaDeConstitucion(), LocalDate.now());
		return this.getMontoDepositado() + ((this.getMontoDepositado() * this.getPorcentajeDeInteresDiario()) / 100) * cantidadDias;
	}

	public LocalDate getFechaDeConstitucion() {
		return fechaDeConstitucion;
	}

	public double getMontoDepositado() {
		return montoDepositado;
	}

	public double getPorcentajeDeInteresDiario() {
		return porcentajeDeInteresDiario;
	}
	
}
