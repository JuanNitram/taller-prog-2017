<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.culturarte.controllers.Login"%>
<%@page import="dataTypes.DtColaborador"%>
<%@page import="logica.Fabrica"%>
<%@ page import="javax.swing.tree.DefaultMutableTreeNode"%>
<%@ page import="javax.swing.tree.TreeNode"%>
<%@ page import="javax.swing.tree.TreeModel"%>
<%@ page import="javax.swing.JTree"%>
<%@page import="com.culturarte.controllers.Propuestas"%>
<!DOCTYPE html>
<link rel="stylesheet" href="/media/Data-picker/css/bootstrap-datepicker.css" />
<style>
	input[type=number]::-webkit-inner-spin-button, 
	input[type=number]::-webkit-outer-spin-button { 
    -webkit-appearance: none;
    -moz-appearance: none;
    appearance: none;
    margin: 0; 
}
</style>
<div id="header sinflecha">
	<div class="subtitulo"></div>

	<%
		servidor.DtColaborador usr = Login.getUsuarioLogueado(request);
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
			<img style="width: 40px; height: 40px;"
				src="/media/images/logo_icon.png"></img> <a class="navbar-brand"
				href="/">Culturarte Movil</a>

			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">

				<% if(usr != null) { %>
					<ul class="navbar-nav ml-auto">
						<li class="nav-item active"><a class="nav-link" href="/">Inicio
								<span class="sr-only">(current)</span>
						</a></li>
						<li class="nav-item"><a class="nav-link" href="propuestas">Propuestas</a></li>
						<li class="nav-item"><a class="nav-link" href="colaboraciones?action=pagar">Colaboraciones</a></li>
						<li class="nav-item"><a class="nav-link" href="perfil"><%= usr.getNombre().concat(" - ").concat(usr.getEmail()) %></a></li>
						<li id="divisor" class="nav-item"><a class="nav-link"
							href="/login?action=cerrar">Cerrar sesión</a></li>
					</ul>
				<% } else { %>
					<ul class="navbar-nav ml-auto">
						<li id="space" class="nav-item active"><a class="nav-link"
							href="/">Inicio <span class="sr-only">(current)</span>
						</a></li>
						<li class="nav-item"><a class="nav-link" href="propuestas">Propuestas</a></li>
						<li class="nav-item"><a href="#iniciarsesion"
							data-toggle="modal" class="nav-link">Iniciar sesión</a></li>
					</ul>
				<% } %>
			</div>
		</div>
	</nav>
	
	<% if(request.getSession().getAttribute("usuario_logueado") == null){ %>
	
	<script type="text/javascript">
    	$(window).on('load',function(){
        	$('#iniciarsesion').modal('show');
    	});
	</script>
	
	<% } %>

	<!-- VENTANA MODAL Iniciar sesion-->
	<div class="modal fade" id="iniciarsesion"
		aria-labelledby="iniciarsesion" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<!--  Header de la ventana -->
				<div class="modal-header">
					<h4 class="modal-title">Iniciar Sesion</h4>
					<button type="button" class="close" data-dismiss="modal"
						arial-hidden="true">&times;</button>

				</div>
				<!--  Contenido de la ventana-->
				<div class="modal-body">
					<form action="login?action=iniciar" method="POST">
						<div class="form-group">
							<div class="input-group">
								<div class="input-group-addon">Nickname:</div>
								<input class="form-control" type="text" name="login" />
							</div>
							<br />
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon">Contraseña:</div>
									<input class="form-control" type="password" name="password"/>
								</div>
							</div>

						</div>

						<!--  Fotter de la ventana-->
						<div class="modal-footer">
							<button type="button" class="btn btn-success"
								data-dismiss="modal">Cerrar</button>
							<button type="button" class="btn btn-primary" onclick="submit()">Iniciar</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script src="/media/Data-picker/js/bootstrap-datepicker.min.js"></script>
	<script src="/media/app.js"></script>
</div>
