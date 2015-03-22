package views.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;

import controllers.ControllerFactory;
import controllersEjb.ControllerEjbFactory;

@WebServlet("/jsp/*")
public class Dispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String PATH_ROOT_VIEW = "/viewsJsp/";

	private ControllerFactory controller;

	@Override
	public void init() throws ServletException {
		super.init();
		controller = new ControllerEjbFactory();
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String action = request.getPathInfo().substring(1);
		LogManager.getLogger(Dispatcher.class).debug("Action: " + action);

		String view;
		switch (action) {
		
		case "error":
			view = "error";
			break;
		case "verTemas":
			VerTemasBean temas = new VerTemasBean();
			temas.setControllerFactory(controller);
			request.setAttribute(action, temas);
			view = action;
			break;
		case "altaTema":
			AltaTemaBean tema = new AltaTemaBean();
			tema.setControllerFactory(controller);
			request.setAttribute(action, tema);
			view = action;
			break;
		default:
			view = "home";
		}

		this.getServletContext()
				.getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
				.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo().substring(1);
		String actionAux;
		LogManager.getLogger(Dispatcher.class).debug("Action: " + action);

		String view = "home";
		switch (action) {
		
		case "procesarVoto":
            VotarBean votar = new VotarBean();
            votar.setidTema(Integer.valueOf(request.getParameter("tema")));
            votar.setControllerFactory(controller);
            actionAux = "votar";
            request.setAttribute(actionAux, votar);
            view = actionAux;
            break;
		
		case "verVotos":
            VerVotosBean votos = new VerVotosBean();
            votos.setidTema(Integer.valueOf(request.getParameter("tema")));
            votos.setEstudios(request.getParameter("estudios"));
            votos.setControllerFactory(controller);
            request.setAttribute(action, votos);
            view = action;
            break;

		case "votar":
			VotarBean votar1 = new VotarBean();
			votar1.setidTema(Integer.valueOf(request.getParameter("tema")));
			votar1.setValoracion(Integer.valueOf(request
					.getParameter("valoracion")));
			votar1.setEstudios(request.getParameter("estudios"));
			votar1.setIpusuario(request.getRemoteAddr());
			votar1.setControllerFactory(controller);
			request.setAttribute(action, votar1);
			view = votar1.process();
			break;

		case "altaTema":
			AltaTemaBean tema = new AltaTemaBean();
			tema.setNombre(request.getParameter("tema"));
			tema.setPregunta(request.getParameter("pregunta"));
			tema.setControllerFactory(controller);
			request.setAttribute(action, tema);
			view = tema.process();
			break;

		case "eliminarTema":
			EliminarTemaBean eliminar = new EliminarTemaBean();
			eliminar.setidTema(Integer.valueOf(request.getParameter("tema")));
			eliminar.setAuth(Integer.valueOf(request.getParameter("auth")));
			eliminar.setControllerFactory(controller);
			request.setAttribute(action, eliminar);
			view = eliminar.process();
			break;
		}

		this.getServletContext()
				.getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
				.forward(request, response);
	}

}
