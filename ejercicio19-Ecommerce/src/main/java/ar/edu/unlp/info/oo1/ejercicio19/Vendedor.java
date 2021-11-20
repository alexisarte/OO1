package ar.edu.unlp.info.oo1.ejercicio19;

import java.util.ArrayList;
import java.util.List;

public class Vendedor {
	
	private List<Producto> productos;

	public List<Producto> getProductos() {
		return new ArrayList<>(this.productos);
	}
	
	
}
