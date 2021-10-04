package ar.edu.unlp.info.oo1.ejercicio4;

public class Cuerpo3D {

	private double altura;
	private Figura caraBasal;

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public Figura getCaraBasal() {
		return caraBasal;
	}
	
	public void setCaraBasal(Figura caraBasal) {
		this.caraBasal = caraBasal;
	}

	public double getVolumen() {
		return this.getCaraBasal().getArea() * this.getAltura();
	}

	public double getSuperficieExterior() {
		return (2 * this.getCaraBasal().getArea()) + (this.getCaraBasal().getPerimetro() * this.getAltura());
	}

}
