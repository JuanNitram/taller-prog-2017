package dataTypes;

import java.util.Date;

public class DtColaborador extends DtUsuario {

	
	public DtColaborador(String nickName, String nombre, String apellido, String email, Date fechaNacimiento,
			String rutaImg) { 
		super(nickName, nombre, apellido, email, fechaNacimiento, rutaImg);
	}
}
