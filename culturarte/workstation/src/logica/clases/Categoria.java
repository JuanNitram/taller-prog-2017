package logica.clases;

import java.util.HashMap;
import java.util.Map;

public class Categoria {
	
	private String nombre;
	private Map<String, Categoria> hijos;
	
	public Categoria(String name) {
		this.nombre = name; 
		this.hijos  = new HashMap<String, Categoria>();
	}
	
	public void agregar(Categoria categoria) {
		hijos.put(((Categoria) categoria).nombre, categoria);
	}

	public Map<String, Categoria> hijos() {
		return hijos;
	}
	
	public String getNombre() {
		return nombre;
	}
}