package controllersEjb;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import controllers.EliminarTema;

public class EliminarTemaEjb implements EliminarTema {

	@Override
	public void eliminar(int idTema) {
		
		TemaDao temaDao = DaoFactory.getFactory().getTemaDao();
		temaDao.deleteByID(idTema);
		
	}

}
