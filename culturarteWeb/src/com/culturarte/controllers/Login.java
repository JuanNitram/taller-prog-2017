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
        
		servidor.PublicadorService service =  new servidor.PublicadorService();
		servidor.Publicador port = service.getPublicadorPort();
       
		
		
		// chequea contrase�a
		try {
			servidor.DtUsuario user;
			servidor.DtUsuarios DtUs = port.listarUsuarios();
			ArrayList<servidor.DtUsuario> users = (ArrayList<servidor.DtUsuario>) DtUs.getUsers();
			
			int index =0;
			while (index < users.size()
					&& !users.get(index).getNickName().equals(login)
					&& !users.get(index).getEmail().equals(login))
				index++;
			if (port.existeUsuario(login, login)){
				user = users.get(index);
				if (port.checkPassword(login, password)){
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
	static public servidor.DtUsuario getUsuarioLogueado(HttpServletRequest request){
		servidor.DtUsuario usuario = null;
		servidor.PublicadorService service =  new servidor.PublicadorService();
		servidor.Publicador port = service.getPublicadorPort();
		try{
			if (port.esProponente((String) request.getSession().getAttribute("usuario_logueado")))
				usuario = port.infoProponente((String) request.getSession().getAttribute("usuario_logueado"));
			else 
				usuario = port.infoColaborador((String) request.getSession().getAttribute("usuario_logueado"));
		
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
