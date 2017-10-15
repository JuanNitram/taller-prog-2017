package dataTypes;

import java.util.Date;

public class DtProponente extends DtUsuario {
	private String direccion;
	private String biografia;
	private String linkSitio;
	
	public DtProponente(String nickName, String nombre, String apellido, String email, Date fechaNacimiento,
			String rutaImg, String direccion, String biografia, String linkSitio) {
		super(nickName, nombre, apellido, email, fechaNacimiento, rutaImg);
		this.direccion = direccion;
		this.biografia = biografia;
		this.linkSitio = linkSitio; 
	}

	public String getDireccion() {
		return direccion;
	}

	public String getBiografia() {
		return biografia;
	}

	public String getLinkSitio() {
		return linkSitio;
	}
	
}
