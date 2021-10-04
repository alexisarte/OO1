package ar.edu.unlp.info.oo1.ejercicio4;

public class Circulo implements Figura {

	private double valor;

	public double getDiametro() {
		return this.getRadio() * 2;
	}

	public void setDiametro(double valor) {
		this.setRadio(valor / 2);
	}

	public double getRadio() {
		return this.valor;
	}

	public void setRadio(double valor) {
		this.valor = valor;
	}

	public double getPerimetro() {
		return Math.PI * getDiametro();
	}

	public double getArea() {
		return Math.PI * Math.pow(getRadio(), 2);
	}

}
