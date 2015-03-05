package models.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import models.utils.Estudios;

@Entity
public class Voto {

	public static final String TABLE = "voto";

    private int ip_usuario;

	private int valoracion;

	@ManyToOne
	@JoinColumn
	private Tema tema;

	@Id
	@GeneratedValue
	private Integer id;

	@Enumerated(EnumType.STRING)
	private Estudios estudios;

	public Voto(){
		
	}
	
	public Voto(Estudios estudios, int ip_usuario, int valoracion, Tema tema) {
		this.estudios = estudios;
		this.ip_usuario = ip_usuario;
		this.tema = tema;
		this.valoracion = valoracion;
	}

	public Estudios getEstudios() {
		return estudios;
	}

	public void setEstudios(Estudios estudio) {
		this.estudios = estudio;
	}

	public int getIp_usuario() {
		return ip_usuario;
	}

	public void setIp_usuario(int ip_usuario) {
		this.ip_usuario = ip_usuario;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Voto [id=" + id + "ip_usuario=" + ip_usuario + "valoracion=" + valoracion + "id_tema=" + tema.getId() + "estudios=" + estudios + "]";
	}


}
