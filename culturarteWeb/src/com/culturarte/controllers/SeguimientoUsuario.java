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

import servidor.DtProponente;
import servidor.DtUsuario;
import servidor.PublicadorService;

/**
 * Servlet implementation class SeguimientoUsuario
 */
@WebServlet("/SeguimientoUsuario")
public class SeguimientoUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PublicadorService servicios = new PublicadorService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeguimientoUsuario() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nickSeguidor = request.getSession().getAttribute("usuario_logueado").toString();
		DtUsuario dtU = (DtUsuario)request.getSession().getAttribute("usr");
		String seguido = dtU.getNickName();
		servicios.getPublicadorPort().elegirSeguidor(nickSeguidor);
		servicios.getPublicadorPort().elegirSeguido(seguido);
		
		if(request.getParameter("valorBoton").equals("Seguir"))
			servicios.getPublicadorPort().seguir();
		else
			servicios.getPublicadorPort().dejarSeguir();
		
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		
		out.println("<span style=\"text-align: center\"><h3>Seguidores</h3></span>");
		
		List<DtUsuario> listaSeguidores = (ArrayList)servicios.getPublicadorPort().listarSeguidores(dtU.getNickName()).getDatos();
		if (listaSeguidores.size() > 0) {
			for (int i = 0; i < listaSeguidores.size(); i++) {
				DtUsuario seguidor = listaSeguidores.get(i);
				out.println("<a href=\"consultaUsuario?usuario=" + seguidor.getNickName() + "\">");
				out.println(seguidor.getNombre() + " " + seguidor.getApellido() + " (" + seguidor.getNickName() + ")");
				out.println("</a>");
				out.println((seguidor instanceof DtProponente)?" - Proponente":" - Colaborador");
				out.println("<br>");
			}
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
