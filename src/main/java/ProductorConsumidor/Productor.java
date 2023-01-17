package ProductorConsumidor;

import com.francisco.ProyectoHilos.PrimaryController;

import Model.Persona;

public class Productor extends Thread {

	private Buffer buffer;
	private final String letras = "abcdefghijklmnopqrstuvxyz";
	int nu=0;
	PrimaryController pp;

	public Productor(Buffer b) {
		this.buffer = b;
	}

	public void run() {
		while (true) {
			try {
				Persona[] buffer2=cogePerona();
				Persona c = buffer2[nu];
				buffer.producir(c);
				String ac=("Entra la persona " + c.getNombre() + " en la discoteca");
				System.out.println(ac);
				c.setAccionEntrada(ac);
				pp.personas.add(c);
				nu++;
			} catch (ArrayIndexOutOfBoundsException e) {
				
			}
				
				
			
		}
	}

	public Persona[] cogePerona() {
		 Persona[] buffer1=new Persona[2];
		 buffer1[0]=new Persona(1,"Paco");
		 buffer1[1]=new Persona(2, "letras");
		return buffer1;
	}
}
