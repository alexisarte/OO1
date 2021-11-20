package ar.edu.unlp.info.oo1.ejercicio18_LiquidacionDeHaberes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public boolean isTieneConyuge() {
		return tieneConyuge;
	}

	public void setTieneConyuge(boolean tieneConyuge) {
		this.tieneConyuge = tieneConyuge;
	}

	public boolean isTieneHijos() {
		return tieneHijos;
	}

	public void setTieneHijos(boolean tieneHijos) {
		this.tieneHijos = tieneHijos;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public List<Contrato> getContratos() {
		return new ArrayList<>(this.contratos);
	}

	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}

	public boolean cuilEsIgualA(String cuil) {
		return this.cuil.equals(cuil);
	}

	public Contrato cargarContratoPorHoras() {
		return null;
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

	public ReciboDeSueldo generarRecibo() {
		// TODO Auto-generated method stub
		return null;
	}

}
