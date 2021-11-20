package ar.edu.unlp.info.oo1.ejercicio17_ServicioTelefonico;

import java.time.LocalDateTime;

public abstract class Llamada {

	private LocalDateTime fechaYHora;
	private double duracion;
	private String numeroEmisor;
	private String numeroReceptor;

	public Llamada(LocalDateTime fechaYHora, double duracion, String numeroEmisor, String numeroReceptor) {
		this.fechaYHora = fechaYHora;
		this.duracion = duracion;
		this.numeroEmisor = numeroEmisor;
		this.numeroReceptor = numeroReceptor;
	}

	public abstract double costo();

	public LocalDateTime getFechaYHora() {
		return fechaYHora;
	}

	public double getDuracion() {
		return duracion;
	}

	public String getNumeroEmisor() {
		return numeroEmisor;
	}

	public String getNumeroReceptor() {
		return numeroReceptor;
	}

	public boolean includesDate(LocalDateTime inicioPeriodo, LocalDateTime finPeriodo) {
		return this.getFechaYHora().isAfter(inicioPeriodo) && this.getFechaYHora().isBefore(finPeriodo)
				|| this.getFechaYHora().equals(inicioPeriodo) || this.getFechaYHora().equals(finPeriodo);
	}

}
