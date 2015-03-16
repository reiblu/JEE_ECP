package models.daos;

import models.entities.Voto;
import models.utils.Estudios;

public interface VotoDao extends GenericDao<Voto,Integer> {

	public void BorrarVotosdeTema(int idTema);

	public long getNumVotos(int idTema);

	public double getValoracionMedia(int idTema, Estudios estudios);
	
}
