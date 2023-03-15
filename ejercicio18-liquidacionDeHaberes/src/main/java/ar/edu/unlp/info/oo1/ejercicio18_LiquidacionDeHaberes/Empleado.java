package ar.edu.unlp.info.oo1.ejercicio18_LiquidacionDeHaberes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Empleado {

	private String nombre;
	private String apellido;
	private String cuil;
	private LocalDate fechaNacimiento;
	private boolean tieneConyuge;
	private boolean tieneHijos;
	private LocalDate fechaInicio;
	private List<Contrato> contratos;

	public Empleado(String nombre, String apellido, String cuil, LocalDate fechaNacimiento, boolean tieneConyuge,
			boolean tieneHijos, LocalDate fechaInicio) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cuil = cuil;
		this.fechaNacimiento = fechaNacimiento;
		this.tieneConyuge = tieneConyuge;
		this.tieneHijos = tieneHijos;
		this.fechaInicio = fechaInicio;
		this.contratos = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getCuil() {
		return cuil;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public boolean isTieneConyuge() {
		return tieneConyuge;
	}

	public boolean isTieneHijos() {
		return tieneHijos;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public List<Contrato> getContratos() {
		return new ArrayList<>(this.contratos);
	}

	public boolean cuilEsIgualA(String cuil) {
		return this.cuil.equals(cuil);
	}

	public void agregarContrato(Contrato contrato) {
		this.contratos.add(contrato);
	}

	public Contrato obtenerContratoActual() {
		return this.contratos.stream().reduce((c1, c2) -> c2).orElse(null);
	}

	public boolean tieneContrato() {
		return !this.contratos.isEmpty();
	}

	public boolean contratoActualVencido() {
		return this.tieneContrato() && this.obtenerContratoActual().estaVencido();
	}

	private long antiguedad() {
		return ChronoUnit.YEARS.between(fechaInicio, LocalDate.now());
	}
	
	private double montoBasico() {
		return this.obtenerContratoActual().montoBasico();
	}

	public double porcentajeBasico() {
		return (this.antiguedad() == 5) ? 0.3 * this.montoBasico()
				: (this.antiguedad() == 10) ? 0.5 * this.montoBasico()
						: (this.antiguedad() == 15) ? 0.7 * this.montoBasico()
								: (this.antiguedad() == 20) ? this.montoBasico() : 1;
	}

	public ReciboDeSueldo generarRecibo() {
		ReciboDeSueldo recibo = new ReciboDeSueldo(this, ChronoUnit.YEARS.between(fechaInicio, LocalDate.now()),
				LocalDate.now(), this.porcentajeBasico() * this.montoBasico());
		return recibo;
	}

}
