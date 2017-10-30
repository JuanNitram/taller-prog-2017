package com.culturarte.controllers;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import logica.Fabrica;

/**
 * Servlet implementation class AltaUsuario
 */
@WebServlet("/AltaUsuario")
public class AltaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaUsuario() {
        super();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	
		String nickName = request.getParameter("txNickname");
		String nombre = request.getParameter("txNombre");
		String apellido = request.getParameter("txApellido");
		String email = request.getParameter("txEmail");
		String contrasenia = request.getParameter("password");
		String confContrasenia = request.getParameter("confirm_password");
		String fechaNac = request.getParameter("date");    /*2017-10-25*/
		String Tusuario = request.getParameter("TipoUsuario");
		System.out.println(nombre);
		System.out.println(apellido);
		System.out.println(email);
		System.out.println(contrasenia);
		System.out.println(confContrasenia);
		System.out.println(Tusuario);
		System.out.println(nickName);
		
		String [] fechaSplit = fechaNac.split("/");
		System.out.println(fechaNac);
		
		Date variableFecha = new Date(Integer.parseInt(fechaSplit[2]) - 1900, Integer.parseInt(fechaSplit[1]), Integer.parseInt(fechaSplit[0]));
		
		if (contrasenia.equals(confContrasenia)){
			if (Tusuario.equals("Proponente")){
				String direccion = request.getParameter("txDireccion");
				String biografia = request.getParameter("txBiografia");
				String linkSitio = request.getParameter("txLinkSitio");
				System.out.println(direccion);
				System.out.println(biografia);
				System.out.println(linkSitio);
				Fabrica.getInstance().getICtrlUsuario().altaProponente(nickName, contrasenia, nombre, apellido, direccion, email, biografia, linkSitio, "", variableFecha);
			}
			else{
				Fabrica.getInstance().getICtrlUsuario().altaColaborador(nickName, contrasenia, nombre, apellido, email, "", variableFecha);
			}
			
			request.getRequestDispatcher("/WEB-INF/home/iniciar.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/registro/registroErroneo.jsp").include(request, response);
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
