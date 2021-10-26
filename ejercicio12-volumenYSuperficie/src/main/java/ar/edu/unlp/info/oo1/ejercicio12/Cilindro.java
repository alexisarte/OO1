package ar.edu.unlp.info.oo1.ejercicio12;

public class Cilindro extends Pieza {

	private int radio;
	private int altura;

	public Cilindro(String material, String color, int radio, int altura) {
		super(material, color);
		this.radio = radio;
		this.altura = altura;
	}

	@Override
	public double volumen() {
		return Math.PI * Math.pow(this.getRadio(), 2) * this.getAltura();
	}

	@Override
	public double superficie() {
		return (2 * Math.PI * this.getRadio() * this.getAltura()) + (2 * Math.PI * Math.pow(this.getRadio(), 2));
	}

	public int getRadio() {
		return radio;
	}

	public int getAltura() {
		return altura;
	}

}
