package Cooperantes;

import java.util.List;

public class Contador {
	private int cuenta=0;
	
	public int getCuenta() {
		return cuenta;
	}
	public int incrementa() {
		this.cuenta++;
		return this.cuenta;
	}

}
