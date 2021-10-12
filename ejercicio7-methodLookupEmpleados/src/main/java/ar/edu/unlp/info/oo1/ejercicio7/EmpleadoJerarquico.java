package ar.edu.unlp.info.oo1.ejercicio7;

public class EmpleadoJerarquico extends Empleado{
	
	public EmpleadoJerarquico(String nombre) {
		super(nombre);
	}

	@Override
	public double sueldoBasico() {
		return super.montoBasico() + this.bonoPorCategoria();
	}
	
	@Override
	public double montoBasico() {
		return 45000;
	}
	
	public double bonoPorCategoria() {
		return 8000;
	}
	
}
