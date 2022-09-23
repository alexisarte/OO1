package ar.edu.unlp.info.oo1.ejercicio19;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
	
	private List<Pedido> pedidos;
	
	public Cliente(String nombre, String direccion) {
		super(nombre, direccion);
		this.pedidos = new ArrayList<>();
	}

	public void agregarPedido(Pedido pedido) {
		this.pedidos.add(pedido);
	}
	
	public List<Pedido> getPedidos() {
		return new ArrayList<>(this.pedidos);
	}

}
