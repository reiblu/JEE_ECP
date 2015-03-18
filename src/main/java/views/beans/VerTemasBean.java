package views.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;

import models.entities.Tema;
import models.utils.Estudios;

import org.apache.logging.log4j.LogManager;

import controllers.ControllerFactory;

@ManagedBean
public class VerTemasBean {
    
    private String oneListbox;
    
    private String idTema;
	
    @ManagedProperty (value="#{temas}")
    private List<Tema> temas;

    SelectItem items;
    
    private String errorMsg;
    
    @ManagedProperty(value = "#{tema.getNombre()}")
    private String nombre;

    @ManagedProperty(value = "#{controllerFactory}")
    private ControllerFactory controllerFactory;
    
    //@ManagedProperty(value = "#{votarBean}")
    private VotarBean votarBean;

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


    public void setControllerFactory(ControllerFactory controller) {
        this.controllerFactory = controller;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setVotarBean(VotarBean votarBean) {
        this.votarBean = votarBean;
    }

    public String getIdTema() {
        return idTema;
    }

    public void setIdTema(String idTema) {
        this.idTema = idTema;
    }

    public String votar(){
        //this.votarBean.setidTema(Integer.valueOf(idTema));
        //Pasar tema al bean de votar
        return "votar";
    }
    
    public String verVotos(){
        return null;
        
    }
    public String eliminarTema(){
        return null;
        
    }
}
