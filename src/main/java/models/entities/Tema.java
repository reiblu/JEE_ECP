package models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tema {

	public static final String PREGUNTA = "pregunta";
	
	@Id
    @GeneratedValue
    private Integer id;
	
}
