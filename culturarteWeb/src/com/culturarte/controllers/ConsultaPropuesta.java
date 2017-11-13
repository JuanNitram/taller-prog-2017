package com.culturarte.controllers;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.culturarte.model.EstadoSesion;

import logica.Fabrica;
import dataTypes.DtPropuesta;
import dataTypes.TEstado;
import dataTypes.TRetorno;

/**
 * Servlet implementation class ConsultaPropuesta
 */
@WebServlet("/ConsultaPropuesta")
public class ConsultaPropuesta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaPropuesta() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tituloProp = request.getParameter("propuesta");
		servidor.PublicadorService service =  new servidor.PublicadorService();
		servidor.Publicador port = service.getPublicadorPort();

		
		try {
			
			servidor.DtPropuesta propuesta = port.infoPropuesta(tituloProp);

			request.setAttribute("dtProp", propuesta);

			//System.out.println(Fabrica.getInstance().getICtrlUsuario().esFavorita(Login.getUsuarioLogueado(request).getNickName(), propuesta.getTitulo()));
			
			if (Home.getEstado(request).equals(EstadoSesion.LOGIN_CORRECTO)){
				request.setAttribute("user", Login.getUsuarioLogueado(request).getNickName());
			}else
				request.setAttribute("user", "null");
			
			if(Login.getUsuarioLogueado(request) != null && port.esFavorita(Login.getUsuarioLogueado(request).getNickName(), propuesta.getTitulo())){
				request.setAttribute("esFavorita", "SI");
			}
			else{
				request.setAttribute("esFavorita", "NO");
			}

			request.getRequestDispatcher("/WEB-INF/propuestas/consultaPropuesta.jsp").forward(request, response);
			
		} catch (Exception exception) {
			request.setAttribute("excepcion", true);
			request.setAttribute("excepcionTitulo", "Propuestas");
			request.setAttribute("excepcionMensaje", exception.getMessage());
			request.getRequestDispatcher("/propuestas").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}