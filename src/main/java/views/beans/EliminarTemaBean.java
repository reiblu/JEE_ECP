package views.beans;

import controllers.ControllerFactory;

public class EliminarTemaBean {

	private int idTema;

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

	public void setControllerFactory(ControllerFactory controller) {
		this.controllerFactory = controller;

	}

	public String process() {
		controllerFactory.getEliminarController().eliminar(idTema);
		return "home";
	}

}
