package com.culturarte.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.culturarte.model.EstadoSesion;

/**
 * Servlet implementation class Favorito
 */
@WebServlet("/Favorito")
public class Favorito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Favorito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usuario = Login.getUsuarioLogueado(request).getNickName();
			
		servidor.PublicadorService service =  new servidor.PublicadorService();
		servidor.Publicador port = service.getPublicadorPort();
		String propuesta = (String)request.getParameter("tituloPropu");
		System.out.println("AGREGAR FAVORITO CABEZA" + ((String)request.getParameter("action")));
	
			
			if(((String)request.getParameter("action")).equals("agregar")){
				port.agregarPropuestaFavorita(usuario, propuesta);
				System.out.println("Voy a agregar a favorito");
			}else{
				port.eliminarUsuarioFavorito(usuario, propuesta);
				System.out.println("Voy a quitar a favorito");
			}
		}
		
	
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
