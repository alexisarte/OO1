package ar.edu.unlp.info.oo1.ejercicio19;

public class Usuario {

	private String nombre;
	private String direccion;
	
	public Usuario(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
	}
	
	public boolean nombreEsIgualA(String nombre) {
		return this.getNombre().equals(nombre);
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}
	
}
