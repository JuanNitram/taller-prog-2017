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
    		
    			String propuesta = (String) (request.getParameter("tituloPropGrupo05"));
    			String retorno = request.getParameter("TRetorno");
    			String monto = request.getParameter("txtMonto");
    			String nickName = (String) request.getSession().getAttribute("usuario_logueado");
    	
 
    	
    			TRetorno ret;
    			if (retorno.equals("PORCENTAJE_GANANCIA"))
    				ret = TRetorno.PORCENTAJE_GANANCIA;
    			else if (retorno.equals("ENTRADA_GRATIS"))
    				ret = TRetorno.ENTRADA_GRATIS;
    			else
    				ret = TRetorno.PORCENTAJE_Y_ENTRADAS;
 
    	
    			Fabrica.getInstance().getICtrlPropuesta().infoPropuesta(propuesta);
    			Fabrica.getInstance().getICtrlPropuesta().agregarColaboracion(nickName, Float.parseFloat(monto), ret );
    		}
    	}catch (Exception e){
    		e.printStackTrace();
    	}
    	
    	request.getRequestDispatcher("/WEB-INF/home/iniciar.jsp").forward(request, response);;
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
