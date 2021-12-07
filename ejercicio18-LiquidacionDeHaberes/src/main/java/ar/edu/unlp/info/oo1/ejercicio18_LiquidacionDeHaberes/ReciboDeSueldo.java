package ar.edu.unlp.info.oo1.ejercicio18_LiquidacionDeHaberes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ReciboDeSueldo {
	
	private Empleado empleado;
	private long antiguedad;
	private LocalDate fecha;
	private double montoTotal;
	
	public ReciboDeSueldo(Empleado empleado, long antiguedad, LocalDate fecha, double montoTotal) {
		this.empleado = empleado;
		this.antiguedad = antiguedad;
		this.fecha = fecha;
		this.montoTotal = montoTotal;
	}
	
//	public double montoTotal() {
//		var = (this.getAntiguedad() == 5) ? 0.3 * this.obtenerContratoActual().montoBasico() : ;
//		return this.obtenerContratoActual().montoBasico() * ChronoUnit.YEARS.between(fechaInicio, LocalDate.now());
//	}
	
	public Empleado getEmpleado() {
		return empleado;
	}

	public long getAntiguedad() {
		return antiguedad;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public double getMontoTotal() {
		return montoTotal;
	}
	
}
