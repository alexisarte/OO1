package ar.edu.unlp.info.oo1.ejercicio13;

import java.util.ArrayList;
import java.util.List;

public class ClienteDeCorreo {

	private List<Carpeta> carpetas;
	private Carpeta inbox;

	public ClienteDeCorreo() {
		this.carpetas = new ArrayList<>();
		this.inbox = new Carpeta("Inbox");
		this.carpetas.add(this.inbox);
	}

	public void agregarCarpeta(Carpeta carpeta) {
		this.carpetas.add(carpeta);
	}

	public void recibir(Email email) {
		this.inbox.agregarEmail(email);
	}

	public void mover(Email email, Carpeta origen, Carpeta destino) {
		origen.eliminarEmail(email);
		destino.agregarEmail(email);
	}

	public Email buscar(String texto) {
		return this.carpetas.stream().map(carpeta -> carpeta.buscar(texto)).filter(email -> email != null).findFirst()
				.orElse(null);
	}

	public double espacioOcupado() {
		return this.carpetas.stream().mapToDouble(Carpeta::espacioOcupado).sum();
	}

}
