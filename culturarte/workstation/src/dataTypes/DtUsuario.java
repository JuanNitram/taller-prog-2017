package dataTypes;

import java.util.Date;

public abstract class DtUsuario {

	protected String nickName; // Lo identifica
	protected String nombre;
	protected String apellido;
	protected String email; // Lo identifica
	protected Date fechaNacimiento;
	protected String rutaImg; 
	
	public DtUsuario(){}
	
	public DtUsuario(String nickName, String nombre, String apellido, String email, Date fechaNacimiento,
			String rutaImg) {
		super();
		this.nickName = nickName;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.rutaImg = rutaImg;
	}

	public String getNickName() {
		return nickName;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getEmail() {
		return email;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getRutaImg() {
		return rutaImg;
	}
	
}
