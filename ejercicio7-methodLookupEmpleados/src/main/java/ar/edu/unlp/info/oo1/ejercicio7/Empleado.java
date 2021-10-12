package ar.edu.unlp.info.oo1.ejercicio7;

public class Empleado {

	private String nombre;

	public Empleado(String nombre) {
		this.nombre = nombre;
	}

	public double aportes() {
		return 13500;
	}

	public double montoBasico() {
		return 35000;
	}

	public double sueldoBasico() {
		return this.montoBasico() + this.aportes();
	}

	public String getNombre() {
		return nombre;
	}

}
