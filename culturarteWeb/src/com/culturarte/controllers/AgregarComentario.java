package com.culturarte.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logica.Fabrica;

/**
 * Servlet implementation class AgregarComentario
 */
@WebServlet("/AgregarComentario")
public class AgregarComentario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarComentario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	try{
			HttpSession session = request.getSession();
			String usr = (String)session.getAttribute("usuario_logueado");
			String propuesta = (String)request.getParameter("tPropuesta");
			String comentario = (String)request.getParameter("comentario");
			System.out.println(" Usuario : " + usr + " Propuesta: " + propuesta + " Comentario: " + comentario);
			Fabrica.getInstance().getICtrlPropuesta().agregarComentario(usr, propuesta, comentario);
			request.getRequestDispatcher("/propuestas").forward(request, response);
    	}catch(Exception e){}
    }
    
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
