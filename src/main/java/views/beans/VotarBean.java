package views.beans;

import models.entities.Tema;
import models.utils.Estudios;
import controllers.ControllerFactory;

public class VotarBean {

	private int idTema;

	private Tema tema;
	
	private int valoracion;
	
	private String ipUsuario;
	
	private Estudios estudios;

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

	public void setidTema(int attribute) {

		idTema = attribute;

	}
	
	public Estudios[] getEstudios(){
		return Estudios.values();
	}

	public void update() {

		this.tema = controllerFactory.getVotarController().getTema(idTema);

	}

	public String process() {
			update();
			controllerFactory.getVotarController().votar(estudios, ipUsuario, valoracion, tema);
			return "home";
		
	}

	public void setValoracion(Integer valoracion) {
		this.valoracion = valoracion;
		
	}

	public void setEstudios(String estudio) {
		this.estudios = Estudios.valueOf(estudio);
		
	}

	public void setIpusuario(String ipUser) {
		this.ipUsuario = ipUser;
		
	}

}
