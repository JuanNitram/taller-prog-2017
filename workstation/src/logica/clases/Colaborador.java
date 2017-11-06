package logica.clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dataTypes.DtColaboracion;
import dataTypes.DtColaborador; 

public class Colaborador extends Usuario {

	private String nombre;
	private Map<Integer, Colaboracion> colaboraciones;
	
	public Colaborador(String nickName, String password, String nombre, String apellido, String email,
			String rutaImg, Date fechaNacimiento) {
		super(nickName, password, nombre, apellido, email, fechaNacimiento, rutaImg);
		this.nombre = nombre;
		colaboraciones = new HashMap<Integer, Colaboracion>();
	}
 
	public void agregarColaboracion(Colaboracion colaboracion) {
		colaboraciones.put(colaboracion.getId(), colaboracion);
	}

	public void quitarColaboracion(Colaboracion colaboracion) {
		colaboraciones.remove(colaboracion.getId());
	}
	
	public DtColaborador getInfoColaborador() {
		List<DtColaboracion> colaboraciones = new ArrayList();
		for (Colaboracion colab : this.colaboraciones.values()) 
			colaboraciones.add(colab.getInfoColaboracion());
		return new DtColaborador(super.getNickName(), getNombre(), super.getApellido(), super.getEmail(), super.getFechaNacimiento(), super.getRutaImg(), colaboraciones, super.listarFavoritas());
	}

	public List<DtColaboracion> getColaboraciones() {
		List<DtColaboracion> colaboraciones = new ArrayList();
		for (Colaboracion colab : this.colaboraciones.values()) 
			colaboraciones.add(colab.getInfoColaboracion());
		return colaboraciones;
	}

	@Override
	public String getNombre() {
		return this.nombre;
	}
	
}
