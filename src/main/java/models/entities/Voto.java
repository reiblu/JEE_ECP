package models.entities;

import javax.persistence.CascadeType;
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

	@Id
	@GeneratedValue
	private Integer id;

	private String ipUsuario;

	private int valoracion;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Tema tema;

	@Enumerated(EnumType.STRING)
	private Estudios estudios;

	public Voto() {

	}

	public Voto(Estudios estudios, String ipUsuario, int valoracion, Tema tema) {
		this.estudios = estudios;
		this.ipUsuario = ipUsuario;
		this.tema = tema;
		this.valoracion = valoracion;
	}

	public Estudios getEstudios() {
		return estudios;
	}

	public void setEstudios(Estudios estudio) {
		this.estudios = estudio;
	}

	public String getIp_usuario() {
		return ipUsuario;
	}

	public void setIp_usuario(String ipUsuario) {
		this.ipUsuario = ipUsuario;
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
	public boolean equals(Object obj) {
		assert obj != null;
		Voto other = (Voto) obj;
		return this.id == other.id && estudios.equals(other.estudios)
				&& ipUsuario.equals(other.ipUsuario)
				&& tema.getId().equals(other.tema.getId())
				&& this.valoracion == other.valoracion;
	}

	@Override
	public String toString() {
		return "Voto [ipUsuario=" + ipUsuario + "valoracion=" + valoracion
				+ "id_tema=" + tema.getId() + "estudios=" + estudios + "]";
	}

}
