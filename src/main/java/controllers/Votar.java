package controllers;

import java.util.List;

import models.entities.Tema;

public interface Votar {

	public List<Tema> getTemas();

	public Tema getTema(int idTema);

}
