package views.beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import models.entities.Tema;
import models.utils.Estudios;
import controllers.ControllerFactory;

@ManagedBean
@SessionScoped
public class VotarBean {

    private int idTema;

    private Tema tema;

    private int valoracion;

    private String ipUsuario;

    private Estudios estudios;

    private String errorMsg;
    
    @ManagedProperty(value = "#{verTemasBean}")
    private VerTemasBean verTemasBean;
    
    @ManagedProperty(value = "#{controllerFactory}")
    private ControllerFactory controllerFactory;

    public VotarBean() {

    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }
    
    

    public int getValoracion() {
		return valoracion;
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
    
    

    public void setVerTemasBean(VerTemasBean verTemasBean) {
		this.verTemasBean = verTemasBean;
	}

	public void setidTema(int attribute) {
        idTema = attribute;
    }

    public Estudios[] getEstudios() {
        return Estudios.values();
    }

    @PostConstruct
    public void update() {
    	
    	idTema = Integer.valueOf(verTemasBean.getIdTema());
        this.tema = controllerFactory.getVotarController().getTema(idTema);

    }

    public String process() {
    	System.out.println("\n\n\nllegue\n\n\n");
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
