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
		case "verVotos":
			VerVotosBean votos = new VerVotosBean();
			request.setAttribute(action, votos);
			view = action;
			break;
		case "votar":
			VotarBean votar = new VotarBean();
			votar.setidTema(Integer.valueOf(request.getParameter("tema")));
			votar.setControllerFactory(controller);
			request.setAttribute(action, votar);
			view = action;
			break;
		case "verTemas":
			VerTemasBean temas = new VerTemasBean();
			temas.setControllerFactory(controller);
			request.setAttribute(action, temas);
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
		LogManager.getLogger(Dispatcher.class).debug("Action: " + action);

		String view = "home";
		switch (action) {

		case "votar":
			VotarBean votar = new VotarBean();
			votar.setidTema(Integer.valueOf(request.getParameter("tema")));
			votar.setValoracion(Integer.valueOf(request
					.getParameter("valoracion")));
			votar.setEstudios(request.getParameter("estudios"));
			votar.setIpusuario(request.getRemoteAddr());
			votar.setControllerFactory(controller);
			request.setAttribute(action, votar);
			view = votar.process();
			break;

		case "eliminarTema":
			EliminarTemaBean eliminar = new EliminarTemaBean();
			eliminar.setidTema(Integer.valueOf(request.getParameter("tema")));
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
