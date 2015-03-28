package controllersEjb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import models.daos.jpa.DaoJpaFactory;
import controllers.AnadirTema;
import controllers.ControllerFactory;
import controllers.EliminarTema;
import controllers.VerVotos;
import controllers.Votar;

@ManagedBean(name = "controllerFactory")
@SessionScoped
public class ControllerEjbFactory extends ControllerFactory {

	private AnadirTema anadirTemaController;

	private EliminarTema eliminarTemaController;

	private VerVotos verVotosController;

	private Votar votarController;

	public ControllerEjbFactory() {
		DaoJpaFactory.setFactory(new DaoJpaFactory());
	}

	public AnadirTema getanadirTemaController() {
		if (anadirTemaController == null) {
			anadirTemaController = new AnadirTemaEjb();
		}
		return anadirTemaController;
	}

	@Override
	public EliminarTema getEliminarController() {
		if (eliminarTemaController == null) {
			eliminarTemaController = new EliminarTemaEjb();
		}
		return eliminarTemaController;
	}

	@Override
	public VerVotos getVerVotosController() {
		if (verVotosController == null) {
			verVotosController = new VerVotosEjb();
		}
		return verVotosController;
	}

	@Override
	public Votar getVotarController() {
		if (votarController == null) {
			votarController = new VotarEjb();
		}
		return votarController;
	}

}
