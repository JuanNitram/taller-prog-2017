package Logica.clases;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import java.util.HashMap;
import java.util.Map;

import dataTypes.DtUsuario;

public abstract class Usuario {
	protected String nickName; // Lo identifica
	protected String password;
	protected String nombre;
	protected String apellido;
	protected String email; // Lo identifica
	protected Date fechaNacimiento;
	protected String rutaImg;
	protected Map<String,Usuario> seguidores;
	protected Map<String,Usuario> seguidos;
	protected ArrayList<Propuesta> favoritas;

	public Usuario(){}
	 
	public Usuario(String nickName, String password, String nombre, String apellido, String email, Date fechaNacimiento,
			String rutaImg) {
		super();
		this.nickName = nickName;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.rutaImg = rutaImg;
		this.seguidores = new HashMap<String,Usuario>();
		this.seguidos = new HashMap<String,Usuario>();
	}

	public String getNickName() {
		return nickName;
	}


	public String getNombre() {
		return nombre;
	}
	
	public String getPassword(){
		return password;
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

	public void addSeguidor(Usuario us){
		seguidores.put(us.getNickName(),us);
	}
	
	public void eraseSeguidor(Usuario us){
		seguidores.remove(us.getNickName());
	}
	
	public void addSeguido(Usuario us){
		seguidos.put(us.getNickName(),us);
	}
	
	public void eraseSeguido(Usuario us){
		seguidos.remove(us.getNickName());
	}
	
	public Collection<Usuario> getSeguidores(){
		Collection<Usuario> res = seguidores.values();
		return res;
	}
	
	public Collection<Usuario> getSeguidos(){
		Collection<Usuario> res = seguidos.values();
		return res;
	}
	
	public void marcarFavorita(Propuesta favorita) {
		favoritas.add(favorita);
	}
}
