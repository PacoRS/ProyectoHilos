package Model;

import java.util.Objects;

public class Persona {
	public int id;
	public String nombre;
	public String accionEntrada;
	public String accionSalida;

	public Persona() {
		super();
	}

	

	public Persona(int id, String nombre, String accionEntrada, String accionSalida) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.accionEntrada = accionEntrada;
		this.accionSalida = accionSalida;
	}


	public Persona(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.accionEntrada = "";
		this.accionSalida = "";
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAccionEntrada() {
		return accionEntrada;
	}

	public void setAccionEntrada(String accionEntrada) {
		this.accionEntrada = accionEntrada;
	}

	public String getAccionSalida() {
		return accionSalida;
	}

	public void setAccionSalida(String accionSalida) {
		this.accionSalida = accionSalida;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", accionEntrada=" + accionEntrada + ", accionSalida="
				+ accionSalida + "]";
	}


}
