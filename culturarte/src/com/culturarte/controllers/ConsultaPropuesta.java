package com.culturarte.controllers;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tituloProp = request.getParameter("propuesta");
		try {
			DtPropuesta propuesta = Fabrica.getInstance().getICtrlPropuesta().infoPropuesta(tituloProp);
			request.setAttribute("dtProp", propuesta);
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}