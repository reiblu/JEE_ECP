package views.beans;

import org.apache.logging.log4j.LogManager;

import models.entities.Tema;
import controllers.ControllerFactory;

public class VotarBean {

	private int idTema;

	private Tema tema;

	private String errorMsg;

	private ControllerFactory controllerFactory;

	public VotarBean() {

	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public void setControllerFactory(ControllerFactory controller) {
		this.controllerFactory = controller;

	}


	public void update() {

		this.tema = controllerFactory.getVotarController().getTema(idTema);

	}

	public String process() {
		if (this.tema == null) {
			this.errorMsg = "Me estas intentado timar";
			LogManager.getLogger(VerTemasBean.class).debug(this.errorMsg);
			return "home";
		} else {
			//controllerFactory.getVotarController().votar();
			return "home";
		}
	}

}
