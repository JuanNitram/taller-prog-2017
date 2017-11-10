package dataTypes;

import java.util.ArrayList;

public class DtPropuestas {
	private ArrayList<DtPropuesta> propuestas = new ArrayList<DtPropuesta>();
	
	public DtPropuestas(){
	}

	public ArrayList<DtPropuesta> getPropuestas() {
		return propuestas;
	} 

	public void setPropuestas(ArrayList<DtPropuesta> propuestas) {
		this.propuestas = propuestas;
	}
}
