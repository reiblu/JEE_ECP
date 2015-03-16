package views.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import models.entities.Tema;
import models.utils.Estudios;
import controllers.ControllerFactory;

@ManagedBean
public class VerVotosBean {

    private int idTema;

    private Tema tema;

    private Estudios estudios;

    @ManagedProperty(value = "#{controllerFactory}")
    private ControllerFactory controllerFactory;

    private long numVotos;

    private double mediaValoracion;

    public VerVotosBean() {

    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public long getNumVotos() {
        return numVotos;
    }

    public void setNumVotos(int numVotos) {
        this.numVotos = numVotos;
    }

    public double getMediaValoracion() {
        return mediaValoracion;
    }

    public void setMediaValoracion(double mediaValoracion) {
        this.mediaValoracion = mediaValoracion;
    }

    public void setControllerFactory(ControllerFactory controller) {
        this.controllerFactory = controller;

    }

    public void setidTema(Integer idTema) {
        this.idTema = idTema;

    }

    public Estudios getEstudios() {
        return estudios;
    }

    public void setEstudios(Estudios estudios) {
        this.estudios = estudios;
    }

    public void update() {
        this.tema = controllerFactory.getVerVotosController().getTema(idTema);
        this.numVotos = controllerFactory.getVerVotosController().getNumVotos(idTema);
        this.mediaValoracion = controllerFactory.getVerVotosController().getValoracionMedia(idTema,
                estudios);
    }

    public void setEstudios(String estudios) {
        this.estudios = Estudios.valueOf(estudios);

    }

}
