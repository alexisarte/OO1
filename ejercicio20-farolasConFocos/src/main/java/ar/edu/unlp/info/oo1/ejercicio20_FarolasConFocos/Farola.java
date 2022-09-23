package ar.edu.unlp.info.oo1.ejercicio20_FarolasConFocos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Farola {

	private List<Farola> neighbors;
	private boolean estado;
	private Foco foco;

	/*
	 * Crear una farola que posee un foco fabricado por fabricante con cantidad de
	 * ciclos el valor de cantidadDeCiclos. Debe inicializarla como apagada
	 */
	public Farola(String fabricante, int cantidadDeCiclos) {
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
		otraFarola.addNeighbor(this);
		this.addNeighbor(otraFarola);
	}

	/*
	 * Retorna sus farolas vecinas
	 */
	public List<Farola> getNeighbors() {
		return new ArrayList<>(this.neighbors);
	}

	/*
	 * Si la farola no está encendida, la enciende, contabiliza el ciclo de
	 * encendido y propaga la acción.
	 */

	public void turnOn() {
		if (!this.isOn() && !this.foco.estaVencido()) {
			this.estado = true;
			this.foco.descontarCantidadDeCiclos();
			this.neighbors.stream().forEach(f -> f.turnOn());
		}
	}

	/*
	 * Si la farola no está apagada, la apaga y propaga la acción.
	 */
	public void turnOff() {
		if (this.isOn()) {
			this.estado = false;
			this.neighbors.stream().forEach(f -> f.turnOff());
		}
	}

	/*
	 * Retorna true si la farola está encendida.
	 */
	public boolean isOn() {
		return estado;
	}
	
	/*
	 * Retorna una lista con las farolas que están en la red de la farola receptora
	 * y que poseen focos vencidos. Incluyendo el chequeo entre las farolas vecinas
	 * y las vecinas de estas propagando en toda la red.
	 */
	public List<Farola> farolasConFocosVencidos() {
		List<Farola> farolas = new ArrayList<Farola>();
		if (this.isOn() && this.foco.estaVencido()) {
			this.estado = false;
			farolas = this.neighbors.stream().flatMap(n -> n.farolasConFocosVencidos().stream()).collect(Collectors.toList());
			farolas.add(this);
		}
		return farolas;
	}
	
	public void addNeighbor(Farola otraFarola) {
		this.neighbors.add(otraFarola);
	}

}
