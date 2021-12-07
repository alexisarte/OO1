package ar.edu.unlp.info.oo1.ejercicio18_LiquidacionDeHaberes;

import java.time.LocalDate;

public abstract class Contrato implements Comparable<Contrato> {

	private LocalDate fechaInicio;
	private Empleado empleado;
	
	public Contrato(Empleado empleado, LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
		this.empleado = empleado;
	}

	public abstract double montoBasico();

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	
	public Empleado getEmpleado() {
		return empleado;
	}

	@Override
	public int compareTo(Contrato o) {
		return o.getFechaInicio().compareTo(this.getFechaInicio());
	}

	protected abstract boolean estaVencido();

}
