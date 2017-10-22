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
	
	<!-- VENTANA MODAL Iniciar sesion-->
	<div class="modal fade" id="iniciarsesion"
		aria-labelledby="iniciarsesion">
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
					<form action="iniciar-sesion" method="POST">
						<div class="form-group">
							<div class="input-group">
								<div class="input-group-addon">Nickname:</div>
								<input class="form-control" type="text" name="login" />
							</div>
							<br />
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon">Contraseña:</div>
									<input class="form-control" type="password" name="password" />
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

	<!-- VENTANA MODAL Registrarse-->
	<div class="modal fade" id="registro">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<!--  Header de la ventana -->
				<div class="modal-header">
					<h4 class="modal-title">Registrarse</h4>
					<button type="button" class="close" data-dismiss="modal"
						arial-hidden="true">&times;</button>

				</div>
				<div class="modal-body">
					<div class="container">
						<div class="row centered-form">
							<div
								class="col-xs-12 col-sm-10 col-md-12 col-sm-offset-2 col-md-offset-6">
								<div class="panel panel-default">
									<div class="panel-heading"></div>

									<div class="panel-body">
										<form role="form" action="AltaUsuario" id="formUsuario"
											name="formUsuario" method="post">
											<h3>
												<small>Tipo de usuario:</small>
											</h3>
											<p>
												<input type="radio" name="TipoUsuario" value="Proponente"
													onClick="mostrarinformacion()"> <label>Proponente</label>

												<input type="radio" name="TipoUsuario" value="Colaborador"
													onClick="ocultarinformacion()" checked> <label>Colaborador</label>

											</p>
											<div class="row">
												<div class="col-xs-6 col-sm-6 col-md-6">
													<div class="form-group">
														<input type="text" name="txNombre" id="txNombre"
															class="form-control input-sm" placeholder="Nombre">
													</div>
												</div>
												<div class="col-xs-6 col-sm-6 col-md-6">
													<div class="form-group">
														<input type="text" name="txApellido" id="txApellido"
															class="form-control input-sm" placeholder="Apellido">
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-xs-6 col-sm-6 col-md-6">
													<div class="form-group">
														<input type="text" name="txNickname" id="txNickname"
															class="form-control input-sm" placeholder="Nickname">
													</div>
												</div>
											
														<div class="col-xs-6 col-sm-6 col-md-6">
															<div class="form-group">
																<input class="input-group date fj-date" id="datetimepicker1" name="date" /> 
															</div>
														</div>
														
											</div>

											<div class="form-group">
												<input type="email" id="txEmail" name="txEmail"
													class="form-control input-sm" placeholder="Email">
											</div>

											<div class="row">
												<div class="col-xs-6 col-sm-6 col-md-6">
													<div class="form-group">
														<input type="password" name="password" id="password"
															class="form-control input-sm" placeholder="Contraseña">
													</div>
												</div>
												<div class="col-xs-6 col-sm-6 col-md-6">
													<div class="form-group">
														<input type="password" name="confirm_password"
															id="confirm_password" class="form-control input-sm"
															placeholder="Conf. Contraseña">
															<span style="float: right;" id='message'></span>
													</div>
												</div>
											</div>
											<div id="panelProponente" style="display: none">
												<div class="form-group">
													<input type="text" id="txDireccion"
														class="form-control input-sm" placeholder="Direccion">
												</div>
												<div class="form-group">
													<input type="text" id="txLinkSitio"
														class="form-control input-sm" placeholder="Link del sitio">
												</div>
												<div class="form-group">
													<input type="text" id="txBiografia"
														class="form-control input-sm" placeholder="Biografia">
												</div>
											</div>
											<div class="modal-footer">
												<input type="submit" onClick="submit()" name="submit"
													value="Enviar" class="btn btn-info btn-block">
											</div>
										</form>

									</div>
								</div>
							</div>
						</div>
					</div>
					<!--  Fotter de la ventana-->


				</div>
			</div>
		</div>
	</div>
	
</div>
