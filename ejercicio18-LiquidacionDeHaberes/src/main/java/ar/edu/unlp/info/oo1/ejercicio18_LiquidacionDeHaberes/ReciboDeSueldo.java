package ar.edu.unlp.info.oo1.ejercicio18_LiquidacionDeHaberes;

import java.time.LocalDate;

public class ReciboDeSueldo {
	
	private Empleado empleado;
	private int antiguedad;
	private LocalDate fecha;
	private double montoTotal;
	
	public ReciboDeSueldo(Empleado empleado, int antiguedad, LocalDate fecha, double montoTotal) {
		this.empleado = empleado;
		this.antiguedad = antiguedad;
		this.fecha = fecha;
		this.montoTotal = montoTotal;
	}
	
	
	
	
}
