package ar.edu.unlp.info.oo1.ejercicio19;

public class Producto {

	private String nombre;
	private String descripcion;
	private double precio;
	private int unidades;
	
	public Producto(String nombre, String descripcion, double precio, int unidades) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.unidades = unidades;
	}

	public boolean nombreEsIgualA(String nombre) {
		return this.getNombre().equals(nombre);
	}

	public boolean abastece(Integer cantidadSolicitada) {
		return this.getUnidades() >= cantidadSolicitada;
	}

	public void actualizarUnidades(Integer cantidadSolicitada) {
		this.unidades -= cantidadSolicitada;		
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public int getUnidades() {
		return unidades;
	}
	
}
