package com.culturarte.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.culturarte.model.EstadoSesion;

import logica.Fabrica;

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
	
			if (request.getSession().getAttribute("estado_sesion") == EstadoSesion.LOGIN_CORRECTO){
				String propuesta =request.getParameter("tituloProp");
				if (request.getParameter("esFavorita").equals("NO"))
					Fabrica.getInstance().getICtrlPropuesta().agregarUsuarioFavorito(Login.getUsuarioLogueado(request).getNickName(), propuesta);
				else if (request.getParameter("esFavorita").equals("SI"))
					Fabrica.getInstance().getICtrlPropuesta().eliminarUsuarioFavorito(Login.getUsuarioLogueado(request).getNickName(), propuesta);	
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
