package views.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import models.entities.Tema;
import models.utils.Estudios;

import org.apache.logging.log4j.LogManager;

import controllers.ControllerFactory;

@ManagedBean
public class VerTemasBean {
    
    private String oneListbox;
	
    @ManagedProperty (value="#{temas}")
    private List<Tema> temas;

    private String errorMsg;
    
    @ManagedProperty(value = "#{tema.getNombre()}")
    private String nombre;

    @ManagedProperty(value = "#{controllerFactory}")
    private ControllerFactory controllerFactory;

    public VerTemasBean() {

    }
    
    public Estudios[] getEstudios() {
        return Estudios.values();
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getOneListbox() {
        return oneListbox;
    }

    public void setOneListbox(String oneListbox) {
        this.oneListbox = oneListbox;
    }

    public List<Tema> getTemas() {
        return temas;
    }

    public void setTemas(List<Tema> temas) {
        this.temas = temas;
    }

    public void update() {
        LogManager.getLogger(VerTemasBean.class).debug(
                "Se accede a la capa de negocio para recuperar roles");
         this.temas = controllerFactory.getVotarController().getTemas();
    }

    public void setControllerFactory(ControllerFactory controller) {
        this.controllerFactory = controller;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
  

}
