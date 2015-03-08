package models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tema {

	public static final String TABLA = "tema";

	public static final String ID = "ID";

	@Id
	@GeneratedValue
	private Integer id;

	public static final String PREGUNTA = "PREGUNTA";

	private String pregunta;

	public static final String NOMBRE = "NOMBRE";

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
		assert obj != null;
		Tema other = (Tema) obj;
		return id.equals(other.id) && nombre.equals(other.nombre)
				&& pregunta.equals(other.pregunta);
	}

	@Override
	public String toString() {
		return "Tema [" + "nombre=" + nombre + "pregunta=" + pregunta + "]";
	}

}
