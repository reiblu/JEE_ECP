package models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tema {

    
	public static final String TABLE = "tema";

    @Id
    @GeneratedValue
    private Integer id;

    private String pregunta;

	private String nombre;
	
	public Tema(int id, String pregunta, String nombre) {
		this.id = id;
		this.nombre = nombre;
		this.pregunta = pregunta;
	}
	
	public Tema(String pregunta, String nombre) {
		this.nombre = nombre;
		this.pregunta = pregunta;
	}
	
	public Tema() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tema other = (Tema) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (pregunta == null) {
			if (other.pregunta != null)
				return false;
		} else if (!pregunta.equals(other.pregunta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tema [" + "nombre=" + nombre + "pregunta=" + pregunta + "]";
	}

}
