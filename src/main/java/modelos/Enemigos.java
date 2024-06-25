package modelos;

import java.util.Objects;

public class Enemigos {
	private Long id;
	private String img;
	private String tipo;
	private String name;
	private Integer vida;
	private Integer atk;
	private Integer deff;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
		return Objects.hash(atk, deff, id, img, name, tipo, vida);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enemigos other = (Enemigos) obj;
		return Objects.equals(atk, other.atk) && Objects.equals(deff, other.deff) && Objects.equals(id, other.id)
				&& Objects.equals(img, other.img) && Objects.equals(name, other.name)
				&& Objects.equals(tipo, other.tipo) && Objects.equals(vida, other.vida);
	}
	@Override
	public String toString() {
		return "Enemigos [id=" + id + ", img=" + img + ", tipo=" + tipo + ", name=" + name + ", vida=" + vida + ", atk="
				+ atk + ", deff=" + deff + "]";
	}
	public Enemigos(Long id, String img, String tipo, String name, Integer vida, Integer atk, Integer deff) {
		super();
		this.id = id;
		this.img = img;
		this.tipo = tipo;
		this.name = name;
		this.vida = vida;
		this.atk = atk;
		this.deff = deff;
	}

	
}
