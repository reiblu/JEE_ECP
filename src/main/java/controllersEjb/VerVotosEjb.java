package controllersEjb;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.daos.VotoDao;
import models.entities.Tema;
import controllers.VerVotos;

public class VerVotosEjb implements VerVotos {

	@Override
	public Tema getTema(int idTema) {
		TemaDao temaDao = DaoFactory.getFactory().getTemaDao();
		Tema tema = temaDao.read(idTema);
		return tema;
	}

	@Override
	public int getNumVotos(int idTema) {
		VotoDao votodao = DaoFactory.getFactory().getVotoDao();
		return votodao.getNumVotos(idTema);
	}

	@Override
	public int getValoracionMedia(int idTema) {
		VotoDao votodao = DaoFactory.getFactory().getVotoDao();
		return votodao.getValorMedia(idTema);
	}

}
