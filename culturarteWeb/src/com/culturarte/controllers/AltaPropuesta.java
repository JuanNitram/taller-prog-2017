package com.culturarte.controllers;

import java.io.IOException;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.tree.DefaultMutableTreeNode;

import dataTypes.DtCategoria;
import dataTypes.TRetorno;
import logica.Fabrica;
import logica.ICtrlPropuesta;

/**
 * Servlet implementation class AltaPropuesta
 */
@WebServlet("/AltaPropuesta")
public class AltaPropuesta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaPropuesta() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/propuestas/altaPropuesta.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("cancelar") != null && ((String)request.getParameter("cancelar")).equals("true")){
			String prop = (String)request.getParameter("tpropuesta");
			Fabrica.getInstance().getICtrlPropuesta().cancelarPropuesta(prop);
			response.sendRedirect("/propuestas");
		}
		else{
			String categoria = request.getParameter("selectCategoria");
			String titulo = request.getParameter("txTitulo").trim();
			String descripcion = request.getParameter("txDescripcion").trim();
			String lugar = request.getParameter("txLugar").trim();
			String fechaStr = request.getParameter("txFechaPrevista");
			float montoEntrada = Integer.parseInt(request.getParameter("precioEntrada"));
			float montoNecesario = Integer.parseInt(request.getParameter("montoRequerido"));
			
			
			TRetorno retorno;
			if (request.getParameter("cbPorcentaje") != null && request.getParameter("cbEntradas") != null)
				retorno = TRetorno.PORCENTAJE_Y_ENTRADAS;
			else if (request.getParameter("cbPorcentaje") != null)
				retorno = TRetorno.PORCENTAJE_GANANCIA;
			else
				retorno = TRetorno.ENTRADA_GRATIS;
			
			Calendar calendar = Calendar.getInstance();
			String [] fechaSplit = fechaStr.split("/");
			calendar.set(Integer.parseInt(fechaSplit[2]), Integer.parseInt(fechaSplit[1]) - 1, Integer.parseInt(fechaSplit[0]));
			Date dateTime = calendar.getTime();
			DtCategoria dtCategoria = new DtCategoria(categoria);
			
			ICtrlPropuesta ICU = Fabrica.getInstance().getICtrlPropuesta();
			ICU.altaPropuesta((String) (request.getSession().getAttribute("usuario_logueado")), 
					titulo, dtCategoria, descripcion, lugar, dateTime, montoNecesario , retorno, montoEntrada, null);
			
			//Vuelve al inicio de la pagina
			response.sendRedirect("/perfil");
		}
	}

	private static List<String> categoriasList = new ArrayList();
	 
	public List<String> getCategoriasList() {
		return categoriasList;
		
	}
	public static void recursivoTree(DefaultMutableTreeNode raiz) {
		if (raiz.getChildCount() != 0) {
			DefaultMutableTreeNode nodo = null;
			for (int i =0 ; i<raiz.getChildCount(); i++) {
				categoriasList.add(raiz.getChildAt(i).toString());
				recursivoTree((DefaultMutableTreeNode) raiz.getChildAt(i));
				System.out.println(raiz.getChildAt(i).toString());
			}
		}
	}
	
}
