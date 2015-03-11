package models.daos;

import models.entities.Tema;
import models.entities.Voto;

public interface VotoDao extends GenericDao<Voto,Integer> {

	public void BorrarVotosdeTema(Tema tema);
	
}
