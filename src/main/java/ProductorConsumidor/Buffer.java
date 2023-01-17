package ProductorConsumidor;

import Model.Persona;

public class Buffer {

    private Persona[] buffer;
    private int siguiente;
    public boolean estaVacia;
    private boolean estaLlena;
    
    public Buffer(int tamanio){
        this.buffer = new Persona[tamanio];
        this.siguiente = 0;
        this.estaVacia = true;
        this.estaLlena = false;
    }
    
    public synchronized Persona consumir(){
        if(this.estaVacia){	
         
        	  try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
          }
                
           
        
        
        siguiente--;
        this.estaLlena = false;
        if(siguiente == 0){
            this.estaVacia = true;
        }
        
        notifyAll();
        
        return this.buffer[this.siguiente];
    }
    
    public synchronized void producir(Persona c){
        if(this.estaLlena){
            
                try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
          
        }
        
        buffer[siguiente] = c;
        siguiente++;
        this.estaVacia = false;
        if(siguiente == this.buffer.length){
            this.estaLlena = true;
        }
        
        notifyAll();
    }
    
}
