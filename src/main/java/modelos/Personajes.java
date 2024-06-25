package modelos;

import java.util.Objects;

public class Personajes {
	private Long id;
	private String user;
	private String img;
	private String name;
	private String tipo;
	private Integer vida;
	private Integer atk;
	private Integer deff;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Integer getVida() {
		return vida;
	}
	public void setVida(Integer vida) {
		this.vida = vida;
	}
	public Integer getAtk() {
		return atk;
	}
	public void setAtk(Integer atk) {
		this.atk = atk;
	}
	public Integer getDeff() {
		return deff;
	}
	public void setDeff(Integer deff) {
		this.deff = deff;
	}
	@Override
	public int hashCode() {
		return Objects.hash(atk, deff, id, img, name, tipo, user, vida);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personajes other = (Personajes) obj;
		return Objects.equals(atk, other.atk) && Objects.equals(deff, other.deff) && Objects.equals(id, other.id)
				&& Objects.equals(img, other.img) && Objects.equals(name, other.name)
				&& Objects.equals(tipo, other.tipo) && Objects.equals(user, other.user)
				&& Objects.equals(vida, other.vida);
	}
	@Override
	public String toString() {
		return "Personajes [id=" + id + ", usuario=" + user + ", img=" + img + ", name=" + name + ", tipo=" + tipo
				+ ", vida=" + vida + ", atk=" + atk + ", deff=" + deff + "]";
	}
	public Personajes(Long id, String user, String img, String name, String tipo, Integer vida, Integer atk,
			Integer deff) {
		super();
		this.id = id;
		this.user = user;
		this.img = img;
		this.name = name;
		this.tipo = tipo;
		this.vida = vida;
		this.atk = atk;
		this.deff = deff;
	}

}