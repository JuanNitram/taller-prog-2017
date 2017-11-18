<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.culturarte.controllers.Login"%>
<%@page import=" java.util.List"%>
<%@page import=" java.util.ArrayList"%>
<%@ page import="javax.swing.tree.DefaultMutableTreeNode"%>
<%@ page import="javax.swing.tree.TreeNode"%>
<%@ page import="javax.swing.tree.TreeModel"%>
<%@ page import="javax.swing.JTree"%>
<%@page import="com.culturarte.controllers.Propuestas"%>

<link rel="stylesheet" href="CulturarteWeb/media/Data-picker/css/bootstrap-datepicker.css" />
<link rel="stylesheet" type="text/css" href="/CulturarteWeb/media/styles/buscador.css">
<link href="/CulturarteWeb/recursos/bootstrap/css/bootstrap.min.css" rel="stylesheet">

	

<style>
	input[type=number]::-webkit-inner-spin-button, 
	input[type=number]::-webkit-outer-spin-button { 
    -webkit-appearance: none;
    -moz-appearance: none;
    appearance: none;
    margin: 0; 
}
</style>
<style>
.inner-addon { 
    position: relative; 
}

/* style icon */
.inner-addon .fa {
  position: absolute;
  padding: 10px;
  pointer-events: none;
}

/* align icon */
.left-addon .fa  { left:  0px;}
.right-addon .fa { right: 0px;}

/* add padding  */
.left-addon input  { padding-left:  30px; }
.right-addon input { padding-right: 30px; }
</style>
<div id="header sinflecha">
	<div class="subtitulo"></div>

	<% 
		servidor.PublicadorService service =  new servidor.PublicadorService();
		servidor.Publicador port = service.getPublicadorPort();
   
		boolean esProponente = false;
		servidor.DtUsuario usr;
		try {
			usr = Login.getUsuarioLogueado(request);
			esProponente = port.esProponente(usr.getNickName());
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
			<img style="width: 40px; height: 40px;"
				src="/CulturarteWeb/media/images/logo_icon.png"></img> <a class="navbar-brand"
				href="/CulturarteWeb">Culturarte</a>

			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">

				<% if(usr != null){
						if (esProponente){ %>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link" href="/CulturarteWeb">Inicio
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="/CulturarteWeb/usuarios">Usuarios</a></li>
					<li class="nav-item"><a class="nav-link" href="/CulturarteWeb/propuestas">Propuestas</a></li>
					<li class="nav-item"><a class="nav-link" data-toggle="modal" href="#altaPropuesta">Registrar
							propuesta</a></li>
					<li class="nav-item"><a class="nav-link" href="/CulturarteWeb/perfil"><%= usr.getNombre().concat(" - ").concat(usr.getEmail()) %></a></li>

					<li id="divisor" class="nav-item"><a class="nav-link"
						href="/CulturarteWeb/cerrar">Cerrar sesión</a></li>
				</ul>
				<div class="inner-addon right-addon">
					<input type="text" placeholder="Buscar..." id="buscador" class="typeahead tt-query" autocomplete="off" spellcheck="false"><a class="fa fa-search" onclick="clicBuscar()"></a>
				</div>
				<% }else{ 
							%>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link" href="/CulturarteWeb">Inicio
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="/CulturarteWeb/usuarios">Usuarios</a></li>
					<li class="nav-item"><a class="nav-link" href="/CulturarteWeb/propuestas">Propuestas</a></li>
					<li class="nav-item"><a class="nav-link" href="/CulturarteWeb/perfil"><%= usr.getNombre().concat(" - ").concat(usr.getEmail()) %></a></li>
					<li class="nav-item"><a class="nav-link" href="/CulturarteWeb/cerrar">Cerrar
							sesión</a></li>
				</ul>
				<div class="inner-addon right-addon">
					<input type="text" id="buscador" class="typeahead tt-query" autocomplete="off" spellcheck="false"><a class="fa fa-search" onclick="clicBuscar()"></a>
				</div>
				<% } %>
				<% }else{ %>
				<ul class="navbar-nav ml-auto">
					<li id="space" class="nav-item active"><a class="nav-link"
						href="/CulturarteWeb">Inicio <span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="/CulturarteWeb/usuarios">Usuarios</a></li>
					<li class="nav-item"><a class="nav-link" href="/CulturarteWeb/propuestas">Propuestas</a></li>

					<li class="nav-item"><a href="#registro" data-toggle="modal"
						class="nav-link">Registrarse</a></li>
					<li class="nav-item"><a href="#iniciarsesion"
						data-toggle="modal" class="nav-link">Iniciar sesión</a></li>
				</ul>
				<div class="inner-addon right-addon">
					<input type="text" id="buscador" class="typeahead tt-query" autocomplete="off" spellcheck="false"><a class="fa fa-search" onclick="clicBuscar()"></a>
				</div>
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
												<input id="radioProponente" type="radio" name="TipoUsuario" value="Proponente"
													onChange="panelProponente()"> <label>Proponente</label>

												<input id="radioColaborador" type="radio" name="TipoUsuario" value="Colaborador"
													onChange="panelProponente()" checked> <label>Colaborador</label>

											</p>
											<div class="row">
												<div class="col-xs-6 col-sm-6 col-md-6">
													<div class="form-group">
														<input type="text" name="txNombre" id="txNombre"
															class="form-control input-sm" placeholder="Nombre" required>
													</div>
												</div>
												<div class="col-xs-6 col-sm-6 col-md-6">
													<div class="form-group">
														<input type="text" name="txApellido" id="txApellido"
															class="form-control input-sm" placeholder="Apellido" required>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-xs-6 col-sm-6 col-md-6">
													<div class="form-group">
														<input type="text" name="txNickname" id="txNickname"
															class="form-control input-sm" placeholder="Nickname" required>
													</div>
												</div>

												<div class="col-xs-6 col-sm-6 col-md-6">
													<div class="form-group">
														<input class="input-group date fj-date"
															id="datetimepicker1" name="date" placeholder="Fecha de nacimiento" required/>
													</div>
												</div>

											</div>

											<div class="form-group">
												<input type="email" id="txEmail" name="txEmail"
													class="form-control input-sm" placeholder="Email" required>
											</div>

											<div class="row">
												<div class="col-xs-6 col-sm-6 col-md-6">
													<div class="form-group">
														<input type="password" name="password" id="password"
															class="form-control input-sm" placeholder="Contraseña" required>
													</div>
												</div>
												<div class="col-xs-6 col-sm-6 col-md-6">
													<div class="form-group">
														<input type="password" name="confirm_password"
															id="confirm_password" class="form-control input-sm"
															placeholder="Conf. Contraseña" required> <span
															style="float: right;" id='message'></span>
													</div>
												</div>
											</div>
											<div id="panelProponente" style="display:none;">
												<div class="form-group">
													<input type="text" id="txDireccion" name="txDireccion"
														class="form-control input-sm" placeholder="Direccion">
												</div>
												<div class="form-group">
													<input type="url" id="txLinkSitio" name="txLinkSitio"
														class="form-control input-sm" placeholder="Link del sitio">
												</div>
												<div class="form-group">
													<input type="text" id="txBiografia" name="txBiografia"
														class="form-control input-sm" placeholder="Biografia">
												</div>
											</div>
											<div class="modal-footer">
												<input type="submit" onClick="submit()" name="submit"
													value="Registrarse" class="btn btn-info btn-block">
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
	
	<!-- VENTANA MODAL Registrar Propuesta-->
	<div class="modal fade" id="altaPropuesta">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<!--  Header de la ventana -->
				<div class="modal-header">
					<h4 class="modal-title">Registrar propuesta</h4>
					<button type="button" class="close" data-dismiss="modal"
						arial-hidden="true">&times;</button>

				</div>
				<div class="modal-body">
					<div class="container">
						<div class="row centered-form">
							<div class="col-xs-12 col-sm-10 col-md-12 col-sm-offset-2 col-md-offset-6">
								<div class="panel panel-default">
									<div class="panel-heading"></div>
									<div class="panel-body">
										<form role="form" action="GestionPropuesta?action=proponer" id="formPropuesta"
											name="formPropuesta" method="post" onsubmit="return validarProponer();">
											<div class="row">
												<div class="col-xs-6 col-sm-6 col-md-6">
													<div class="form-group">
														<input type="text" name="txTitulo" id="txTitulo"
															class="form-control input-sm" placeholder="Titulo" required>
													</div>
												</div>
												<div class="col-xs-6 col-sm-6 col-md-6">
													<div class="form-group">
														<input type="text" name="txLugar" id="txLugar"
															class="form-control input-sm" placeholder="Lugar" required>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-xs-12 col-sm-12 col-md-12">
													<div class="form-group">
														<textarea type="text" name="txDescripcion" id="txDescripcion"
															class="form-control input-sm" placeholder="Descripción" required></textarea>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-xs-6 col-sm-6 col-md-6">
													<div class="form-group" align="left">
														<label for="selectCategoria">Categoría: </label>
														<select class="form-control" id="selectCategoria" name="selectCategoria">
														<%
												    		List<String> categorias = (ArrayList)service.getPublicadorPort().listarCategorias().getDatos();
												     		for(String s : categorias) {
												    	%>
															<option value="<%=s%>"><%=s%></option>
														<%  } %>
														</select>
													</div>
												</div>
												<div class="form-group col-lg-6 " align="left">
											    	<label for="txFechaPrevista">Fecha prevista:</label>
											    	<input name="txFechaPrevista" type="date" required id="txFechaPrevista" class="form-control input-normal input-group date fj-date" placeholder="dd/mm/aaaa"></input>
											 	</div>
											</div>
											<div class="row">
												<div class="col-xs-6 col-sm-6 col-md-6">
													<div class="form-group">
														<input  type="text" pattern="[1-9][0-9]*"  name="precioEntrada" id="precioEntrada"
															class="form-control input-sm" placeholder="Precio de entrada" required>
													</div>
												</div>
												<div class="col-xs-6 col-sm-6 col-md-6">
													<div class="form-group">
														<input type="text" pattern="[1-9][0-9]*" name="montoRequerido"
															id="montoRequerido" class="form-control input-sm"
															placeholder="Monto requerido" required>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-xs-6 col-sm-6 col-md-6">
													<div id="formGroupRetorno" class="form-group form-control" align="left">
														<label>Tipo de retorno:</label>
														<div class="form-check">
															<label class="form-check-label">
																<input id="cbPorcentaje" name="cbPorcentaje" class="form-check-input" type="checkbox" value="Porcentaje de ganancia"> Porcentaje de ganancia
															</label>
														</div>
														<div class="form-check">
															<label class="form-check-label">
																<input id="cbEntradas" name="cbEntradas" class="form-check-input" type="checkbox" value="Entradas gratis"> Entradas gratis
															</label>
														</div>
														<label id='mensajeRetorno' align="left"></label>
													</div>
												</div>
											</div>
											<div class="modal-footer">
												<input id="btn_proponer" type="submit" name="btn_proponer"
													value="Proponer" class="btn btn-info btn-block">
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
	<script src="/CulturarteWeb/media/Data-picker/js/bootstrap-datepicker.min.js"></script>
	<script src="/CulturarteWeb/media/app.js"></script>
	<script>
		function validarProponer() {
			var checkBox1 = document.getElementById('cbPorcentaje');
			var checkBox2 = document.getElementById('cbEntradas');
			if(!checkBox1.checked && !checkBox2.checked) {
				$('#mensajeRetorno').html('Elige por lo menos un tipo de retorno').css('color', 'red');
				return false;
			} else
				return true;
		};
		function panelProponente() {
			if (document.getElementById('radioProponente').checked) {
				document.getElementById('panelProponente').style.display = "block";
				document.getElementById('txDireccion').required = true;
				document.getElementById('txLinkSitio').required = true;
				document.getElementById('txBiografia').required = true;
			} else if (document.getElementById('radioColaborador').checked) {
				document.getElementById('txDireccion').required = false;
				document.getElementById('txLinkSitio').required = false;
				document.getElementById('txBiografia').required = false;
				document.getElementById('panelProponente').style.display = "none";
			}
		}
	</script>

	<script type="text/javascript">
		$('#password, #confirm_password').on('keyup', function() {
			if ($('#password').val() == $('#confirm_password').val()) {
				$('#message').html('Coinciden').css('color', 'green');
			} else
				$('#message').html('No coinciden').css('color', 'red');
		});
	</script>
<script>
var prop;
document.getElementById("buscador").onclick = function() {funcbuscador()};
function funcbuscador() {
	$.ajax({
		type: 'GET',
		url: 'Buscador',
		data: {
			objects: '1',
			dimension: '1'
		},
		success: function(data){
			prop = data;
		}
	});	   
};

$(funcbuscador()).ready(function(){
    // Defining the local dataset
	var propuestas = prop.split(',');   
    // Constructing the suggestion engine
    var propuestas = new Bloodhound({
        datumTokenizer: Bloodhound.tokenizers.whitespace,
        queryTokenizer: Bloodhound.tokenizers.whitespace,
        local: propuestas,
    });
    
    // Initializing the typeahead
    $('.typeahead').typeahead({
        hint: true,
        highlight: true, /* Enable substring highlighting */
        minLength: 1 /* Specify minimum characters required for showing result */
    },
    {
        name: 'propuestas',
        source: propuestas,
    });
});  

$('#buscador').keypress(function(e) {
    if(e.which == 13) {
    	var propuestabuscar = 'consultaPropuesta?propuesta=' + $('#buscador').val();
    	window.open(propuestabuscar.toString(),"_self");
    }
});
</script>
<script type="text/javascript" src="/CulturarteWeb/media/styles/typeahead.bundle.js"></script>
</div>
