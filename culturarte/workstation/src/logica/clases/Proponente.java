package logica.clases;

import java.util.Date;
import java.util.Map;

import dataTypes.DtProponente;

import java.util.HashMap;

public class Proponente extends Usuario {

	private String direccion;
	private String biografia;
	private String linkSitio;
	private Map<String,Propuesta> propuestas;
	
	public Proponente(String nickName,String password, String nombre, String apellido, String email, Date fechaNacimiento,
			String rutaImg, String direccion, String biografia, String linkSitio) {
		super(nickName,password, nombre, apellido, email, fechaNacimiento, rutaImg);
		this.direccion = direccion;
		this.biografia = biografia;
		this.linkSitio = linkSitio;
		this.propuestas = new HashMap<String,Propuesta>();
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public String getLinkSitio() {
		return linkSitio;
	}

	public void setLinkSitio(String linkSitio) {
		this.linkSitio = linkSitio;
	}
	
	public void setNewPropuesta(String titulo ,Propuesta p){
		this.propuestas.put(titulo, p);
	}
	
	public DtProponente getInfoProponente() {
		return new DtProponente(nickName,nombre,apellido,email,fechaNacimiento,rutaImg,direccion,biografia,linkSitio);
	}
}
