package ar.edu.unlp.info.oo1.ejercicio15;

import java.util.ArrayList;
import java.util.List;

public class ServicioDeUsuarios {
	
	private List<Usuario> usuarios;

	public ServicioDeUsuarios() {
		this.usuarios = new ArrayList<>();
	}

	public Usuario registrarUsuario(String nombre, String direccion, int dni) {
		Usuario usuario = new Usuario(nombre, direccion, dni);
		this.usuarios.add(usuario);
		return usuario;
	}
	
}
