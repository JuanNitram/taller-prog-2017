package com.gamebook.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gamebook.model.EstadoSesion;

import Logica.Fabrica;
import dataTypes.DtUsuario;

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
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	
		String nickName = request.getParameter("txNickname");
		String nombre = request.getParameter("txNombre");
		String apellido = request.getParameter("txApellido");
		String email = request.getParameter("txEmail");
		String contrasenia = request.getParameter("txContrasenia");
		String confContrasenia = request.getParameter("txConfContrasenia");
		String fechaNac = request.getParameter("date");    /*2017-10-25*/
		String Tusuario = request.getParameter("TipoUsuario");
		
		String [] fechaSplit = fechaNac.split("-");
		
		System.out.println(fechaNac);
		
		Date d = new Date(Integer.parseInt(fechaSplit[0]),Integer.parseInt(fechaSplit[1]),
				Integer.parseInt(fechaSplit[2]));
		
		if(contrasenia.equals(confContrasenia)){
			if(Tusuario.equals("Proponente")){
				String direccion = request.getParameter("txDireccion");
				String biografia = request.getParameter("txBiografia");
				String linkSitio = request.getParameter("txLinkSitio");
				Fabrica.getInstance().getICtrlUsuario().altaProponente(nickName,contrasenia, nombre, apellido, direccion, email, biografia, linkSitio, "", d);
			}
			else{
				Fabrica.getInstance().getICtrlUsuario().altaColaborador(nickName,contrasenia, nombre, apellido, email, "", d);
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
		// TODO Auto-generated method stub
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}

}
