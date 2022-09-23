package ar.edu.unlp.info.oo1.ejercicio17_ServicioTelefonico;

import java.time.LocalDateTime;

public class PersonaFisica extends Cliente {
	
	private int dni;

	public PersonaFisica(String nombre, String direccion, String numeroTelefonico, int dni) {
		super(nombre, direccion, numeroTelefonico);
		this.dni = dni;
	}
	
	@Override
	public double montoTotal(LocalDateTime inicioPeriodo, LocalDateTime finPeriodo) {
		var montoTotal = super.montoTotal(inicioPeriodo, finPeriodo);
		return montoTotal - (montoTotal * 0.1);
	}

	public int getDni() {
		return dni;
	}
	
}
