package Cooperantes;

import java.util.List;

import com.francisco.ProyectoHilos.PrimaryController;

public class Hilo implements Runnable{
	private int numHilo;
	private int miParte; //la cantidad que tiene que contar este hilo
	private int miCuenta=0;
	private String mensaje;
//	private List<String>ms;
	PrimaryController pr=new PrimaryController();
	
	private final Contador cont;

	
	public int getMiCuenta() {
		return miCuenta;
	}

	public Hilo(int numHilo, int miParte, Contador c) {
		this.numHilo = numHilo;
		this.miParte = miParte;
		this.cont = c;
		this.mensaje="";
	}
	
	

	public Hilo() {
		this.cont = null;
	}

	public int getNumHilo() {
		return numHilo;
	}

	public void setNumHilo(int numHilo) {
		this.numHilo = numHilo;
	}

	public int getMiParte() {
		return miParte;
	}

	public void setMiParte(int miParte) {
		this.miParte = miParte;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Contador getCont() {
		return cont;
	}

	public void setMiCuenta(int miCuenta) {
		this.miCuenta = miCuenta;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<miParte; i++) {
			synchronized (cont) {
				this.cont.incrementa();

			}
			
			miCuenta++;
			String mensaje1=("Camarero "+numHilo+" a contado: "+miCuenta+" Euros");
			mensaje=mensaje1;	
			System.out.println(mensaje);
			
		}
		pr.caja11.add(this);
		
	}
	
	
	
	

}
