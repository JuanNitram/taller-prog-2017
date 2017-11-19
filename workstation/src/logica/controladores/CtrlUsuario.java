package logica.controladores;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import dataTypes.DtColaborador;
import dataTypes.DtProponente;
import dataTypes.DtPropuesta;
import dataTypes.DtUsuario;
import logica.Fabrica;
import logica.ICtrlUsuario;
import logica.clases.Acceso;
import logica.clases.Colaboracion;
import logica.clases.Colaborador;
import logica.clases.Proponente;
import logica.clases.Propuesta;
import logica.clases.Usuario;

public class CtrlUsuario implements ICtrlUsuario {
	
	private static final CtrlUsuario instance = new CtrlUsuario();
	private Map<String, Usuario> usuarios;
	private Usuario usSeguidor;
	private Usuario usSeguido;
	private ArrayList<Acceso> accesos;
	
	private CtrlUsuario() { 
		this.usuarios = new HashMap<String, Usuario>();
		this.accesos = new ArrayList<Acceso>();
	}
	
	public void bajaProponente(String nickName){
		ArrayList<DtPropuesta> props = (ArrayList) CtrlPropuesta.getInstance().listarPropuestas();
		for(int i=0; i < props.size();i++){
			if(props.get(i).getNickProponente().equals(nickName))
				CtrlPropuesta.getInstance().bajaPropuesta(props.get(i).getTitulo());
		}
		
		Usuario usr = usuarios.get(nickName);
		
		for(int j=0;j < usuarios.size();j++){
			if(usuarios.get(j) instanceof Colaborador){
				Colaborador c = (Colaborador)usuarios.get(j);
				for(int k = 0; k < props.size(); k++){
					if(props.get(k).getNickProponente() == nickName){
						c.bajaColaboracion(props.get(k).getTitulo());
					}
				}
			}
		}
		
	    for(Iterator<Map.Entry<String, Usuario>> it = usuarios.entrySet().iterator(); it.hasNext(); ) {
	        Map.Entry<String, Usuario> entry = it.next();
	        entry.getValue().eraseSeguido(usr);
	    }
	    
		usuarios.remove(nickName);
	}
	
	public boolean esFavorita(String usuario, String propuesta){
		boolean esfa = false;
		for(String s : usuarios.get(usuario).listarFavoritas()){
			if (s.equals(propuesta))
				esfa= true;
		}
		return esfa;
	}
	
	public List<DtUsuario> listarUsuarios(){
		ArrayList<DtUsuario> res = new ArrayList<DtUsuario>();
		if (!this.usuarios.isEmpty()) {
            Collection<Usuario> users = this.usuarios.values();
            Object[] objs = users.toArray();
            for (int i = 0; i < users.size(); i++) {
            	if (objs[i] instanceof Proponente)
            		res.add(((Proponente) objs[i]).getInfoProponente());
            	else
            		res.add(((Colaborador) objs[i]).getInfoColaborador());
            }
		}
        return res;
	}
	
	public boolean esProponente(String nickname){
			return usuarios.get(nickname) instanceof Proponente;
	}
	
	public List<DtProponente>  listarProponentes(){
		ArrayList<DtProponente> res = new ArrayList<DtProponente>();
		if (!this.usuarios.isEmpty()) { 
            Collection<Usuario> colabs = this.usuarios.values();
            Object[] objs = colabs.toArray();
            for (int i = 0; i < colabs.size(); i++) {
            	if (objs[i] instanceof Proponente)
            		res.add(((Proponente) objs[i]).getInfoProponente());
            }
		}
        return res;
	}
	
	public List<DtColaborador> listarColaboradores(){
		ArrayList<DtColaborador> res = new ArrayList<DtColaborador>();
		if (!usuarios.isEmpty()) {
            Collection<Usuario> colabs = usuarios.values();
            Object[] objs = colabs.toArray();
            for (int i = 0; i < colabs.size(); i++) {
            	if (objs[i] instanceof Colaborador)
            		res.add(((Colaborador) objs[i]).getInfoColaborador());
            }
		}
        return res;
	}
	
	public void elegirSeguidor(String nickName){
		this.usSeguidor= usuarios.get(nickName);
	}
	
	public void elegirSeguido(String nickName){
		this.usSeguido= usuarios.get(nickName);
	}
	
	public void dejarSeguir(){
		this.usSeguido.eraseSeguidor(this.usSeguidor);
		this.usSeguidor.eraseSeguido(this.usSeguido);
	}
	
	public void seguir(){
		this.usSeguido.addSeguidor(this.usSeguidor);
		this.usSeguidor.addSeguido(this.usSeguido);
	}
	
	/*
	/* Devuelve true si el usuario con nickName o email dados, está registrado en el sistema. 
	 * Precondición: Al menos uno de los parámetros debe tener datos.
	 * 
	 */
	public boolean existeUsuario(String nickName, String email){ 
		boolean res = false;
		for (Usuario u : this.usuarios.values()) {
			if ((nickName != null && u.getNickName().equals(nickName)) || (email != null && u.getEmail().equals(email))){
				res = true;
				break;
			}
		}
		return res;
	}
	
	public void altaProponente(String nickName, String password, String nombre, String apellido, String direccion, String email, String biografia, String urlSitio,
			String rutaImg, Date fechaNacimiento){
		Proponente nuevo = new Proponente(nickName, password, nombre, apellido, email, fechaNacimiento, rutaImg, direccion, biografia, urlSitio);
		this.usuarios.put(nickName, nuevo);
	}
	
	public void altaColaborador(String nickName, String password, String nombre, String apellido, String email, String rutaImg, Date fechaNacimiento){
		Colaborador nuevo = new Colaborador(nickName, password, nombre, apellido, email, rutaImg, fechaNacimiento);
		this.usuarios.put(nickName, nuevo);
	}
	
	public DtProponente infoProponente(String nickOrName){
		DtProponente dtproponente = null;
		for (Usuario user : usuarios.values()) 
			if (user.getNickName().equals(nickOrName) || user.getEmail().equals(nickOrName)) {
				Proponente proponente = (Proponente) user;
				dtproponente = new DtProponente(proponente.getNickName(), proponente.getNombre(), proponente.getApellido(), proponente.getEmail(), 
								proponente.getFechaNacimiento(), proponente.getRutaImg(), proponente.getDireccion(), 
								proponente.getBiografia(), proponente.getLinkSitio(), proponente.getPropuestas(), proponente.listarFavoritas());	
			}
		return dtproponente;
	}
	
	public boolean checkPassword(String nickOrName, String password){
		boolean res = false;
		for (Usuario u : this.usuarios.values()) {
			if (u.getNickName().equals(nickOrName) || u.getEmail().equals(nickOrName))
				if (u.getPassword().equals(password)) {
						res = true;
						break;
				}	
		}
		return res;
	}
	
	public DtColaborador infoColaborador(String nickOrName){
		DtColaborador dtcolaborador = null;
		for (Usuario user : usuarios.values()) 
			if (user.getNickName().equals(nickOrName) || user.getEmail().equals(nickOrName)) {
				Colaborador colaborador = (Colaborador) user;
				dtcolaborador = new DtColaborador(colaborador.getNickName(), colaborador.getNombre(), colaborador.getApellido(), colaborador.getEmail(), 
						colaborador.getFechaNacimiento(), colaborador.getRutaImg(), colaborador.getColaboraciones(), colaborador.listarFavoritas());
			}
		return dtcolaborador;
	}

	public static CtrlUsuario getInstance() {
		return instance;
	}

	public Usuario getUsuario(String nickname) {
		return usuarios.get(nickname);
	}
	
	public List<DtUsuario> listarSeguidores(String nickName){
		ArrayList<DtUsuario> res = new ArrayList<DtUsuario>();
		if (!usuarios.isEmpty()) {
			Usuario usr = usuarios.get(nickName);
            Collection<Usuario> users = usr.getSeguidores();
            Object[] objs = users.toArray();
            for (int i = 0; i < users.size(); i++) {
            	if (objs[i] instanceof Proponente)
            		res.add(((Proponente) objs[i]).getInfoProponente());
            	else
            		res.add(((Colaborador) objs[i]).getInfoColaborador());
            }
		}
		return res;
	}
	
	public List<DtUsuario> listarSeguidos(String nickName){
		ArrayList<DtUsuario> res = new ArrayList<DtUsuario>();
		if (!usuarios.isEmpty()) {
			Usuario usr = usuarios.get(nickName);
            Collection<Usuario> users = usr.getSeguidos();
            Object[] objs = users.toArray();
            for (int i = 0; i < users.size(); i++) {
            	if (objs[i] instanceof Proponente)
            		res.add(((Proponente) objs[i]).getInfoProponente());
            	else
            		res.add(((Colaborador) objs[i]).getInfoColaborador());
            }
		}
		return res;
	}
	
	public void agregarPropuestaFavorita(String nickname, String propuesta) {
		
		usuarios.get(nickname).marcarFavorita(propuesta);
	}
	
	public void eliminarPropuestaFavorita(String nickname, String propuesta){
		usuarios.get(nickname).eliminarFavorita(propuesta);
	}
	
	public List<String> listarPropuestasFavoritas(String nickname){
		return usuarios.get(nickname).listarFavoritas();
	}
	public void registrarAcceso(String ip, String url, String browser, String so) {
		
		Acceso acceso = new Acceso(ip, url, browser, so, new Date());
		
		if(accesos.size() == 10000) 
			accesos.remove(accesos.size() - 1);

		accesos.add(0, acceso);
	}

	@Override
	public ArrayList<Acceso> listarAccesos() {
		return accesos;
	}

}
