package ar.edu.unlp.info.oo1.ejercicio17_ServicioTelefonico;

import java.time.LocalDateTime;

public class LlamadaInterurbana extends Llamada {

	private double distancia;

	public LlamadaInterurbana(LocalDateTime fechaYHora, double duracion, String numeroEmisor, String numeroReceptor,
			double distancia) {
		super(fechaYHora, duracion, numeroEmisor, numeroReceptor);
		this.distancia = distancia;
	}

	@Override
	public double costo() {
		return (this.getDistancia() < 100) ? (5 + (this.getDuracion() * 2))
				: (this.getDistancia() >= 100 && this.getDistancia() <= 500) ? (5 + (this.getDuracion() * 2.5))
						: (5 + (this.getDuracion() * 3));
	}

	public double getDistancia() {
		return distancia;
	}

}
