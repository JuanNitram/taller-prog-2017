package com.culturarte.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logica.Fabrica;

/**
 * Servlet implementation class SeguimientoUsuario
 */
@WebServlet("/SeguimientoUsuario")
public class SeguimientoUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeguimientoUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seguidor = request.getSession().getAttribute("usuario_logueado").toString();
		String seguido = request.getParameter("seguido");
		Fabrica.getInstance().getICtrlUsuario().elegirSeguidor(seguidor);
		Fabrica.getInstance().getICtrlUsuario().elegirSeguido(seguido);
		
		if(request.getParameter("boton_seguir") == null) {
			Fabrica.getInstance().getICtrlUsuario().seguir();
		} else {
			Fabrica.getInstance().getICtrlUsuario().dejarSeguir();
		}
		
		request.getRequestDispatcher("/consultaUsuario?usuario="+seguido).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
