package ar.edu.unlp.info.oo1.ejercicio17_ServicioTelefonico;

import java.time.LocalDateTime;

public class LlamadaLocal extends Llamada {

	public LlamadaLocal(LocalDateTime fechaYHora, double duracion, String numeroEmisor, String numeroReceptor) {
		super(fechaYHora, duracion, numeroEmisor, numeroReceptor);
	}

	@Override
	public double costo() {
		return this.getDuracion();
	}

}
