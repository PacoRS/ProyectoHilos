package ProductorConsumidor;

import com.francisco.ProyectoHilos.PrimaryController;

import Model.Persona;

public class Productor extends Thread {

	private Buffer buffer;
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
				String ac=("Entra " + c.getNombre() + " a la discoteca");
				System.out.println(ac);
				c.setAccionEntrada(ac);
				pp.personas.add(c);
				nu++;
			} catch (ArrayIndexOutOfBoundsException e) {
				
			}
				
				
			
		}
	}

	public Persona[] cogePerona() {
		 Persona[] buffer1=new Persona[5];
		 buffer1[0]=new Persona(1,"Paco");
		 buffer1[1]=new Persona(2,"Ana");
		 buffer1[2]=new Persona(2,"Jose");
		 buffer1[3]=new Persona(2,"Antonio");
		 buffer1[4]=new Persona(2,"Manuel");
		return buffer1;
	}
}
