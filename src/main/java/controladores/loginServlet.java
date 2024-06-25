package controladores;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.google.common.hash.Hashing;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")

public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1424943602095385520L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = request.getParameter("user");
		String hpass = request.getParameter("pass");

		String pass = Hashing.sha256().hashString(hpass, StandardCharsets.UTF_8).toString();

		boolean isValidUser = ValidateUser(user, pass);

		if (isValidUser) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);

			response.sendRedirect(request.getContextPath() + "/index");
		} else {
			request.setAttribute("error", "El usuario o contraseña no son correctos");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

	private boolean ValidateUser(String user, String pass) {

		try (Connection con = DriverManager
				.getConnection("jdbc:sqlite:C:\\Users\\Html\\eclipse-workspace\\RPJav\\src\\sql\\RPJava.db");
				PreparedStatement pst = con.prepareStatement("SELECT * FROM Usuarios WHERE user=? AND pass=?");) {
			pst.setString(1, user);
			pst.setString(2, pass);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
