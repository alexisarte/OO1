package ar.edu.unlp.info.oo1.ejercicio18_LiquidacionDeHaberes;

import java.time.LocalDate;

public abstract class Contrato implements Comparable<Contrato> {

	private LocalDate fechaInicio;

	public Contrato(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public abstract double montoACobrar();

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	
	@Override
	public int compareTo(Contrato o) {
		return o.getFechaInicio().compareTo(this.getFechaInicio());
	}

	protected abstract boolean estaVencido();

}
