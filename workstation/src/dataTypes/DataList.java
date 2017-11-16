package dataTypes;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataList {
	private ArrayList datos = new ArrayList<>();
	
	public DataList(){}
	
	public ArrayList getDatos(){
		return datos;
	}
	
	public void setDatos(ArrayList datos){
		this.datos = datos;
	}
}
