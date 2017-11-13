package com.culturarte.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataTypes.DtUsuario;
import logica.Fabrica;

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
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuario = request.getParameter("usuario");
		request.setAttribute("nombre", usuario);
		servidor.DtUsuario dtUsuario = null;

		servidor.PublicadorService service =  new servidor.PublicadorService();
		servidor.Publicador port = service.getPublicadorPort();
		
		servidor.DataList dtUs = port.listarUsuarios();
		List<servidor.DtUsuario> usuarios = (ArrayList) dtUs.getDatos();
		
		for (servidor.DtUsuario dtU: usuarios)
			if (dtU.getNickName().equals(usuario)) dtUsuario = dtU;
		if(dtUsuario != null) {
			if(request.getSession().getAttribute("usuario_logueado") != null && !request.getSession().getAttribute("usuario_logueado").equals(usuario)) {
				ArrayList<DtUsuario> seguidores = (ArrayList<DtUsuario>) Fabrica.getInstance().getICtrlUsuario().listarSeguidores(dtUsuario.getNickName());
				request.setAttribute("siguiendo", false);
				for(int i = 0; i < seguidores.size(); i++)
					if(seguidores.get(i).getNickName().equals(request.getSession().getAttribute("usuario_logueado"))) {
						request.setAttribute("siguiendo", true);
						break;
					}
			}
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
		doGet(request, response);
	}

}