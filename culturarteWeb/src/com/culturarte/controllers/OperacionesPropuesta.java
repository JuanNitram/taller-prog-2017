package com.culturarte.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servidor.DtColaboracion;
import servidor.DtColaborador;
import servidor.DtComentario;
import servidor.PublicadorService;
import servidor.TRetorno;

/**
 * Servlet implementation class OperacionesPropuesta
 */
@WebServlet("/OperacionesPropuesta")
public class OperacionesPropuesta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PublicadorService servicios = new PublicadorService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OperacionesPropuesta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	/*
    	try{
			HttpSession session = request.getSession();
			String usr = (String)session.getAttribute("usuario_logueado");
			String propuesta = (String)request.getParameter("tPropuesta");
			System.out.println(" Usuario : " + usr + " Propuesta: " + propuesta + " Comentario: " + comentario);
			request.getRequestDispatcher("/propuestas").forward(request, response);
    	}catch(Exception e){}
    	*/
    	if(request.getParameter("action").equals("agregarComentario")) {
    		HttpSession session = request.getSession();
			String usr = (String)session.getAttribute("usuario_logueado");
			String propuesta = (String)request.getParameter("tituloProp");
			String comentario = (String)request.getParameter("comentario");
			servicios.getPublicadorPort().agregarComentario(usr, propuesta, comentario);
			PrintWriter out = response.getWriter();
			List<DtComentario> comentarios = (ArrayList)servicios.getPublicadorPort().listarComentarios(propuesta).getDatos(); 
			if(comentarios.size() > 0) {
				out.println("<h3><font color=\"white\">Comentarios</font></h3><br>");
				for(int i = 0; i < comentarios.size() ; i++) {
	
					out.println("<div class=\"container\" align=\"center\">");
					out.println("<div class=\"mypanel mypanel-default\" style=\"width:800px;\">");
					out.println("<div class=\"mypanel-heading\" align=\"left\">" + comentarios.get(i).getNickName() + "</div>");
					out.println("<div class=\"mypanel-body\" align=\"left\"><font color =\"black\" >" + comentarios.get(i).getComentario() + "</font></div>");
					out.println("</div>");
					out.println("</div>");
	
				}
			} else
				out.println("<h3><font color=\"white\">No hay comentarios!</font></h3><br>");
			
    	} else if(request.getParameter("action").equals("registrarColaboracion")) {
    		
    		String propuesta = (String) (request.getParameter("tituloProp"));
			String retorno = request.getParameter("selectRetorno");
			String monto = request.getParameter("txtMonto");
			String nickName = (String) request.getSession().getAttribute("usuario_logueado");
	    	
			TRetorno ret = null;
			if (retorno.equals("PORCENTAJE_GANANCIA"))
				ret = TRetorno.PORCENTAJE_GANANCIA;
			else if (retorno.equals("ENTRADA_GRATIS"))
				ret = TRetorno.ENTRADA_GRATIS;

			servicios.getPublicadorPort().infoPropuesta(propuesta);
			servicios.getPublicadorPort().agregarColaboracion(nickName, Float.parseFloat(monto), ret );
    		
			PrintWriter out = response.getWriter();
			out.println("<span style=\"text-align: center\"><h3>Colaboradores</h3></span>");
			List<DtColaboracion> colaboraciones = (ArrayList) servicios.getPublicadorPort().listarColaboraciones().getDatos();
			for (int i = 0; i < colaboraciones.size(); i++) {
				DtColaboracion dtColab = colaboraciones.get(i);
				if (dtColab.getTitulo().equals(propuesta)) {
					DtColaborador colaborador = servicios.getPublicadorPort().infoColaborador(dtColab.getNickname());
					out.println("<a href=\"consultaUsuario?usuario=<%=colaborador.getNickName()%>\">");
					out.println(colaborador.getNombre() + " " + colaborador.getApellido() + " (" + colaborador.getNickName() + ")");
					out.println("</a><br>");
				}
			}
    	}
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
