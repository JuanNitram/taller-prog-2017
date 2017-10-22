<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.culturarte.controllers.Login"%>
<%@page import="dataTypes.DtUsuario"%>
<%@page import="Logica.Fabrica"%>
<%@page import="dataTypes.DtUsuario"%>
<!DOCTYPE html>


<div id="header">
	<div class="subtitulo"></div>
	
	<% boolean esProponente = false;
		DtUsuario usr;
		try {
			usr = Login.getUsuarioLogueado(request);
			esProponente = Fabrica.getInstance().getICtrlUsuario().esProponente(usr.getNickName());
		} catch(Exception ex){
			usr = null;
		}

		if(request.getAttribute("excepcion") != null) {
	%>
		<script type="text/javascript">
		$(document).ready(function(){
		    $("#excepcion").modal();
		});
		</script>
	<% 
			request.setAttribute("excepcion", false);
		} 
	%>
	
	<jsp:include page="/WEB-INF/errorPages/excepcion.jsp" />
	
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<img style="width:40px; height: 40px;" src="/media/images/logo_icon.png"></img>
				<a class="navbar-brand" href="/">Culturarte</a>
			
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				
					<% if(usr != null){
						if (esProponente){ %>
						<ul class="navbar-nav ml-auto">
							<li class="nav-item active"><a class="nav-link" href="/">Inicio
							<span class="sr-only">(current)</span>
							</a></li>
							<li class="nav-item"><a class="nav-link" href="/usuarios">Usuarios</a></li>
							<li class="nav-item"><a class="nav-link" href="/propuestas">Propuestas</a></li>
							<li class="nav-item"><a class="nav-link" href="/altaPropuesta">Registrar propuesta</a></li>
							<li class="nav-item"><a class="nav-link" href="/perfil"><%= usr.getNombre().concat(" - ").concat(usr.getEmail()) %></a></li>
							<li id="divisor" class="nav-item"><a class="nav-link" href="/cerrar">Cerrar sesión</a></li>
						</ul>
						<% }else{ 
							%>
							<ul class="navbar-nav ml-auto">
							<li class="nav-item active"><a class="nav-link" href="/">Inicio
							<span class="sr-only">(current)</span> 
							</a></li>
							<li class="nav-item"><a class="nav-link" href="/usuarios">Usuarios</a></li>
							<li class="nav-item"><a class="nav-link" href="/propuestas">Propuestas</a></li>
							<li class="nav-item"><a class="nav-link" href="/perfil"><%= usr.getNombre().concat(" - ").concat(usr.getEmail()) %></a></li>
							<li class="nav-item"><a class="nav-link" href="/cerrar">Cerrar sesión</a></li>
						</ul>
						<% } %>
					<% }else{ %>
					<ul class="navbar-nav ml-auto">	
						<li id="space" class="nav-item active"><a class="nav-link" href="/">Inicio
							<span class="sr-only">(current)</span>
							</a></li>
							<li class="nav-item"><a class="nav-link" href="/cargarDatos">Cargar datos</a></li>
							<li class="nav-item"><a class="nav-link" href="/usuarios">Usuarios</a></li>
							<li class="nav-item"><a class="nav-link" href="/propuestas">Propuestas</a></li>
							<li class="nav-item"><a href="#registro" data-toggle="modal" class="nav-link">Registrarse</a></li>
							<li  class="nav-item"><a href="#iniciarsesion" data-toggle="modal" class="nav-link" >Iniciar sesión</a></li>
					</ul>
				<% } %>
			</div>
		</div>
	</nav>
	
</div>
