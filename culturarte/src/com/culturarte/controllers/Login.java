package com.culturarte.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.culturarte.model.EstadoSesion;

import logica.Fabrica;
import dataTypes.DtUsuario;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
    

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        HttpSession objSesion = request.getSession();
       
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        EstadoSesion nuevoEstado;
        
        
       
		// chequea contrase�a
		try {
			DtUsuario user;
			ArrayList<DtUsuario> arregloProponentes = (ArrayList<DtUsuario>) Fabrica.getInstance().getICtrlUsuario().listarUsuarios();	
			int index =0;
			while (index < arregloProponentes.size()
					&& !arregloProponentes.get(index).getNickName().equals(login)
					&& !arregloProponentes.get(index).getEmail().equals(login))
				index++;
			if (Fabrica.getInstance().getICtrlUsuario().existeUsuario(login, login)){
				user = arregloProponentes.get(index);
				if (Fabrica.getInstance().getICtrlUsuario().checkPassword(login, password)){
					nuevoEstado = EstadoSesion.LOGIN_CORRECTO;
					request.getSession().setAttribute("usuario_logueado", user.getNickName());
				}else nuevoEstado = EstadoSesion.LOGIN_INCORRECTO;

			}else {
					nuevoEstado = EstadoSesion.LOGIN_INCORRECTO;
					System.out.println("error en la contrasenia del proponente");
			}

			
			} catch(Exception ex){
				
				nuevoEstado = EstadoSesion.LOGIN_INCORRECTO;
				System.out.println("Estoy en la exception");
			}
        
        objSesion.setAttribute("estado_sesion", nuevoEstado);
		
		// redirige a la p�gina principal para que luego rediriga a la p�gina
		// que corresponde
        RequestDispatcher dispatcher = request.getRequestDispatcher("/home");
        dispatcher.forward(request, response);
    } 
    
	/**
	 * Devuelve el usuario logueado
	 * @param request
	 * @return
	 * @throws UsuarioNoEncontrado 
	 */
	static public DtUsuario getUsuarioLogueado(HttpServletRequest request){
		DtUsuario usuario = null;
		try{
			if (Fabrica.getInstance().getICtrlUsuario().esProponente((String) request.getSession().getAttribute("usuario_logueado")))
				usuario = Fabrica.getInstance().getICtrlUsuario().infoProponente((String) request.getSession().getAttribute("usuario_logueado"));
			else 
				usuario = Fabrica.getInstance().getICtrlUsuario().infoColaborador((String) request.getSession().getAttribute("usuario_logueado"));
		
		}catch (Exception excepcionRetornadaPorElPrograma){
			System.out.println("No se pudo obtener el usuario logeado");
		}
		return usuario;
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
