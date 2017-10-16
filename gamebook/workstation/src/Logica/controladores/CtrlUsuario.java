package Logica.controladores;

import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import Logica.ICtrlUsuario;
import Logica.clases.Colaborador;
import Logica.clases.Proponente;
import Logica.clases.Usuario;
import dataTypes.DtColaborador;
import dataTypes.DtProponente;
import dataTypes.DtUsuario;

public class CtrlUsuario implements ICtrlUsuario {
	
	private static final CtrlUsuario instance = new CtrlUsuario();
	private Map<String,Usuario> usuarios;
	private Usuario UsSeguidor;
	private Usuario UsSeguido;
	
	private CtrlUsuario() { 
		this.usuarios = new HashMap<String,Usuario>();
	}
	
	public ArrayList<DtUsuario> listarUsuarios(){
		ArrayList<DtUsuario> res = new ArrayList<DtUsuario>();
		if (!this.usuarios.isEmpty()) {
            Collection<Usuario> users = this.usuarios.values();
            Object[] objs = users.toArray();
            for (int i = 0; i < users.size(); i++) {
            	if(objs[i] instanceof Proponente)
            		res.add(((Proponente) objs[i]).getInfoProponente());
            	else
            		res.add(((Colaborador) objs[i]).getInfoColaborador());
            }
		}
        return res;
	}
	
	public boolean esProponente(String nickname){
			return (usuarios.get(nickname) instanceof Proponente);
	}
	
	public ArrayList<DtProponente>  listarProponentes(){
		ArrayList<DtProponente> res = new ArrayList<DtProponente>();
		if (!this.usuarios.isEmpty()) { 
            Collection<Usuario> colabs = this.usuarios.values();
            Object[] objs = colabs.toArray();
            for (int i = 0; i < colabs.size(); i++) {
            	if(objs[i] instanceof Proponente)
            		res.add(((Proponente) objs[i]).getInfoProponente());
            }
		}
        return res;
	}
	
	public ArrayList<DtColaborador> listarColaboradores(){
		ArrayList<DtColaborador> res = new ArrayList<DtColaborador>();
		if (!usuarios.isEmpty()) {
            Collection<Usuario> colabs = usuarios.values();
            Object[] objs = colabs.toArray();
            for (int i = 0; i < colabs.size(); i++) {
            	if(objs[i] instanceof Colaborador)
            		res.add(((Colaborador) objs[i]).getInfoColaborador());
            }
		}
        return res;
	}
	
	public void elegirSeguidor(String nickName){
		this.UsSeguidor= usuarios.get(nickName);
	}
	
	public void elegirSeguido(String nickName){
		this.UsSeguido= usuarios.get(nickName);
	}
	
	public void dejarSeguir(){
		this.UsSeguido.eraseSeguidor(this.UsSeguidor);
		this.UsSeguidor.eraseSeguido(this.UsSeguido);
	}
	
	public void seguir(){
		this.UsSeguido.addSeguidor(this.UsSeguidor);
		this.UsSeguidor.addSeguido(this.UsSeguido);
	}
	
	/*Devuelve true si existe el usuario*/
	public boolean existeUsuario(String nickName, String email){ 
		boolean res = false;
		
		if(this.usuarios.get(nickName) != null)
			res = true;
		else{
			Iterator it = this.usuarios.entrySet().iterator();
			Map.Entry<String,Usuario> e;
		
			while (it.hasNext() && !res) {
		    	e = (Map.Entry<String, Usuario>)it.next();
		    	Usuario u = e.getValue();
		    	if (u.getEmail() == email)
		    		res = true;
			}
		}
		return res;
	}
	
	public void altaProponente(String nickName,String password,String nombre, String apellido, String direccion, String email, String biografia, String urlSitio,
			String rutaImg, Date fechaNacimiento){
		Proponente nuevo = new Proponente(nickName,password,nombre,apellido,email, fechaNacimiento, rutaImg, direccion, biografia, urlSitio);
		this.usuarios.put(nickName, nuevo);
	}
	
	public void altaColaborador(String nickName,String password, String nombre, String apellido,String email, String rutaImg, Date fechaNacimiento){
		Colaborador nuevo = new Colaborador(nickName,password, nombre, apellido, email, rutaImg, fechaNacimiento);
		this.usuarios.put(nickName, nuevo);
	}
	
	public DtProponente infoProponente(String nickName){
		DtProponente dtproponente = null;
		Iterator<Map.Entry<String, Usuario>> it = usuarios.entrySet().iterator();
		while (it.hasNext()){
			Map.Entry<String, Usuario> par = it.next();
			String nickNamearr = par.getKey();
			if (nickNamearr == nickName){
				Proponente proponente = (Proponente)par.getValue();
				if (proponente != null){
					dtproponente = new DtProponente(proponente.getNickName(), proponente.getNombre(), proponente.getApellido(), proponente.getEmail(), proponente.getFechaNacimiento(), proponente.getRutaImg(), proponente.getDireccion(), proponente.getBiografia(), proponente.getLinkSitio());
				
				}
			}
		}
		return dtproponente;
	}
	
	public boolean checkPassword(String nickname, String password){
		return usuarios.get(nickname).getPassword().equals(password);
	}
	
	public DtColaborador infoColaborador(String nickName){
		DtColaborador dtcolaborador = null;
		Iterator<Map.Entry<String, Usuario>> it = usuarios.entrySet().iterator();
		while (it.hasNext()){
			Map.Entry<String, Usuario> par = it.next();
			String nickNamearr = par.getKey();
			if (nickNamearr == nickName){
				Colaborador colaborador = (Colaborador)par.getValue();
				if (colaborador != null){
					dtcolaborador = new DtColaborador(colaborador.getNickName(), colaborador.getNombre(), colaborador.getApellido(), colaborador.getEmail(), colaborador.getFechaNacimiento(), colaborador.getRutaImg());
				
				}
			}
		}
		return dtcolaborador;
	}

	public static CtrlUsuario getInstance() {
		return instance;
	}

	public Usuario getUsuario(String nickname) {
		return usuarios.get(nickname);
	}
	
	public ArrayList<DtUsuario> listarSeguidores(String nickName){
		ArrayList<DtUsuario> res = new ArrayList<DtUsuario>();
		if (!usuarios.isEmpty()) {
			Usuario u = usuarios.get(nickName);
            Collection<Usuario> users = u.getSeguidores();
            Object[] objs = users.toArray();
            for (int i = 0; i < users.size(); i++) {
            	if(objs[i] instanceof Proponente)
            		res.add(((Proponente) objs[i]).getInfoProponente());
            	else
            		res.add(((Colaborador) objs[i]).getInfoColaborador());
            }
		}
		return res;
	}
	
	public ArrayList<DtUsuario> listarSeguidos(String nickName){
		ArrayList<DtUsuario> res = new ArrayList<DtUsuario>();
		if (!usuarios.isEmpty()) {
			Usuario u = usuarios.get(nickName);
            Collection<Usuario> users = u.getSeguidos();
            Object[] objs = users.toArray();
            for (int i = 0; i < users.size(); i++) {
            	if(objs[i] instanceof Proponente)
            		res.add(((Proponente) objs[i]).getInfoProponente());
            	else
            		res.add(((Colaborador) objs[i]).getInfoColaborador());
            }
		}
		return res;
	}
	
	void agregarFavorita(String nickname, Propuesta propFavorita) {
		usuarios.get(nickname).marcarFavorita(propFavorita);
	}
	
}
