package dataTypes;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtColaborador extends DtUsuario {

	private List<DtColaboracion> colaboraciones;
	
	public DtColaborador() {
		super();
	}

	public DtColaborador(String nickName, String nombre, String apellido, String email, Date fechaNacimiento,
			String rutaImg, List<DtColaboracion> colaboraciones) { 
		super(nickName, nombre, apellido, email, fechaNacimiento, rutaImg);
		this.colaboraciones = colaboraciones;
	}
	
	public List<DtColaboracion> getColaboraciones() {
		return this.colaboraciones;
	}
	
}
