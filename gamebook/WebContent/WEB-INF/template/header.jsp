<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="com.gamebook.controllers.Login"%>
<%@page import="dataTypes.DtUsuario"%>
<%@page import="Logica.Fabrica"%>
<%@page import="dataTypes.DtUsuario"%>
<div id="header">
    <div class="logo"><a href="/">CULTURARTE</a></div>
    <div class="subtitulo"></div>
	
	<%
		boolean esProponente = false;
		DtUsuario usr;
		try {
			usr = Login.getUsuarioLogueado(request);
			esProponente = Fabrica.getInstance().getICtrlUsuario().esProponente(usr.getNickName());
		} catch(Exception ex){
			usr = null;
		}
		
 		if(usr != null) {
 			if (esProponente){
			%>
			<div class="usuario">
				<a href="/usuarios">Usuarios</a> |
				<a href="/altapropuesta">Alta Propuesta</a> |
				<a href="/propuestas">Propuestas</a> |
				<a href="/cerrar">Cerrar Sesion</a> 
				<a href="/perfil"><%= usr.getNombre() %></a>
				(<%= usr.getEmail() %>)
			</div>
			<% }else{
				%>
				<div class="usuario">
				<a href="/usuarios">Usuarios</a> |
				<a href="/propuestas">Propuestas</a> |
				<a href="/registrarColaboracion">Nueva Colaboracion</a> |
				<a href="/cerrar">Cerrar Sesion</a> 
				<a href="/perfil"><%= usr.getNombre() %></a>
				(<%= usr.getEmail() %>)
			</div>	
			<%	
			}
 		}else { %>
				<div class="usuario">
				<a href="/registro">Registrarse</a> |
				<a href="/cargarDatos">Cargar Datos</a> |
				<a href="/usuarios">Usuarios</a> |
				<a href="/propuestas">Propuestas</a>
			</div>
			<%} %>
</div>

<div id="body-container">
