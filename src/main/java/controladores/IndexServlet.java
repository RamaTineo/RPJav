package controladores;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Personajes;

@WebServlet("/index")

public class IndexServlet extends HttpServlet {

	private static final long serialVersionUID = 1424943602095385520L;

	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
@Override	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	String user = (String) request.getSession().getAttribute("user");
	
	if(user != null) {
	
try (Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Html\\eclipse-workspace\\RPJav\\src\\sql\\RPJava.db");
		PreparedStatement pst = con.prepareStatement("SELECT * FROM Personajes WHERE user=?");
		){
	pst.setString(1, user);
	ResultSet rs = pst.executeQuery();
	ArrayList<Personajes> personajes = new ArrayList<>();
	
	Personajes personaje;
	
	while (rs.next()) {
		personaje = new Personajes(rs.getLong("id"), rs.getString("user"), rs.getString("img"), rs.getString("name"), rs.getString("tipo"), rs.getInt("vida"), rs.getInt("atk"), rs.getInt("deff"));
		personajes.add(personaje);
	}
	request.setAttribute("personajes", personajes);
	
	request.getRequestDispatcher("index.jsp").forward(request,response);
	
}
	catch(SQLException e) {
		e.printStackTrace();
	}
}
	request.getRequestDispatcher("index.jsp").forward(request, response);
	}
@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

}
}
