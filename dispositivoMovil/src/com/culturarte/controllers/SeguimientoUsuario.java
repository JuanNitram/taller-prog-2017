package com.culturarte.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataTypes.DtProponente;
import dataTypes.DtUsuario;
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
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nickSeguidor = request.getSession().getAttribute("usuario_logueado").toString();
		DtUsuario dtU = (DtUsuario)request.getSession().getAttribute("usr");
		String seguido = dtU.getNickName();
		Fabrica.getInstance().getICtrlUsuario().elegirSeguidor(nickSeguidor);
		Fabrica.getInstance().getICtrlUsuario().elegirSeguido(seguido);
		
		if(request.getParameter("valorBoton").equals("Seguir"))
			Fabrica.getInstance().getICtrlUsuario().seguir();
		else
			Fabrica.getInstance().getICtrlUsuario().dejarSeguir();
		
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		
		out.println("<span style=\"text-align: center\"><h3>Seguidores</h3></span>");
		
		ArrayList<DtUsuario> listaSeguidores = (ArrayList<DtUsuario>)Fabrica.getInstance().getICtrlUsuario().listarSeguidores(dtU.getNickName());
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
