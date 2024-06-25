package controladores;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.google.common.hash.Hashing;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/crear-usuario")

public class CrearUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 8985265926684262172L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("crear-usuario.jsp").forward(request, response);
	}
 
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. Recoger información de la petición
		
		String user = request.getParameter("user");
		String email = request.getParameter("email");
		String hpass = request.getParameter("pass");

		// 2. Convertir la información
		String pass = Hashing.sha256().hashString(hpass, StandardCharsets.UTF_8).toString();

		// 3. Empaquetar en modelo

		// 4. Ejecutar las acciones específicas

		try (Connection con = DriverManager
				.getConnection("jdbc:sqlite:C:\\Users\\Html\\eclipse-workspace\\RPJav\\src\\sql\\RPJava.db");
				PreparedStatement pstInsert = con
						.prepareStatement("INSERT INTO Usuarios (user, email, pass) VALUES (?,?,?)")) {

			// INSERTAR
			pstInsert.setString(1, user);
			pstInsert.setString(2, email);
			pstInsert.setString(3, pass);

			pstInsert.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 5. Preparar los datos para la siguiente pantalla

		// 6. Saltar a la siguiente pantalla
		response.sendRedirect(request.getContextPath() + "/login");
	}

}