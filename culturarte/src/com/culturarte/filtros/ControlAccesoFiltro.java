package com.culturarte.filtros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.culturarte.model.Acceso;

/**
 * Servlet Filter implementation class ControlAccesoFiltro
 */
@WebFilter("/ControlAccesoFiltro")
public class ControlAccesoFiltro implements Filter {

    /**
     * Default constructor. 
     */
    public ControlAccesoFiltro() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		HttpServletRequest request = (HttpServletRequest) req; 
		ServletContext contexto = request.getServletContext();
		//System.out.println(request.getRequestURL().toString());

		
		ArrayList<Acceso> accesos;
		String userAgent = request.getHeader("User-Agent");
		Acceso acc = new Acceso(
				request.getRemoteHost(),
				request.getRequestURL().toString(),
				userAgent.substring(0, userAgent.indexOf("/")),
				userAgent.substring(userAgent.indexOf("(")+1, userAgent.indexOf(";")),
				new Date()
			);

		if(contexto.getAttribute("accesos") == null)
			accesos = new ArrayList<Acceso>();
		else accesos = (ArrayList<Acceso>) contexto.getAttribute("accesos");
		
		if(accesos.size() == 10000) 
			accesos.remove(accesos.size() - 1);

		accesos.add(0, acc);
		contexto.setAttribute("accesos", accesos);
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
