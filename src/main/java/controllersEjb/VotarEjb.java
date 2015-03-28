package controllersEjb;

import java.util.List;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.daos.VotoDao;
import models.entities.Tema;
import models.entities.Voto;
import models.utils.Estudios;
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

	@Override
	public void votar(Estudios estudios, String ipUsuario, int valoracion,
			Tema tema) {
		VotoDao voto = DaoFactory.getFactory().getVotoDao();
		Voto v1 = new Voto(estudios, ipUsuario, valoracion, tema);
		voto.create(v1);

	}

}
