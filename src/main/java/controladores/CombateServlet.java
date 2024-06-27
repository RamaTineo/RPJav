package controladores;

import java.io.IOException;

import accesodatos.RPJav;
import accesodatos.RPJavPersonajes;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/combate")

public class CombateServlet extends HttpServlet {

	private static final long serialVersionUID = 1424943602095385520L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Long numero = (long) ((int) (Math.random() * 3) + 1);
		
		request.setAttribute("enemigos", RPJav.obtenerUno(numero));
		String user = (String) request.getSession().getAttribute("user");
		String sId = request.getParameter("id");
		Long id = Long.parseLong(sId);
		request.setAttribute("personajes", RPJavPersonajes.obtenerSelect(user, id));

		request.getRequestDispatcher("combate.jsp").forward(request, response);
	}
}
