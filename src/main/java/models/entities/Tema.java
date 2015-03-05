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
	public String toString() {
		return "Tema [id=" + id + "nombre=" + nombre + "pregunta=" + pregunta + "]";
	}

}
