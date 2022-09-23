package ar.edu.unlp.info.oo1.ejercicio18_LiquidacionDeHaberes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Liquidadora {

	private List<Empleado> empleados;

	public Liquidadora() {
		this.empleados = new ArrayList<>();
	}

	public Empleado registrarEmpleado(String nombre, String apellido, String cuil, LocalDate fechaNacimiento,
			boolean tieneConyuge, boolean tieneHijos) {
		Empleado empleado = new Empleado(nombre, apellido, cuil, fechaNacimiento, tieneConyuge, tieneHijos,
				LocalDate.now());
		this.empleados.add(empleado);
		return empleado;
	}

	public Empleado buscarEmpleado(String cuil) {
		return this.empleados.stream().filter(e -> e.cuilEsIgualA(cuil)).findAny().orElse(null);
	}

	public void eliminarEmpleado(Empleado empleado) {
		this.empleados.remove(empleado);
	}

	public Contrato cargarContratoPorHoras(Empleado empleado, LocalDate fechaInicio, LocalDate fechaFin,
			double valorHora, int horas) {
		Contrato contrato = new ContratoPorHoras(fechaInicio, fechaFin, valorHora, horas);
		empleado.agregarContrato(contrato);
		return contrato ;
	}

	public Contrato cargarContratoDePlanta(Empleado empleado, LocalDate fechaInicio, double sueldo, double montoConyuge,
			double montoHijos) {
		Contrato contrato = new ContratoDePlanta(fechaInicio, sueldo, montoConyuge, montoHijos);
		empleado.agregarContrato(contrato);
		return contrato;
	}

	public List<Empleado> obtenerEmpleadosContratosVencidos() {
		return this.empleados.stream().filter(e -> e.tieneContrato()).filter(e -> e.contratoActualVencido()).collect(Collectors.toList());
	}

	public List<ReciboDeSueldo> generarRecibos() {
		return this.empleados.stream().filter(e -> !e.contratoActualVencido()).map(e -> e.generarRecibo()).collect(Collectors.toList());
	}

	public List<Empleado> getEmpleados() {
		return new ArrayList<>(this.empleados);
	}

}
