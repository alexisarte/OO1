package ar.edu.unlp.info.oo1.ejercicio16;

import java.time.LocalDate;

public class Reserva {
	
	private Propiedad propiedad;
	private DateLapse periodo;
	
	public Reserva(Propiedad propiedad, DateLapse periodo) {
		this.propiedad = propiedad;
		this.periodo = periodo;
	}
	
	public boolean overlaps(DateLapse periodo) {
		return this.periodo.overlaps(periodo);
	}
	
	public boolean incluye(DateLapse periodo) {
		return this.periodo.includesDate(periodo.getFrom()) && this.periodo.includesDate(periodo.getTo());
	}
	
	public long cantidadNoches() {
		return this.periodo.sizeInDays();
	}

	public double precio() {
		return this.periodo.sizeInDays() * this.propiedad.getPrecioNoche();
	}
	
	public LocalDate fechaInicio() {
		return periodo.getFrom();
	}

	public void eliminarse() {
		this.propiedad.eliminarReserva(this);
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}
	
	public DateLapse getPeriodo() {
		return periodo;
	}

	public double cancelarse(Reserva reserva, LocalDate fecha) {
		return this.propiedad.cancelarReserva(reserva, fecha);
	}
	
}
