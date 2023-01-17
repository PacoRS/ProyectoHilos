package ProductorConsumidor;

import Model.Persona;

public class Consumidor extends Thread {

	private Buffer buffer;

	public Consumidor(Buffer b) {
		this.buffer = b;
	}

	public void run() {
		while (true) {
				if (buffer.estaVacia != true) {
					Persona c = this.buffer.consumir();
					String fr = ("Sale la persona " + c.getNombre() + " en la discoteca");
					System.out.println(fr);
					c.setAccionSalida(fr);
				}
		}
	}

}