package ar.edu.unlp.info.oo1.ejercicio17_ServicioTelefonico;

import java.time.LocalDateTime;

public class Factura {
	
	private Cliente cliente;
	private LocalDateTime fecha;
	private LocalDateTime periodoInicio;
	private LocalDateTime periodoFin;
	private double montoTotal;
	
	public Factura(Cliente cliente, LocalDateTime periodoInicio, LocalDateTime periodoFin, double montoTotal) {
		this.cliente = cliente;
		this.fecha = LocalDateTime.now();
		this.periodoInicio = periodoInicio;
		this.periodoFin = periodoFin;
		this.montoTotal = montoTotal;
	}
	
	public LocalDateTime getFecha() {
		return fecha;
	}
	
	public LocalDateTime getPeriodoInicio() {
		return periodoInicio;
	}

	public LocalDateTime getPeriodoFin() {
		return periodoFin;
	}

	public double getMontoTotal() {
		return montoTotal;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
}
