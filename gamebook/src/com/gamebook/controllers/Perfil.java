package com.gamebook.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gamebook.exceptions.UsuarioNoEncontrado;
import com.gamebook.model.EstadoSesion;

import Logica.Fabrica;
import dataTypes.DtColaborador;
import dataTypes.DtProponente;
import dataTypes.DtUsuario;

/**
 * Servlet implementation class Perfil
 */
public class Perfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Perfil() {
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
  
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DtUsuario user;
		try {
			if(!Fabrica.getInstance().getICtrlUsuario().esProponente((String) request.getSession().getAttribute("usuario_logueado")))
				user = (DtUsuario) Fabrica.getInstance().getICtrlUsuario().infoColaborador((String) request.getSession().getAttribute("usuario_logueado"));
			else 
				user = (DtUsuario) Fabrica.getInstance().getICtrlUsuario().infoProponente((String) request.getSession().getAttribute("usuario_logueado"));
			request.setAttribute("usuario", user);
			request.getRequestDispatcher("/WEB-INF/usuarios/perfil.jsp").forward(request, response);
		} catch(Exception ex){
			// no existe el usuario, se trata como deslogueado
			System.out.println("Es porque estoy aca");
			request.getSession().setAttribute("estado_sesion", EstadoSesion.NO_LOGIN);
			request.getRequestDispatcher("/home").forward(request, response);
		}
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
