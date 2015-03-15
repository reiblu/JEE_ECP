package models.daos;

import models.entities.Voto;

public interface VotoDao extends GenericDao<Voto,Integer> {

	public void BorrarVotosdeTema(int idTema);

	public int getNumVotos(int idTema);

	public int getValorMedia(int idTema);
	
}
