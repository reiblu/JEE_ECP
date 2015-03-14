package controllersEjb;

import java.util.List;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.entities.Tema;
import controllers.Votar;

public class VotarEjb implements Votar {

	@Override
	public List<Tema> getTemas() {
		TemaDao tema = DaoFactory.getFactory().getTemaDao();
		List<Tema> lista = tema.findAll();
		return lista;
	}

	@Override
	public Tema getTema(int idTema) {
		TemaDao temaDao = DaoFactory.getFactory().getTemaDao();
		Tema tema = temaDao.read(idTema);
		return tema;
	}

}
