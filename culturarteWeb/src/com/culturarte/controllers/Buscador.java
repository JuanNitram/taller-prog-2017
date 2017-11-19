package com.culturarte.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Buscador
 */
@WebServlet("/Buscador")
public class Buscador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Buscador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
				servidor.PublicadorService service =  new servidor.PublicadorService();
				servidor.Publicador port = service.getPublicadorPort();

		
	        	response.setContentType("text/html;charset=UTF-8");
	        	String propstr = "";
	        	
	        	servidor.DataList Dt = port.listarPropuestas();
				List<servidor.DtPropuesta> props = (ArrayList) Dt.getDatos();
				
	        	if (props.size() > 0){
	        	    String[] propuestasString = new String[props.size()];
	        	  for(int iter = 0; iter < props.size(); iter++){
	        	    propuestasString[iter]=(props.get(iter).getTitulo());
	        	  }
	        	    StringBuffer sb = new StringBuffer();
	        	     for(int i=0; i<propuestasString.length; i++){
	        	         sb.append(propuestasString[i]);
	        	         if(i+1 < propuestasString.length){
	        	             sb.append(",");
	        	         }
	        	     }
	        	     propstr = sb.toString();
	        	  }
	            /* TODO output your response here.*/
	            response.getWriter().write(propstr);
	    	
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
