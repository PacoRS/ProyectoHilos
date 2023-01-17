package AccesoAtomico;

import javafx.collections.ObservableList;

public class CompraEntradas extends Thread {
	private Cuenta c;
	String nombre;
	float cantidad;
	public CompraEntradas(Cuenta c, String nombre, float cantidad) {
		this.c = c;
		this.nombre = nombre;
		this.cantidad = cantidad;
	}
	public void run() {
		
		c.compraEntradas(cantidad, nombre);
		
		
	}

}
