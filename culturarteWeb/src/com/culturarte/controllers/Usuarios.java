package com.culturarte.controllers;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servidor.DtUsuario;

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
        SortedMap<Integer, servidor.DtUsuario> seguidores = new TreeMap<Integer,servidor.DtUsuario>(java.util.Collections.reverseOrder());
		if (usuario == null) {
			servidor.PublicadorService service =  new servidor.PublicadorService();
			servidor.Publicador port = service.getPublicadorPort();
			servidor.DataList dtUs = port.listarUsuarios();
			List<servidor.DtUsuario> usuarios = (ArrayList) dtUs.getDatos();
			if (usuarios.size() > 0){
				for(DtUsuario user : usuarios){
					seguidores.put(port.listarSeguidores(user.getNickName()).getDatos().size(),user);
				}
				request.setAttribute("usuarios", usuarios);
				request.setAttribute("seguidores", seguidores);
			
				request.getRequestDispatcher("/WEB-INF/usuarios/listar.jsp").forward(request, response);
			}
			else {
				request.setAttribute("excepcion", true);
				request.setAttribute("excepcionTitulo", "Usuarios");
				request.setAttribute("excepcionMensaje", "No existen usuarios registrados en el servidor.");	
				request.getRequestDispatcher("/home").forward(request, response);
			}	
		}
	}
	//primero que nada hacemos el runnable no? o sea el runnable del workstation
	//ok
	//entonces mandale play con el wsimport
	
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