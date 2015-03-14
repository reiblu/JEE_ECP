package views.beans;

import java.util.List;

import models.entities.Tema;

import org.apache.logging.log4j.LogManager;

import controllers.ControllerFactory;

public class VerTemasBean {

	private int idTema;
	
    private List<Tema> temas;

    private String errorMsg;

    private ControllerFactory controllerFactory;

    public VerTemasBean() {

    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public List<Tema> getTemas() {
        return temas;
    }

    public void setTemas(List<Tema> temas) {
        this.temas = temas;
    }
    
	public void setidTema(int attribute) {

		idTema = attribute;

	}

    public void update() {
        LogManager.getLogger(VerTemasBean.class).debug(
                "Se accede a la capa de negocio para recuperar roles");
         this.temas = controllerFactory.getVotarController().getTemas();
    }

    public void setControllerFactory(ControllerFactory controller) {
        this.controllerFactory = controller;
        
    }
    
    public String process(){
    	return "votar";
    }

}
