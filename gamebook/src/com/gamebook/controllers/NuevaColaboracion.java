package com.gamebook.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Logica.Fabrica;
import dataTypes.DtPropuesta;

/**
 * Servlet implementation class NuevaColaboracion
 */
@WebServlet("/NuevaColaboracion")
public class NuevaColaboracion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevaColaboracion() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	String propuesta = request.getParameter("propuesta");
    	DtPropuesta dtP = null;
    	try{
    		dtP = Fabrica.getInstance().getICtrlPropuesta().infoPropuesta(propuesta);
    	}catch(Exception e){}
    	
    	/*request.setAttribute("nickProponente", dtP.getNickProponente());
    	request.setAttribute("titulo",dtP.getTitulo());
    	request.setAttribute("descripcion", dtP.getDescripcion());
    	request.setAttribute("lugar", dtP.getLugar());
    	request.setAttribute("montoReunir", dtP.getMontoReunir());
    	request.setAttribute("precioEntrada", dtP.getPrecioEntrada());
    	request.setAttribute("tipoRetorno", dtP.getTipoRetorno());
    	request.setAttribute("lugar", dtP.getLugar());
    	request.setAttribute("lugar", dtP.getLugar());*/
    	request.setAttribute("propuesta", dtP);
    	request.getRequestDispatcher("/WEB-INF/colaboracion/nuevaColaboracion.jsp").forward(request, response);
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
