package controladores;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Personajes;

@WebServlet("/formulario")

public class FormularioServlet extends HttpServlet {

	private static final long serialVersionUID = 8985265926684262172L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sId = request.getParameter("id");

		if (sId != null) {
			Long id = Long.parseLong(sId);

			try (Connection con = DriverManager.getConnection(
					"jdbc:sqlite:\"C:\\Users\\Html\\eclipse-workspace\\RPJav\\src\\sql\\PRJava.db");
					PreparedStatement pst = con.prepareStatement("SELECT * FROM personajes WHERE id=?");
					) {
				
				pst.setLong(1, id);
				ResultSet rs = pst.executeQuery();
				
				if (rs.next()) {
					Personajes personaje = new Personajes(rs.getLong("id"), rs.getString("usuario"), rs.getString("img"), rs.getString("name"), rs.getString("tipo"), rs.getInt("vida"), rs.getInt("atk"), rs.getInt("deff"));
					request.setAttribute("personaje", personaje);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		request.getRequestDispatcher("formulario.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 1. Recoger información de la petición
		String sId = request.getParameter("id");
		String usuario = request.getParameter("usuario");
		String img = request.getParameter("img");
		String name = request.getParameter("name");
		String tipo = request.getParameter("tipo");
		String sVida = request.getParameter("vida");
		String sAtk = request.getParameter("atk");
		String sDeff = request.getParameter("deff");

		// 2. Convertir la información
		Long id = sId.isBlank() ? null : Long.parseLong(sId);
		Long vida = sVida.isBlank() ? null : Long.parseLong(sVida);
		Long atk = sAtk.isBlank() ? null : Long.parseLong(sAtk);
		Long deff = sDeff.isBlank() ? null : Long.parseLong(sDeff);
		

		// 3. Empaquetar en modelo

		// 4. Ejecutar las acciones específicas

		try (Connection con = DriverManager
				.getConnection("jdbc:sqlite:C:\\Users\\Html\\eclipse-workspace\\RPJav\\src\\sql\\RPJava.db");
				PreparedStatement pstInsert = con
						.prepareStatement("INSERT INTO personajes (user, img, name, tipo, vida, atk, deff) VALUES (?,?,?,?,?,?,?)");
				PreparedStatement pstUpdate = con
						.prepareStatement("UPDATE personajes SET user=?, img=?, name=?, tipo=?, vida=?, atk=?, deff=? WHERE id=?")) {

			if (id == null) {
				// INSERTAR
				pstInsert.setString(1, usuario);
				pstInsert.setString(2, img);
				pstInsert.setString(3, name);
				pstInsert.setString(4, tipo);
				pstInsert.setLong(5, vida);
				pstInsert.setLong(6, atk);
				pstInsert.setLong(7, deff);

				pstInsert.executeUpdate();
			} else {
				pstUpdate.setString(1, usuario);
				pstUpdate.setString(2, img);
				pstUpdate.setString(3, name);
				pstUpdate.setString(4, tipo);
				pstUpdate.setLong(5, vida);
				pstUpdate.setLong(6, atk);
				pstUpdate.setLong(7, deff);
				pstUpdate.setLong(8, id);

				pstUpdate.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 5. Preparar los datos para la siguiente pantalla

		// 6. Saltar a la siguiente pantalla
		response.sendRedirect(request.getContextPath() + "/index");
	}

}