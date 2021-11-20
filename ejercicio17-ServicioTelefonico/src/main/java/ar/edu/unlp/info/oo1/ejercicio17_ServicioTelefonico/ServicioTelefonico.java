package ar.edu.unlp.info.oo1.ejercicio17_ServicioTelefonico;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ServicioTelefonico {

	private List<Cliente> clientes;
	private List<String> numerosTelefonicos;

	public ServicioTelefonico() {
		this.clientes = new ArrayList<>();
		this.numerosTelefonicos = new ArrayList<>();
	}

	public void agregarNumero(String numero) {
		this.numerosTelefonicos.add(numero);
	}
	
	public Cliente registrarPersonaFisica(String nombre, String direccion, Integer dni) {
		var numeroTelefonico = this.numerosTelefonicos.get(0);
		this.numerosTelefonicos.remove(numeroTelefonico);
		Cliente cliente = new PersonaFisica(nombre, direccion, numeroTelefonico, dni);
		this.clientes.add(cliente);
		return cliente;
	}

	public Cliente registrarPersonaJuridica(String nombre, String direccion, String cuit, String tipo) {
		var numeroTelefonico = this.numerosTelefonicos.get(0);
		this.numerosTelefonicos.remove(numeroTelefonico);
		Cliente cliente = new PersonaJuridica(nombre, direccion, numeroTelefonico, cuit, tipo);
		this.clientes.add(cliente);
		return cliente;
	}

	private Cliente buscarCliente(String numeroEmisor) {
		return this.clientes.stream().filter(c -> c.getNumeroTelefonico().equals(numeroEmisor)).findFirst().get();
	}

	private Llamada buscarYAgregar(String numeroEmisor, Llamada llamada) {
		var cliente = this.buscarCliente(numeroEmisor);
		cliente.agregarLlamada(llamada);
		return llamada;
	}

	public Llamada registrarLlamadaLocal(LocalDateTime fechaYHora, double duracion, String numeroEmisor,
			String numeroReceptor) {
		return this.buscarYAgregar(numeroEmisor, new LlamadaLocal(fechaYHora, duracion, numeroEmisor, numeroReceptor));
	}

	public Llamada registrarLlamadaInterurbana(LocalDateTime fechaYHora, double duracion, String numeroEmisor,
			String numeroReceptor, double distancia) {
		return this.buscarYAgregar(numeroEmisor,
				new LlamadaInterurbana(fechaYHora, duracion, numeroEmisor, numeroReceptor, distancia));
	}

	public Llamada registrarLlamadaInternacional(LocalDateTime fechaYHora, double duracion, String numeroEmisor,
			String numeroReceptor, String paisOrigen, String paisDestino) {
		return this.buscarYAgregar(numeroEmisor,
				new LlamadaInternacional(fechaYHora, duracion, numeroEmisor, numeroReceptor, paisOrigen, paisDestino));
	}

	public Factura facturarLlamadas(Cliente cliente, LocalDateTime inicioPeriodo, LocalDateTime finPeriodo) {
		var montoTotal = cliente.montoTotal(inicioPeriodo, finPeriodo);
		return new Factura(cliente, inicioPeriodo, finPeriodo, montoTotal);
	}

	public List<Cliente> getClientes() {
		return new ArrayList<>(this.clientes);
	}

	public List<String> getNumerosTelefonicos() {
		return new ArrayList<>(this.numerosTelefonicos);
	}

}
