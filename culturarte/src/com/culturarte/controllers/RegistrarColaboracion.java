package com.culturarte.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logica.Fabrica;
import dataTypes.DtPropuesta;
import dataTypes.TRetorno;

/**
 * Servlet implementation class RegistrarColaboracion
 */
@WebServlet("/RegistrarColaboracion")
public class RegistrarColaboracion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarColaboracion() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	
    	try{
    		
    		if(!Fabrica.getInstance().getICtrlUsuario().esProponente((String)(request.getSession().getAttribute("usuario_logueado")))){  
    		
    			String propuesta = (String) (request.getAttribute("propuesta"));
    			String retorno = request.getParameter("selectRetorno");
    			String monto = request.getParameter("txtMonto");
    			String nickName = (String) request.getSession().getAttribute("usuario_logueado");
    	
    			System.out.println((request.getAttribute("propuesta") == null)?"Es re nullll":"Propuesta no es null");
    	
    			TRetorno ret;
    			if (retorno.equals("Porcentaje de ganancia"))
    				ret = TRetorno.PORCENTAJE_GANANCIA;
    			else if (retorno.equals("Entradas gratis"))
    				ret = TRetorno.ENTRADA_GRATIS;
    			else
    				ret = TRetorno.PORCENTAJE_Y_ENTRADAS;
 
    			if(propuesta != null) {
	    			Fabrica.getInstance().getICtrlPropuesta().infoPropuesta(propuesta);
	    			Fabrica.getInstance().getICtrlPropuesta().agregarColaboracion(nickName, Float.parseFloat(monto), ret );
    			} else 
    				System.out.println("NULLLLLLLLLLLLLLLL");
    		}
    	}catch (Exception e){
    		e.printStackTrace();
    	}
    	request.getRequestDispatcher("/propuestas").forward(request, response);
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
