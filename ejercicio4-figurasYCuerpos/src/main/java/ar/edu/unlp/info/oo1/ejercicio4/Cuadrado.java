package ar.edu.unlp.info.oo1.ejercicio4;

public class Cuadrado implements Figura{

	private double valor;

	public double getLado() {
		return valor;
	}

	public void setLado(double valor) {
		this.valor = valor;
	}

	public double getPerimetro() {
		return this.getLado() * 4;
	}

	public double getArea() {
		return Math.pow(getLado(), 2);
	}

}
