package com.gamebook.model;

import java.util.GregorianCalendar;

/**
 * Almacena la informacion de un usuario
 * @author Igui
 */
public class Usuario {

	public Usuario(String email, String password, String nombre, GregorianCalendar nacimiento) {
		this.email = email;
		this.password = password;
		this.nombre = nombre;
		this.nacimiento = nacimiento;
	}
		

	protected String email;

	/**
	 * Get the value of email
	 *
	 * @return the value of email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set the value of email
	 *
	 * @param email new value of email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	protected String password;

	/**
	 * Get the value of password
	 *
	 * @return the value of password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set the value of password
	 *
	 * @param password new value of password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	protected String nombre;

	/**
	 * Get the value of nombre
	 *
	 * @return the value of nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Set the value of nombre
	 *
	 * @param nombre new value of nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	protected GregorianCalendar nacimiento;

	/**
	 * Get the value of nacimiento
	 *
	 * @return the value of nacimiento
	 */
	public GregorianCalendar getNacimiento() {
		return nacimiento;
	}

	/**
	 * Set the value of nacimiento
	 *
	 * @param nacimiento new value of nacimiento
	 */
	public void setNacimiento(GregorianCalendar nacimiento) {
		this.nacimiento = nacimiento;
	}
}
