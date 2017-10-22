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

import logica.Fabrica;
import dataTypes.DtCategoria;
import dataTypes.DtPropuesta;
import dataTypes.DtUsuario;

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
        // TODO Auto-generated constructor stub
    }
    
    private static List<TreeNode> categoriasList = new ArrayList();
	 
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
	}
    
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			filtro = request.getParameter("filtro");
			
			if (filtro == "" || filtro == null){
				ArrayList<DtPropuesta> props = (ArrayList<DtPropuesta>) Fabrica.getInstance().getICtrlPropuesta().listarPropuestas();
				if (props.size() > 0){
					request.setAttribute("propuestas", props);
					request.getRequestDispatcher("/WEB-INF/propuestas/listar.jsp").forward(request, response);
				}
				else{
					request.setAttribute("excepcion", true);
					request.setAttribute("excepcionTitulo", "Propuestas");
					request.setAttribute("excepcionMensaje", "No existen propuestas registradas en el servidor.");	
					request.getRequestDispatcher("/home").forward(request, response);
				}
			}
			else {
				ArrayList<DtPropuesta> propsfilter = new ArrayList<DtPropuesta>();
				ArrayList<DtPropuesta> propsfil = (ArrayList<DtPropuesta>) Fabrica.getInstance().getICtrlPropuesta().listarPropuestas();
				for(int i = 0; i< propsfil.size(); i++){
					System.out.println(propsfil.get(i).getCategoria().getNombre() + " - " + filtro.toString());
					
					if(propsfil.get(i).getCategoria().getNombre().equals(filtro.toString())){
						propsfilter.add(propsfil.get(i));
						System.out.println(propsfil.get(i).getCategoria().getNombre());
					}
						
				}if (propsfilter.size() > 0){
					request.setAttribute("propuestas", propsfilter);
					request.getRequestDispatcher("/WEB-INF/propuestas/listar.jsp").forward(request, response);
				}else{
					response.sendRedirect("/propuestas");
				}
				
			}
			
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
