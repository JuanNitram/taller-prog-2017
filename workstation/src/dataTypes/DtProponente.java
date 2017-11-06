package dataTypes;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtProponente extends DtUsuario {
	private String direccion;
	private String biografia;
	private String linkSitio;
	private List<DtPropuesta> propuestas;
	
	public DtProponente() {
		super();
	}
	
	public DtProponente(String nickName, String nombre, String apellido, String email, Date fechaNacimiento,
			String rutaImg, String direccion, String biografia, String linkSitio, List<DtPropuesta> propuestas, List<String> favoritas) {
		super(nickName, nombre, apellido, email, fechaNacimiento, rutaImg, favoritas);
		this.direccion = direccion;
		this.biografia = biografia;
		this.linkSitio = linkSitio; 
		this.propuestas = propuestas;
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
	
	public List<DtPropuesta> getPropuestas() {
		return this.propuestas;
	}
}
