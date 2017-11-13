package dataTypes;

import java.util.ArrayList;

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
