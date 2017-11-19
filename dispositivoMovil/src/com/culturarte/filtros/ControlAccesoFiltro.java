package com.culturarte.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import servidor.PublicadorService;


/**
 * Servlet Filter implementation class ControlAccesoFiltro
 */
@WebFilter("/ControlAccesoFiltro")
public class ControlAccesoFiltro implements Filter {

    /**
     * Default constructor. 
     */
    public ControlAccesoFiltro() {
    	
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here
		
		HttpServletRequest request = (HttpServletRequest) req; 
		ServletContext contexto = request.getServletContext();
		//System.out.println(request.getRequestURL().toString());

		
		String userAgent = request.getHeader("User-Agent");
		
		new PublicadorService().getPublicadorPort().registrarAcceso(
				request.getRemoteHost(),
				request.getRequestURL().toString(),
				userAgent.substring(0, userAgent.indexOf("/")),
				userAgent.substring(userAgent.indexOf("(")+1, userAgent.indexOf(";"))
			);
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
