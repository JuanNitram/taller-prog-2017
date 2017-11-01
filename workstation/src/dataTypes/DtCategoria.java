package dataTypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtCategoria {
	
	private String nombre;
	
	public DtCategoria() {
		super();
	}

	public DtCategoria(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() { 
		return nombre;
	}
}
