package ar.edu.unlp.info.oo1.ejercicio20_FarolasConFocos;

public class Foco {

	private String fabricante;
	private int cantidadDeCiclos;
	
	public Foco(String fabricante, int cantidadDeCiclos) {
		this.fabricante = fabricante;
		this.cantidadDeCiclos = cantidadDeCiclos;
	}

	public void descontarCantidadDeCiclos() {
		--this.cantidadDeCiclos;
	}
	
	public boolean estaVencido() {
		return this.cantidadDeCiclos < 1;
	}

	public String getFabricante() {
		return fabricante;
	}
	
}
