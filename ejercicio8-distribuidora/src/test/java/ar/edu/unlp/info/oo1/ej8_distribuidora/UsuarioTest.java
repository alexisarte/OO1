package ar.edu.unlp.info.oo1.ej8_distribuidora;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioTest {
	
	private Usuario usuario;
	private Consumo consumoEnero;
	private Consumo consumoFebrero;
	private Consumo consumoMarzo;

	private Consumo consumoAbril;

	private Usuario usuarioSinDescuento;
	private Usuario usuarioSinConsumos;
	
	@BeforeEach
	public void setup() {
		this.usuario= new Usuario("Towers", "La Plata");
		
		this.consumoEnero = new Consumo(LocalDate.of(2021, 1, 1) , 100, 300);
		this.consumoFebrero = new Consumo(LocalDate.of(2021, 2, 1) , 800, 100);
		this.consumoMarzo = new Consumo(LocalDate.of(2021, 3, 1) , 800, 100);
		this.consumoAbril = new Consumo(LocalDate.of(2021, 4, 1) , 800, 800);
		
		this.usuario.agregarMedicion(consumoFebrero);
		this.usuario.agregarMedicion(consumoMarzo);
		this.usuario.agregarMedicion(consumoEnero);
		
		this.usuarioSinDescuento = new Usuario("Turing", "Mendoza");
		this.usuarioSinDescuento.agregarMedicion(consumoAbril);
		
		this.usuarioSinConsumos = new Usuario("Pedro", "City Bell");
		
	}

	@Test
	public void testUltimoConsumoActiva() {
		assertEquals(800, this.usuario.ultimoConsumoActiva());
		
	}
	
	@Test
	public void testFacturarEnBaseAUsuarioConDescuento() {
		Factura result = this.usuario.facturarEnBaseA(10);
		assertEquals(8000,result.getMontoEnergiaActiva());
		assertEquals(10, result.getDescuento());
		assertEquals(LocalDate.now(),result.getFecha());
	}
	
	@Test
	public void testFacturarEnBaseAUsuarioSinDescuento() {
		Factura result = this.usuarioSinDescuento.facturarEnBaseA(10);
		assertEquals(8000,result.getMontoEnergiaActiva());
		assertEquals(0, result.getDescuento());
		assertEquals(LocalDate.now(),result.getFecha());
	}
	
	@Test
	public void testFacturarEnBaseAUsuarioSinConsumo() {
		Factura result = this.usuarioSinConsumos.facturarEnBaseA(10);
		assertEquals(0,result.getMontoEnergiaActiva());
		assertEquals(0, result.getDescuento());
		assertEquals(LocalDate.now(),result.getFecha());
	}	
	
	/**
	 * Testea el agregar meidicion verificando que sea el ultimo agregado.
	 *  No tiene mucho mas para testear porque las mediciones son privadas.
	 */
	@Test
	public void testAgregarMedicion() {
		Consumo ultimoConsumo = new Consumo(LocalDate.of(2021, 5, 8), 500, 5000);
		this.usuario.agregarMedicion(ultimoConsumo);
		assertEquals(ultimoConsumo, this.usuario.ultimoConsumo());
	}

}
