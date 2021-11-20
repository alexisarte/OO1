package ar.edu.unlp.info.oo1.ejercicio16;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PoliticaModerada implements IPoliticaCancelacion {

	@Override
	public double reembolsar(Reserva reserva, LocalDate fecha) {
		Long cantidadDias = ChronoUnit.DAYS.between(fecha, reserva.fechaInicio());
		if (cantidadDias >= 7) {
			return reserva.precio();
		} else if (cantidadDias >= 2 && cantidadDias < 7) {
			return reserva.precio() / 2;
		}
		return 0;
	}

}
