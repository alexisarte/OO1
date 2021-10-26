package ar.edu.unlp.info.oo1.ejercicio12;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;

public class ReporteDeConstruccion {

	private List<Pieza> piezas;

	public ReporteDeConstruccion() {
		this.piezas = new ArrayList<>();
	}

	public void agregarPieza(Pieza pieza) {
		this.piezas.add(pieza);
	}

	private double filtrarYSumar(Predicate<Pieza> predicate, ToDoubleFunction<Pieza> mapper) {
		return this.piezas.stream().filter(predicate).mapToDouble(mapper).sum();
	}

	public double volumenDeMaterial(String material) {
		return this.filtrarYSumar(p -> p.getMaterial().equals(material), Pieza::volumen);
	}

	public double superficiDeColor(String color) {
		return this.filtrarYSumar(p -> p.getColor().equals(color), Pieza::superficie);
	}

}
