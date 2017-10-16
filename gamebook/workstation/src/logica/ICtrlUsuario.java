package Logica;

import java.util.ArrayList;
import java.util.Date;

import Logica.clases.Propuesta;
import Logica.clases.Usuario;
import dataTypes.DtColaborador;
import dataTypes.DtProponente;
import dataTypes.DtUsuario;

public interface ICtrlUsuario {
	
	ArrayList<DtUsuario> listarUsuarios();
	
	ArrayList<DtProponente>  listarProponentes();
	
	ArrayList<DtColaborador> listarColaboradores();
	
	void elegirSeguidor(String nickName);
	 
	void elegirSeguido(String nickName);
	
	void dejarSeguir();
	
	void seguir();
	
	boolean esProponente(String nickname);
	
	boolean checkPassword(String nickname, String password);
	
	void altaProponente(String nickName,String password,String nombre, String apellido, String direccion, String email, String biografia, String urlSitio,
			String rutaImg, Date fechaNacimiento);
	
	void altaColaborador(String nickName,String password, String nombre, String apellido,String email, String rutaImg, Date fechaNacimiento);
	
	DtProponente infoProponente(String nickName);
	
	DtColaborador infoColaborador(String nickName);
	
	ArrayList<DtUsuario> listarSeguidores(String nickName);
	
	ArrayList<DtUsuario> listarSeguidos(String nickName);
	
	boolean existeUsuario(String nickName, String email);
	
	void agregarFavorita(String nickname, Propuesta propFavorita);
}
