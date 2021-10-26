package ar.edu.unlp.info.oo1.ejercicio13;

import java.util.ArrayList;
import java.util.List;

public class Email {

	private List<Archivo> archivos;
	private String titulo;
	private String cuerpo;

	public Email(String titulo, String cuerpo) {
		this.archivos = new ArrayList<>();
		this.titulo = titulo;
		this.cuerpo = cuerpo;
	}
	
	public boolean contiene(String texto) {
		return this.getTitulo().contains(texto) || this.getCuerpo().contains(texto);
	}

	public double espacioOcupado() {
		return this.getTitulo().length() + this.getCuerpo().length()
				+ this.archivos.stream().mapToDouble(Archivo::tamanio).sum();
	}
	
	public void agregarArchivo(Archivo archivo) {
		this.archivos.add(archivo);
	}
	
	public List<Archivo> adjuntos() {
		return new ArrayList<>(this.archivos);
	}

	public String getTitulo() {
		return titulo;
	}

	public String getCuerpo() {
		return cuerpo;
	}

}
