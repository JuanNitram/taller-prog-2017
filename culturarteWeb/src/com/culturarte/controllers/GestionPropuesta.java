package com.culturarte.controllers;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.DatatypeConfigurationException;

import com.culturarte.model.Utils;

import servidor.DataDate;
import servidor.DtCategoria;
import servidor.PublicadorService;
import servidor.TRetorno;

/**
 * Servlet implementation class GestionPropuesta
 */
@WebServlet("/GestionPropuesta")
public class GestionPropuesta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PublicadorService servicios = new PublicadorService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionPropuesta() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("action").equals("extender")) {
			String titulo = request.getParameter("tituloProp");
			servicios.getPublicadorPort().extenderFinanciacion(titulo);
		} else if(request.getParameter("action").equals("cancelar")){
			String prop = (String)request.getParameter("tituloProp");
			servicios.getPublicadorPort().cancelarPropuesta(prop);
		} else if(request.getParameter("action").equals("proponer")) {
			try {
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
				DtCategoria dtCategoria = new DtCategoria();
				dtCategoria.setNombre(categoria);
				
				DataDate dataDate = new DataDate();
				dataDate.setDate(Utils.getXmlGregorianCalendarFromDate(dateTime));
				servicios.getPublicadorPort().altaPropuesta((String) (request.getSession().getAttribute("usuario_logueado")), 
						titulo, dtCategoria, descripcion, lugar, dataDate, montoNecesario , retorno, montoEntrada, null);
				
				//Vuelve al inicio de la pagina
				response.sendRedirect("/perfil");
			} catch (DatatypeConfigurationException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
