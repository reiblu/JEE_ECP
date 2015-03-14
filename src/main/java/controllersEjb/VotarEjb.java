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

}
