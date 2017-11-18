package com.culturarte.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servidor.PublicadorService;

/**
 * Servlet implementation class BajaProp
 */
@WebServlet("/BajaProp")
public class BajaProp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PublicadorService servicios = new PublicadorService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BajaProp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nickName = request.getParameter("nickName");
		servicios.getPublicadorPort().bajaProponente(nickName);
		 HttpSession objSesion = request.getSession();
		 
		 objSesion.setAttribute("usuario_logueado", null);
		 objSesion.setAttribute("estado_sesion", null);
		request.getRequestDispatcher("/home").forward(request, response);
	}

}
