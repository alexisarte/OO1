package ar.edu.unlp.info.oo1.ejercicio16;

import java.time.LocalDate;

public class PoliticaEstricta implements IPoliticaCancelacion {

	@Override
	public double reembolsar(Reserva reserva, LocalDate fecha) {
		return 0;
	}

}
