package ar.edu.unlp.info.oo1.ejercicio13;

public class Archivo {
	
	private String nombre;

	public Archivo(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double tamanio() {
		return this.getNombre().length();
	}
	
}
