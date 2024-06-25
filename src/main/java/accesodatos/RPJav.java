package accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelos.Enemigos;

public class RPJav {
	private static final String URL = "jdbc:mysql://localhost/rpjavmysql";
	private static final String USER = "root";
	private static final String PASS = "1234";
	private static final String SQL_SELECT = "SELECT * FROM enemigos";
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

	public static ArrayList<Enemigos> obtenerTodos() {
		ArrayList<Enemigos> enemigos = new ArrayList<>();
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pst = con.prepareStatement(SQL_SELECT);
				ResultSet rs = pst.executeQuery()) {
			Enemigos enemigo;
			while (rs.next()) {
				enemigo = new Enemigos(rs.getLong("id"), rs.getString("img"), rs.getString("tipo"), rs.getString("name"),
						rs.getInt("vida"), rs.getInt("atk"), rs.getInt("deff"));
				enemigos.add(enemigo);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return enemigos;
	}
}
