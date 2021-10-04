package ar.edu.unlp.info.oo1.ejercicio6;

import java.util.*;

public class Farola {

	private List<Farola> neighbors;
	private boolean estado;

	/*
	 * Crear una farola. Debe inicializarla como apagada
	 */
	public Farola() {
		this.neighbors = new ArrayList<>();
		this.estado = false;
	}

	/*
	 * Crea la relación de vecinos entre las farolas. La relación de vecinos entre
	 * las farolas es recíproca, es decir el receptor del mensaje será vecino de
	 * otraFarola, al igual que otraFarola también se convertirá en vecina del
	 * receptor del mensaje
	 */
	public void pairWithNeighbor(Farola otraFarola) {
		otraFarola.getNeighbors().add(this);
		this.neighbors.add(otraFarola);
	}

	/*
	 * Retorna sus farolas vecinas
	 */
	public List<Farola> getNeighbors() {
		return this.neighbors;
	}

	/*
	 * Si la farola no está encendida, la enciende y propaga la acción.
	 */
	public void turnOn() {
		if (!this.isOn()) {
			this.estado = true;
			this.neighbors.stream().forEach(Farola -> Farola.turnOn());;
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

}
