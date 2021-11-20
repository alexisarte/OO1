package ar.edu.unlp.info.oo1.ejercicio20_FarolasConFocos;

public class Foco {

	private String marca;
	private int cantidadDeCiclos;
	private boolean vencido;
	
	public Foco(String marca, int cantidadDeCiclos) {
		this.marca = marca;
		this.cantidadDeCiclos = cantidadDeCiclos;
	}

	public int getCantidadDeCiclos() {
		return cantidadDeCiclos;
	}

	public void setCantidadDeCiclos(int cantidadDeCiclos) {
		this.cantidadDeCiclos = cantidadDeCiclos;
	}

	public boolean isVencido() {
		return vencido;
	}

	public void setVencido(boolean vencido) {
		this.vencido = vencido;
	}

	public String getMarca() {
		return marca;
	}
	
}
