package com.culturarte.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Logica.Fabrica;
import dataTypes.DtUsuario;

/**
 * Servlet implementation class Usuarios
 */
public class Usuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Usuarios() {
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
		String usuario = request.getParameter("usuario");
			
		if (usuario == null) {
			
			//Date d = new Date();
			//Fabrica.getInstance().getICtrlUsuario().altaColaborador("Juan", "Juan", "Juan", "Juan", "Juan", "", d);
			
			// no se seteó el usuario (lista todos los usuarios)
			ArrayList<DtUsuario> usrs = Fabrica.getInstance().getICtrlUsuario().listarUsuarios();
			if (usrs.size() > 0){
				request.setAttribute("usuarios", usrs);
			
				request.getRequestDispatcher("/WEB-INF/usuarios/listar.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("/WEB-INF/errorPages/404.jsp").forward(request, response);
			}	
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
