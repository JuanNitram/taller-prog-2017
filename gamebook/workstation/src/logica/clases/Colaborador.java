package logica.clases;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import dataTypes.DtColaborador;

public class Colaborador extends Usuario {

	private Map<Integer,Colaboracion> colaboraciones;
	
	public Colaborador(String nickName,String password, String nombre, String apellido, String email,
			String rutaImg, Date fechaNacimiento) {
		super(nickName,password, nombre, apellido, email, fechaNacimiento, rutaImg);
		colaboraciones = new HashMap<Integer,Colaboracion>();
	}
 
	public void agregarColaboracion(Colaboracion c) {
		colaboraciones.put(c.getId(),c);
	}

	public void quitarColaboracion(Colaboracion c) {
		colaboraciones.remove(c.getId());
	}
	
	public DtColaborador getInfoColaborador() {
		return new DtColaborador(nickName, nombre, apellido, email, fechaNacimiento, rutaImg);
	}
}
