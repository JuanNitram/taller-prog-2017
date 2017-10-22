package com.culturarte.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logica.Fabrica;
import dataTypes.DtColaborador;
import dataTypes.DtUsuario;

/**
 * Servlet implementation class ConsultaUsuario
 */
@WebServlet("/ConsultaUsuario")
public class ConsultaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		request.setAttribute("nombre", usuario);
		DtUsuario dtUsuario = null;
		for (DtUsuario dtU: Fabrica.getInstance().getICtrlUsuario().listarUsuarios())
			if (dtU.getNickName().equals(usuario)) dtUsuario = dtU;
		if(dtUsuario != null) {
			request.setAttribute("usr", dtUsuario);
			request.getRequestDispatcher("/WEB-INF/usuarios/consultaUsuario.jsp").forward(request, response);
		} else {
			request.setAttribute("excepcion", true);
			request.setAttribute("excepcionTitulo", "Usuarios");
			request.setAttribute("excepcionMensaje", "No existe el usuario " + usuario + " en el sistema.");
			request.getRequestDispatcher("/home").forward(request, response);
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