package views.beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import models.entities.Tema;
import models.utils.Estudios;
import controllers.ControllerFactory;

@ManagedBean(name = "votarBean")
@SessionScoped
public class VotarBean {

	private int idTema;

	private Tema tema;

	private int valoracion;

	private String ipUsuario;

	private Estudios nivelEstudios;

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

	public int getIdTema() {
		return idTema;
	}

	@PostConstruct
	public void updatejsf() {
		idTema = Integer.valueOf(verTemasBean.getIdTema());
		this.update();
	}

	public void update() {

		this.tema = controllerFactory.getVotarController().getTema(idTema);

	}

	public String process() {
		this.tema = controllerFactory.getVotarController().getTema(idTema);
		if (ipUsuario == null) {
			this.ipUsuario = this.getRemoteAddr();
		}
		controllerFactory.getVotarController().votar(nivelEstudios, ipUsuario,
				valoracion, tema);
		return "home";

	}

	public void setValoracion(Integer valoracion) {
		this.valoracion = valoracion;

	}

	public void setEstudios(String estudio) {
		this.nivelEstudios = Estudios.valueOf(estudio);

	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public Estudios getNivelEstudios() {
		return nivelEstudios;
	}

	public void setNivelEstudios(Estudios nivelEstudios) {
		this.nivelEstudios = nivelEstudios;
	}

	public void setIpusuario(String ipUser) {
		this.ipUsuario = ipUser;

	}
	
	public String getRemoteAddr() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String ipAddress = request.getHeader("X-FORWARDED-FOR");
		if (ipAddress == null) {
		    ipAddress = request.getRemoteAddr();
		}
		return ipAddress;
	}

}
