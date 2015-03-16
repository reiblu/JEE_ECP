package controllers;

import models.entities.Tema;
import models.utils.Estudios;

public interface VerVotos {

	Tema getTema(int idTema);

	long getNumVotos(int idTema);

    double getValoracionMedia(int idTema, Estudios estudios);

}
