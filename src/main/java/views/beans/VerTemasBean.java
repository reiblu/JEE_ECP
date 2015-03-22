package views.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import models.entities.Tema;
import models.utils.Estudios;

import org.apache.logging.log4j.LogManager;

import controllers.ControllerFactory;

@ManagedBean(name = "verTemasBean")
public class VerTemasBean {

	private String idTema;

	private List<Tema> temas;

	private Estudios nivelEstudios;
	
	@ManagedProperty(value = "#{controllerFactory}")
	private ControllerFactory controllerFactory;

	public VerTemasBean() {

	}

	@PostConstruct
	public void update() {
		LogManager.getLogger(VerTemasBean.class).debug(
				"Se accede a la capa de negocio para recuperar roles");
		this.temas = controllerFactory.getVotarController().getTemas();
	}

	public Estudios[] getEstudios() {
		return Estudios.values();
	}

	public List<Tema> getTemas() {
		return temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}

	public Estudios getNivelEstudios() {
		return nivelEstudios;
	}

	public void setNivelEstudios(Estudios nivelEstudios) {
		this.nivelEstudios = nivelEstudios;
	}

	public void setControllerFactory(ControllerFactory controller) {
		this.controllerFactory = controller;

	}

	public String getIdTema() {
		return idTema;
	}

	public void setIdTema(String idTema) {
		this.idTema = idTema;
	}

	public String votar() {
		return "votar";
	}

	public String verVotos() {
		return "verVotos";

	}

	public String eliminarTema() {
		return "eliminarTema";

	}
}
