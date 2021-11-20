package ar.edu.unlp.info.oo1.ejercicio20_FarolasConFocos;

import java.util.*;

public class Farola {

	private List<Farola> neighbors;
	private boolean estado;
	private Foco foco;

	/*
	 * Crear una farola que posee un foco fabricado por fabricante con cantidad de
	 * ciclos el valor de cantidadDeCiclos. Debe inicializarla como apagada
	 */

	public Farola (String fabricante, int cantidadDeCiclos) {
		this.neighbors = new ArrayList<>();
		this.estado = false;
		this.foco = new Foco(fabricante, cantidadDeCiclos);
	}

	/*
	 * Crea la relación de vecinos entre las farolas. La relación de vecinos entre
	 * las farolas es recíproca, es decir el receptor del mensaje será vecino de
	 * otraFarola, al igual que otraFarola también se convertirá en vecina del
	 * receptor del mensaje
	 */
	public void pairWithNeighbor(Farola otraFarola) {
		otraFarola.agregarFarola(this);
		this.agregarFarola(otraFarola);
	}

	/*
	 * Retorna sus farolas vecinas
	 */
	public List<Farola> getNeighbors() {
		return new ArrayList<>(this.neighbors);
	}

	/*
	 * Si la farola no está encendida, la enciende y propaga la acción.
	 */
	public void turnOn() {
		if (!this.isOn()) {
			this.estado = true;
			this.neighbors.stream().forEach(Farola -> Farola.turnOn());
			;
		}
	}

	/*
	 * Si la farola no está apagada, la apaga y propaga la acción.
	 */
	public void turnOff() {
		if (this.isOn()) {
			this.estado = false;
			this.neighbors.stream().forEach(Farola -> Farola.turnOff());
		}
	}

	/*
	 * Retorna true si la farola está encendida.
	 */
	public boolean isOn() {
		return estado;
	}

	public void agregarFarola(Farola otraFarola) {
		this.neighbors.add(otraFarola);
	}

}
