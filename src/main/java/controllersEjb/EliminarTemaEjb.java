package controllersEjb;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.daos.VotoDao;
import controllers.EliminarTema;

public class EliminarTemaEjb implements EliminarTema {

	@Override
	public void eliminar(int idTema) {

		VotoDao votodao = DaoFactory.getFactory().getVotoDao();
		TemaDao temaDao = DaoFactory.getFactory().getTemaDao();
		votodao.BorrarVotosdeTema(idTema);
		temaDao.deleteByID(idTema);

	}

}
