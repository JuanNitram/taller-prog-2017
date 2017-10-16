/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamebook.model;

import com.gamebook.exceptions.UsuarioNoEncontrado;
import java.text.Normalizer;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

/**
 *
 * @author Igui
 */
public class GestorUsuario {
	private static GestorUsuario instancia;
	
	// mapeo email -> usuario
	private Map<String, Usuario> usuarios;
	
	/**
	 * Da la instancia del singleton
	 * @return 
	 */
	public static GestorUsuario getInstance()
	{
		if(instancia == null)
			instancia = new GestorUsuario();
		return instancia;
	}
	
	/**
	 * Crea un conjunto de usuarios aleatorios
	 */
	private GestorUsuario()
	{
		String [] nombres  = {
			"Alberto",
			"Alejandro",
			"Damián",
			"Matías",
			"Eduardo",
			"Florencia",
			"Lucía",
			"Gabriela",
			"Leonardo",
			"Fabiana",
			"Andrea",
			"Victoria"
		};
		
		String [] apellidos = {
			"Fernandez",
			"Gonzalez",
			"Rabatto",
			"Pitta",
			"Méndez",
			"Jobs",
			"Di María",
			"Otero",
			"Garbarino",
			"Mosca",
			"Díaz",
			"Dodero",
			"Valoz",
			"Valdéz",
			"Da Silva",
			"Cabrera",
			"Dominguez",
			"Gómez",
			"Ferreira"
		};
		
		int nUsuaurios = 25;
		Random random = new Random();
		long minNacimiento = new GregorianCalendar(1980, 1, 1).getTimeInMillis();
		long nacimientoSpan = 60*60*24*365*10;
		
		usuarios = new HashMap<String, Usuario>();
		
		for(int i = 0; i < nUsuaurios; ++i){
			String nombre = nombres[random.nextInt(nombres.length)];
			String apellido = apellidos[random.nextInt(apellidos.length)];
			String nombreCompleto = nombre + " " + apellido;
			
			String email = (nombre.substring(0, 1) + apellido).toLowerCase() +
					"@mail.com";
			email = email.replace(" ", "");
			
			String temp = Normalizer.normalize(email, Normalizer.Form.NFD);
			Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
			email = pattern.matcher(temp).replaceAll("");
			
			String password = nombre.toLowerCase();
			
			GregorianCalendar nacimiento = new GregorianCalendar();
			nacimiento.setTimeInMillis(
					minNacimiento + random.nextLong() % nacimientoSpan
					);
			
			Usuario usuario = new Usuario(email,
					password, nombreCompleto, nacimiento);
			
			usuarios.put(email, usuario);
		}
		
		// pone un usuario fijo conocido para loguearse
		usuarios.put("tprog@tprog.com", 
				new Usuario(
					"tprog@tprog.com",
					"manda",
					"Taller de Programación",
					new GregorianCalendar(1990, 6, 3)
				)
			);
	}
	
	/**
	 * Devuelven los usuarios
	 * @return 
	 */
	public Collection<Usuario> getUsuarios()
	{
		return usuarios.values();
	}
	
	/**
	 * Busca un usuario
	 * @param email
	 * @return
	 * @throws Exception 
	 */
	public Usuario buscarUsuario(String email) throws UsuarioNoEncontrado{
		Usuario res = usuarios.get(email);
		if(res == null)
			throw new UsuarioNoEncontrado(email);
		return res;
	}

}
