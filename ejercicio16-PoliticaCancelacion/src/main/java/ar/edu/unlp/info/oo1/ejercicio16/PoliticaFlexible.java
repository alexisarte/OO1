package ar.edu.unlp.info.oo1.ejercicio16;

import java.time.LocalDate;

public class PoliticaFlexible implements IPoliticaCancelacion{

	@Override
	public double reembolsar(Reserva reserva, LocalDate fecha) {
		if (fecha.isBefore(reserva.fechaInicio())) {
			reserva.eliminarse();
			return reserva.precio();
		}
		return 0;
	}

}
