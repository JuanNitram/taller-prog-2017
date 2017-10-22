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
    		
    			String propuesta = (String) (request.getParameter("tPropuesta"));
    			String retorno = request.getParameter("selectRetorno");
    			String monto = request.getParameter("txtMonto");
    			String nickName = (String) request.getSession().getAttribute("usuario_logueado");
    	    	
    			TRetorno ret = null;
    			if (retorno.equals("Porcentaje de ganancia"))
    				ret = TRetorno.PORCENTAJE_GANANCIA;
    			else if (retorno.equals("Entradas gratis"))
    				ret = TRetorno.ENTRADA_GRATIS;
 
	    			Fabrica.getInstance().getICtrlPropuesta().infoPropuesta(propuesta);
	    			Fabrica.getInstance().getICtrlPropuesta().agregarColaboracion(nickName, Float.parseFloat(monto), ret );
    		}
    	}catch (Exception e){
    		request.setAttribute("excepcion", true);
			request.setAttribute("excepcionTitulo", "Colaboración");
			request.setAttribute("excepcionMensaje", "No se puede realizar esta colaboración.");
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
