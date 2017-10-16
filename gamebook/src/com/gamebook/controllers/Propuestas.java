package com.gamebook.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Logica.Fabrica;
import dataTypes.DtPropuesta;
import dataTypes.DtUsuario;

/**
 * Servlet implementation class Propuestas
 */
@WebServlet("/Propuestas")
public class Propuestas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Propuestas() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			ArrayList<DtPropuesta> props = Fabrica.getInstance().getICtrlPropuesta().listarPropuestas();
			if (props != null){
				request.setAttribute("propuestas", props);
				request.getRequestDispatcher("/WEB-INF/propuestas/listar.jsp").forward(request, response);
			}
			else{
				request.getRequestDispatcher("/WEB-INF/index.html").forward(request, response);
			}
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
