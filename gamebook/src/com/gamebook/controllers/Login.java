package com.gamebook.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gamebook.exceptions.UsuarioNoEncontrado;
import com.gamebook.model.EstadoSesion;
import Logica.Fabrica;
import dataTypes.DtColaborador;
import dataTypes.DtProponente;
import dataTypes.DtUsuario;
import sun.rmi.runtime.Log;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
    

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        HttpSession objSesion = request.getSession();
       
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        EstadoSesion nuevoEstado;
        
       System.out.println(login + " - " + password);
        
       
		// chequea contraseña
		try {
			
			DtUsuario user;
			ArrayList<DtUsuario> arregloProponentes = Fabrica.getInstance().getICtrlUsuario().listarUsuarios();	
			int i =0;
			while (i < arregloProponentes.size() && !arregloProponentes.get(i).getNickName().equals(login))
				i++;
			if (Fabrica.getInstance().getICtrlUsuario().existeUsuario(login, null)){
				user = arregloProponentes.get(i);
				if(Fabrica.getInstance().getICtrlUsuario().checkPassword(login, password)){
					nuevoEstado = EstadoSesion.LOGIN_CORRECTO;
					request.getSession().setAttribute("usuario_logueado", user.getNickName());
					System.out.println(user.getEmail());
				}else nuevoEstado = EstadoSesion.LOGIN_INCORRECTO;

			}else {
					nuevoEstado = EstadoSesion.LOGIN_INCORRECTO;
					System.out.println("error en la contrasenia del proponente");
			}

			
			} catch(Exception ex){
				
				nuevoEstado = EstadoSesion.LOGIN_INCORRECTO;
				System.out.println("Estoy en la exception");
			}
        
        objSesion.setAttribute("estado_sesion", nuevoEstado);
		
		// redirige a la página principal para que luego rediriga a la página
		// que corresponde
        RequestDispatcher dispatcher = request.getRequestDispatcher("/home");
        dispatcher.forward(request, response);
    } 
    
	/**
	 * Devuelve el usuario logueado
	 * @param request
	 * @return
	 * @throws UsuarioNoEncontrado 
	 */
	static public DtUsuario getUsuarioLogueado(HttpServletRequest request){
		DtUsuario user = null;
		try{
			if (Fabrica.getInstance().getICtrlUsuario().esProponente((String) request.getSession().getAttribute("usuario_logueado")))
				user = Fabrica.getInstance().getICtrlUsuario().infoProponente((String) request.getSession().getAttribute("usuario_logueado"));
			else 
				user = Fabrica.getInstance().getICtrlUsuario().infoColaborador((String) request.getSession().getAttribute("usuario_logueado"));
		
		}catch(Exception e){
			System.out.println("No se pudo obtener el usuario logeado");
		}
		return user;
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
	}

}
