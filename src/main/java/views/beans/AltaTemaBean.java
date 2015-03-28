package views.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import controllers.ControllerFactory;

@ManagedBean
public class AltaTemaBean {

	@ManagedProperty(value = "#{controllerFactory}")
	private ControllerFactory controllerFactory;

	@ManagedProperty(value = "#{nombre}")
	private String nombre;

	@ManagedProperty(value = "#{pregunta}")
	private String pregunta;

	public AltaTemaBean() {

	}

	public void setControllerFactory(ControllerFactory controller) {
		this.controllerFactory = controller;

	}

	public void setNombre(String nombre) {
		this.nombre = nombre;

	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;

	}

	public String getNombre() {
		return nombre;
	}

	public String getPregunta() {
		return pregunta;
	}

	public String process() {
		controllerFactory.getanadirTemaController().nuevoTema(nombre, pregunta);
		return "home";
	}

}
