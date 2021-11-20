package ar.edu.unlp.info.oo1.ejercicio17_ServicioTelefonico;

import java.time.LocalDateTime;

public class LlamadaInternacional extends Llamada {

	private String paisOrigen;
	private String paisDestino;

	public LlamadaInternacional(LocalDateTime fechaYHora, double duracion, String numeroEmisor, String numeroReceptor,
			String paisOrigen, String paisDestino) {
		super(fechaYHora, duracion, numeroEmisor, numeroReceptor);
		this.paisOrigen = paisOrigen;
		this.paisDestino = paisDestino;
	}

	@Override
	public double costo() {
		return (this.getFechaYHora().getHour() >= 8 && this.getFechaYHora().getHour() <= 20) ? 4 : 3;
	}

	public String getPaisOrigen() {
		return paisOrigen;
	}

	public String getPaisDestino() {
		return paisDestino;
	}
	
}
