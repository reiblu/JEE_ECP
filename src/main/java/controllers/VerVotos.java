package controllers;

import models.entities.Tema;

public interface VerVotos {

	Tema getTema(int idTema);

	int getNumVotos(int idTema);

	int getValoracionMedia(int idTema);

}
