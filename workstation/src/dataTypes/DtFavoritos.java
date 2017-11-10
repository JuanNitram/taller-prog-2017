package dataTypes;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtFavoritos {
	private ArrayList<String> favoritos = new ArrayList<String>();
	
	public DtFavoritos(){ 
	}

	public ArrayList<String> getFavoritos() {
		return favoritos;
	}

	public void setFavoritos(ArrayList<String> favoritas) {
		this.favoritos = favoritas;
	}
}
