package ar.edu.unlp.info.oo1.ejercicio17_ServicioTelefonico;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {

	private String nombre;
	private String direccion;
	private String numeroTelefonico;
	private List<Llamada> llamadas;

	public Cliente(String nombre, String direccion, String numeroTelefonico) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.numeroTelefonico = numeroTelefonico;
		this.llamadas = new ArrayList<>();
	}

	public double montoTotal(LocalDateTime inicioPeriodo, LocalDateTime finPeriodo) {
		return this.llamadas.stream().filter(llamada -> llamada.includesDate(inicioPeriodo, finPeriodo))
				.mapToDouble(Llamada::costo).sum();
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getNumeroTelefonico() {
		return numeroTelefonico;
	}

	public List<Llamada> getLlamadas() {
		return new ArrayList<>(this.llamadas);
	}

	public void agregarLlamada(Llamada llamada) {
		this.llamadas.add(llamada);
	}

}
