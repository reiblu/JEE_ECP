package models.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import models.utils.Estudios;


@Entity
public class Tema {

	public static final String PREGUNTA = "pregunta";
	
	public static final String NOMBRE = "nombre";
	
	@Id
    @GeneratedValue
    private Integer id;
	
	@Enumerated(EnumType.STRING)
	private Estudios estudios;
	
	public Tema(Estudios estudios){
		this.estudios = estudios;
	}
	
	public Tema(){
		
	}
	
	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Estudios getEstudios(){
    	return estudios;
    }
    
    public void setEstudios(Estudios estudio){
    	this.estudios = estudio;
    }
    
    @Override
    public String toString() {
        return "Tema [id=" + id + ", estudios=" + estudios + "]";
    }
	
}
