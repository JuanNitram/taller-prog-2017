package com.culturarte.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

/**
 * Servlet implementation class Propuestas
 */
@WebServlet("/Propuestas")
public class Propuestas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String filtro=null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Propuestas() {
        super();
    }
    
    /*private static List<TreeNode> categoriasList = new ArrayList();
	 
	public static List<TreeNode> getCategoriasList() {
		return categoriasList;
	}
	
	public static void vaciarCategoriasList() {
		categoriasList.clear();
	}
	 
	public static void recursivoTree(DefaultMutableTreeNode raiz) {
		if (raiz.getChildCount() != 0) {
			DefaultMutableTreeNode nodo = null;
			for (int i =0 ; i<raiz.getChildCount(); i++) {
				categoriasList.add(raiz.getChildAt(i));
				recursivoTree((DefaultMutableTreeNode) raiz.getChildAt(i));
			}
		}
	}*/
    
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			servidor.PublicadorService service =  new servidor.PublicadorService();
			servidor.Publicador port = service.getPublicadorPort();
			
			filtro = request.getParameter("filtro");
			
			if (filtro == "" || filtro == null) {
				
				servidor.DataList dtPs = port.listarPropuestas();
				List<servidor.DtPropuesta> props = (ArrayList) dtPs.getDatos();
				
				if (props.size() > 0) {
					request.setAttribute("propuestas", props);
					request.getRequestDispatcher("/WEB-INF/propuestas/listar.jsp").forward(request, response);
					
				} else {
					request.setAttribute("excepcion", true);
					request.setAttribute("excepcionTitulo", "Propuestas");
					request.setAttribute("excepcionMensaje", "No existen propuestas registradas en el servidor.");	
					request.getRequestDispatcher("/home").forward(request, response);
				}
			} else {
				ArrayList<servidor.DtPropuesta> propsfilter = new ArrayList<servidor.DtPropuesta>();
				String remplazado=filtro.replace("- ", "");
				servidor.DataList dtPs = port.listarPropuestaPorCategoria(remplazado);
				List<servidor.DtPropuesta> propsfil = (ArrayList) dtPs.getDatos();
				
				for(int i = 0; i< propsfil.size(); i++)
					if(propsfil.get(i).getEstado() != servidor.TEstado.INGRESADA)
						propsfilter.add(propsfil.get(i));

				if (propsfilter.size() > 0) {
					request.setAttribute("propuestas", propsfilter);
					request.getRequestDispatcher("/WEB-INF/propuestas/listar.jsp").forward(request, response);
				} else {
					request.setAttribute("excepcion", true);
					request.setAttribute("excepcionTitulo", "Propuestas");
					request.setAttribute("excepcionMensaje", "No existen propuestas en la categoría " + filtro);
					request.getRequestDispatcher("/propuestas?filtro=").forward(request, response);
				}
				
			}
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
