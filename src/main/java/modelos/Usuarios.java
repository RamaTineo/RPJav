package modelos;

import java.util.Objects;

public class Usuarios {
	private Long id;
	private String email;
	private String user;
	private String pass;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, id, pass, user);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuarios other = (Usuarios) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(pass, other.pass)
				&& Objects.equals(user, other.user);
	}
	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", email=" + email + ", user=" + user + ", pass=" + pass + "]";
	}
	public Usuarios(Long id, String email, String user, String pass) {
		super();
		this.id = id;
		this.email = email;
		this.user = user;
		this.pass = pass;
	}

}
