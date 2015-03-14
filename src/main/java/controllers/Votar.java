package controllers;

import java.util.List;

import models.entities.Tema;
import models.utils.Estudios;

public interface Votar {

	public List<Tema> getTemas();

	public Tema getTema(int idTema);

	public void votar(Estudios estudios, String ipUsuario, int valoracion,
			Tema tema);

}
