package ar.edu.unlp.info.oo1.ejercicio17_ServicioTelefonico;

public class PersonaJuridica extends Cliente {
	
	private String cuit;
	private String tipo;
	
	public PersonaJuridica(String nombre, String direccion, String numeroTelefonico, String cuit, String tipo) {
		super(nombre, direccion, numeroTelefonico);
		this.cuit = cuit;
		this.tipo = tipo;
	}

	public String getCuit() {
		return cuit;
	}

	public String getTipo() {
		return tipo;
	}
	
}
