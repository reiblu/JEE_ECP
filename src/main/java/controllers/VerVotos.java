package controllers;

import models.entities.Tema;

public interface VerVotos {

	Tema getTema(int idTema);

	long getNumVotos(int idTema);

	int getValoracionMedia(int idTema);

}
