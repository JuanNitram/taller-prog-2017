package com.gamebook.controllers;

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
    
    public void CargaDeDatos(){
    	if (datos == null)
    		datos= new Datos();
    }

    protected void processRequest(HttpServletRequest request,
    		HttpServletResponse response) throws ServletException, IOException {
    	CargaDeDatos();
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
