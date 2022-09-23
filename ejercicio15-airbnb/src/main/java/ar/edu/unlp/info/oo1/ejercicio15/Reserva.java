package ar.edu.unlp.info.oo1.ejercicio15;

import java.time.LocalDate;

public class Reserva {
	
	private Propiedad propiedad;
	private DateLapse periodo;
	private Usuario usuario;
	
	public Reserva(Propiedad propiedad, DateLapse periodo, Usuario usuario) {
		this.propiedad = propiedad;
		this.periodo = periodo;
		this.usuario = usuario;
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
	
//	Esta bien que Reserva tenga la propiedad solo para calcular el precio?
	public double precio() {
		return this.cantidadNoches() * this.propiedad.getPrecioNoche();
	}
	
	public LocalDate fechaInicio() {
		return periodo.getFrom();
	}

	public boolean usuarioEsIgualA(Usuario usuario) {
		return this.usuario.equals(usuario);
	}
	
}
