package ar.edu.unlp.info.oo1.ejercicio12;

public class Esfera extends Pieza {

	private int radio;

	public Esfera(String material, String color, int radio) {
		super(material, color);
		this.radio = radio;
	}

	@Override
	public double volumen() {
		return ((double) 4/3) * Math.PI * Math.pow(this.getRadio(), 3);
	}

	@Override
	public double superficie() {
		return 4 * Math.PI * Math.pow(this.getRadio(), 2);
	}

	public int getRadio() {
		return radio;
	}

}
