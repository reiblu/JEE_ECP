package controllersEjb;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.entities.Tema;
import controllers.AnadirTema;

public class AnadirTemaEjb implements AnadirTema {

	@Override
	public void nuevoTema(String nombre, String pregunta) {
		TemaDao tema = DaoFactory.getFactory().getTemaDao();
		Tema t1 = new Tema(pregunta, nombre);
		tema.create(t1);
		
	}

}
