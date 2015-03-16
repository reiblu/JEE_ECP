package controllersEjb;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.daos.VotoDao;
import models.entities.Tema;
import models.utils.Estudios;
import controllers.VerVotos;

public class VerVotosEjb implements VerVotos {

	@Override
	public Tema getTema(int idTema) {
		TemaDao temaDao = DaoFactory.getFactory().getTemaDao();
		Tema tema = temaDao.read(idTema);
		return tema;
	}

	@Override
	public long getNumVotos(int idTema) {
		VotoDao votodao = DaoFactory.getFactory().getVotoDao();
		return votodao.getNumVotos(idTema);
	}

    @Override
    public double getValoracionMedia(int idTema, Estudios estudios) {
        VotoDao votodao = DaoFactory.getFactory().getVotoDao();
        return votodao.getValoracionMedia(idTema, estudios);
    }

	

}
