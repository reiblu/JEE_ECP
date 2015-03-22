package views.beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import models.entities.Tema;
import controllers.ControllerFactory;

@ManagedBean
public class EliminarTemaBean {

	private int idTema;

	private int auth;

	private Tema tema;

	@ManagedProperty(value = "#{verTemasBean}")
	private VerTemasBean verTemasBean;

	@ManagedProperty(value = "#{controllerFactory}")
	private ControllerFactory controllerFactory;

	public EliminarTemaBean() {

	}

	public int getIdTema() {
		return idTema;
	}

	public void setIdTema(int idTema) {
		this.idTema = idTema;
	}

	public void setidTema(Integer idTema) {
		this.idTema = idTema;

	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public void setControllerFactory(ControllerFactory controller) {
		this.controllerFactory = controller;

	}

	public void setVerTemasBean(VerTemasBean verTemasBean) {
		this.verTemasBean = verTemasBean;
	}

	public int getAuth() {
		return auth;
	}

	public void setAuth(Integer auth) {
		this.auth = auth;

	}

	public void setAuth(int auth) {
		this.auth = auth;

	}

	@PostConstruct
	public void updatejsf() {
		if (verTemasBean.getIdTema() != null) {
			idTema = Integer.valueOf(verTemasBean.getIdTema());
		}
		this.tema = controllerFactory.getVotarController().getTema(idTema);
	}

	public String process() {
		if (auth == 666) {
			controllerFactory.getEliminarController().eliminar(idTema);
			return "home";
		} else {
			System.out.println("No autorizado");
			return "error";
		}
	}

}
