package ar.edu.unlp.info.oo1.ejercicio5;

import java.time.LocalDate;

public class Mamifero {

	private String identificador;
	private String especie;
	private Mamifero padre;
	private Mamifero madre;
	private LocalDate fechaNacimiento;

	public Mamifero() {

	}

	public Mamifero(String identificador) {
		this.identificador = identificador;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Mamifero getPadre() {
		return padre;
	}

	public void setPadre(Mamifero padre) {
		this.padre = padre;
	}

	public Mamifero getMadre() {
		return madre;
	}

	public void setMadre(Mamifero madre) {
		this.madre = madre;
	}

	public Mamifero getAbueloMaterno() {
		if (this.getMadre() != null) {
			return this.getMadre().getPadre();
		}
		return null;
	}

	public Mamifero getAbuelaMaterna() {
		if (this.getMadre() != null) {
			return this.getMadre().getMadre();
		}
		return null;
	}

	public Mamifero getAbueloPaterno() {
		if (this.getPadre() != null) {
			return this.getPadre().getPadre();
		}
		return null;
	}

	public Mamifero getAbuelaPaterna() {
		if (this.getPadre() != null) {
			return this.getPadre().getMadre();
		}
		return null;
	}

	public boolean esAncestroMaterno(Mamifero unMamifero) {
		if (this.getMadre() != null) {
			return this.getMadre().equals(unMamifero) || getMadre().tieneComoAncestroA(unMamifero);
		}
		return false;
	}

	public boolean esAncestroPaterno(Mamifero unMamifero) {
		if (this.getPadre() != null) {
			return this.getPadre().equals(unMamifero) || getPadre().tieneComoAncestroA(unMamifero);
		}
		return false;
	}

	public boolean tieneComoAncestroA(Mamifero unMamifero) {
		return esAncestroMaterno(unMamifero) || esAncestroPaterno(unMamifero);
	}

}
