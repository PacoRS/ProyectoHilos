package AccesoAtomico;

import java.util.ArrayList;
import java.util.Collection;

import com.francisco.ProyectoHilos.PrimaryController;

import javafx.collections.ObservableList;
import javafx.scene.text.Text;

public class Cuenta {
	private float numEntrdas;
	CopiaNumEntradas c = CopiaNumEntradas.getInstance();
	PrimaryController pr = new PrimaryController();

	String blanco = "";
	String saldoIni = "";
	String quiReti = "";
	String cero = "";
	String insu = "";
	String retirado = "";

	public Cuenta(float saldo) {
		this.numEntrdas = saldo;
	}

	public Cuenta(float numEntrdas, CopiaNumEntradas c, PrimaryController pr, Collection<String> ob) {
		super();
		this.numEntrdas = numEntrdas;
		this.c = c;
		this.pr = pr;

	}

	public Cuenta(float numEntrdas, Collection<String> ob) {
		super();
		this.numEntrdas = numEntrdas;

	}

	public float getnumEntrdas() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return numEntrdas;
	}

	public String getBlanco() {
		return blanco;
	}

	public void setBlanco(String blanco) {
		this.blanco = blanco;
	}

	public String getSaldoIni() {
		return saldoIni;
	}

	public void setSaldoIni(String saldoIni) {
		this.saldoIni = saldoIni;
	}

	public String getQuiReti() {
		return quiReti;
	}

	public void setQuiReti(String quiReti) {
		this.quiReti = quiReti;
	}

	public String getCero() {
		return cero;
	}

	public void setCero(String cero) {
		this.cero = cero;
	}

	public String getInsu() {
		return insu;
	}

	public void setInsu(String insu) {
		this.insu = insu;
	}

	public String getRetirado() {
		return retirado;
	}

	public void setRetirado(String retirado) {
		this.retirado = retirado;
	}

	synchronized public void compraEntradas(float cantidad, String nombre) {
		System.out.println("");
		System.out.println("Numero de Entradas -> " + this.getnumEntrdas());
		System.out.println(nombre + " quiere comprar " + cantidad +" Entradas");
		if (this.numEntrdas <= 0) {
			System.out.println("Entradas a 0, no ha podido realizarse la operacion");

		} else {
			if (this.numEntrdas < cantidad) {
				System.out.println("Entradas INSUFICIENTEs, no ha podido realizarse la operacion");

			} else {
				this.numEntrdas -= cantidad;
				System.out.println(nombre + " ha comprado " + cantidad);

			}
		}
	}

}
