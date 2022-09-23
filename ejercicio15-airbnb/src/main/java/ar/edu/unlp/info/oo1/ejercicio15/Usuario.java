package ar.edu.unlp.info.oo1.ejercicio15;

public class Usuario {

	private String nombre;
	private String direccion;
	private int dni;

	public Usuario(String nombre, String direccion, int dni) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.dni = dni;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public int getDni() {
		return dni;
	}
	
}
