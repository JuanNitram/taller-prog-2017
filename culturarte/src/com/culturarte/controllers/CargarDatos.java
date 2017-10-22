package com.culturarte.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Logica.Datos;

/**
 * Servlet implementation class CargarDatos
 */
@WebServlet("/CargarDatos")
public class CargarDatos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Datos datos;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CargarDatos() {
    	 super();
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request,
    		HttpServletResponse response) throws ServletException, IOException {
    	if (datos == null) {
    		datos= new Datos();
			request.setAttribute("excepcionMensaje", "Los datos de prueba se cargaron correctamente");
    	} else
			request.setAttribute("excepcionMensaje", "Los datos de prueba ya estaban cargados.");
    	request.setAttribute("excepcion", true);
		request.setAttribute("excepcionTitulo", "Carga de datos");
		request.getRequestDispatcher("/home").forward(request, response);
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
