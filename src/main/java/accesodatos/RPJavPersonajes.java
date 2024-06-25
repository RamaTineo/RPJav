package accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelos.Personajes;

public class RPJavPersonajes {
	private static final String URL = "jdbc:sqlite:C:\\Users\\Html\\eclipse-workspace\\RPJav\\src\\sql\\RPJava.db";
	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Personajes> obtenerSelect(String user, Long id) {
		ArrayList<Personajes> personajes = new ArrayList<>();
		try (Connection con = DriverManager.getConnection(URL);
				PreparedStatement pst = con.prepareStatement("SELECT * FROM Personajes WHERE user=? AND id=?");
				){
							pst.setString(1, user);
							pst.setLong(2, id);
				ResultSet rs = pst.executeQuery();
			Personajes personaje;
			while (rs.next()) {
				personaje = new Personajes(rs.getLong("id"), rs.getString("user"), rs.getString("img"),
						rs.getString("name"), rs.getString("tipo"), rs.getInt("vida"), rs.getInt("atk"),
						rs.getInt("deff"));
				personajes.add(personaje);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return personajes;
	}
}
