<%@page import="logica.Fabrica"%>
<%@page import="dataTypes.DtProponente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="dataTypes.DtProponente"%>
<%@page import="dataTypes.DtUsuario"%>
<%@page import="dataTypes.DtColaborador"%>
<%@page import="dataTypes.DtColaboracion"%>
<%@page import="dataTypes.DtPropuesta"%>
<%@page import="dataTypes.TEstado"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="/WEB-INF/template/head.jsp" />
<title>Usuario | Culturarte</title>
</head>
<body>
	<jsp:include page="/WEB-INF/template/header.jsp" />
	<br>
	<br>
	<%
		if (request.getAttribute("usr") instanceof DtProponente) {
			DtProponente dtP = (DtProponente) (request.getAttribute("usr"));
	%>
	<div class="well span8 offset2">
		<div class="panel">
			<div class="main text-color">
				<div class="panel-heading ">
					<h3 class="panel-title text-color"><%=dtP.getNombre().concat(" ").concat(dtP.getApellido()).concat("  (Proponente)")%></h3>
				</div>
				<div class="panel-body group " id="userimage">
					<div class="left">
						<%
							if (dtP.getRutaImg() == "") {
						%>
						<img src="/media/images/defecto.png" />
						<%
							} else {
						%>

						<img
							src="/media/images/imagenes/usuarios/proponentes/<%=dtP.getRutaImg()%>.jpg" />
						<% }
							
							if(request.getAttribute("siguiendo") != null) {
						%>
							<br><br>
							<form id="formSeguir" name="formSeguir" method="post"
								action="/SeguimientoUsuario?seguido=<%= dtP.getNickName() %>">
								<jsp:include page="toggleSeguimiento.jsp"/>
							</form>
						<% } %>
					</div>
					<div class="right">
						<div>
							<table
								class="table table-condensed table-responsive table-user-information ">
								<tbody>
									<tr>
										<td>Nickname:</td>
										<td id="nickname"><%=dtP.getNickName()%></td>
									</tr>
									<tr>
										<td>Email:</td>
										<td><%=dtP.getEmail()%></td>
									</tr>
									<tr>
										<td>Fecha de nacimiento:</td>
										<td><%=new SimpleDateFormat("dd/MM/yyyy").format(dtP.getFechaNacimiento().getTime())%></td>
									</tr>
									<tr>
										<td>Direccion:</td>
										<td><%=dtP.getDireccion()%></td>
									</tr>
									<tr>
										<td>Propuestas:</td>
										<td>
											<%
												ArrayList<DtPropuesta> propuestas = (ArrayList<DtPropuesta>)dtP.getPropuestas();
												if(propuestas != null) {
													for(int i = 0; i < propuestas.size(); i++) {
														if(dtP.getNickName().equals(request.getAttribute("usuario_logueado")) 
															|| propuestas.get(i).getEstado() != TEstado.INGRESADA) {
															String titulo = propuestas.get(i).getTitulo();
											%> <a href="consultaPropuesta?propuesta=<%= titulo %>"><%= titulo %></a>
											<br> <%	
														}
													}
												} 
											%>
										</td>
									</tr>
									<tr>
										<td></td>
										<td></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="panel-footer">
					<div><%=dtP.getBiografia()%></div>
				</div>
				<div class="panel-footer group">
					<div class="span left">
						<span style="text-align: center"><h3>Seguidores</h3></span>
						<%
							ArrayList<DtUsuario> listaSeguidores = (ArrayList<DtUsuario>)Fabrica.getInstance().getICtrlUsuario().listarSeguidores(dtP.getNickName());
							if (listaSeguidores.size() > 0) {
								for (int i = 0; i < listaSeguidores.size(); i++) {
									DtUsuario seguidor = listaSeguidores.get(i);
						%>
						<a href="consultaUsuario?usuario=<%= seguidor.getNickName() %>">
							<%= seguidor.getNombre()+ " " + seguidor.getApellido() + " (" + seguidor.getNickName() + ")" %>
						</a>
						<%= (seguidor instanceof DtProponente)?" - Proponente":" - Colaborador" %>
						<br>
						<%
								}
							}
						%>
					</div>
					<div class="span right">
						<span style="text-align: center"><h3>Seguidos</h3></span>
						<%
							ArrayList<DtUsuario> listaSeguidos = (ArrayList<DtUsuario>)Fabrica.getInstance().getICtrlUsuario().listarSeguidos(dtP.getNickName());
							if (listaSeguidos.size() > 0) {
								for (int i = 0; i < listaSeguidos.size(); i++) {
											DtUsuario seguido = listaSeguidos.get(i);
						%>

						<a href="consultaUsuario?usuario=<%= seguido.getNickName() %>">
							<%= seguido.getNombre()+ " " + seguido.getApellido() + " (" + seguido.getNickName() + ")" %>
						</a>
						<%= (seguido instanceof DtProponente)?" - Proponente":" - Colaborador" %>
						<br>
						<%
								}
							}
						%>
					</div>
				</div>
				<div class="panel-footer">
					<%
						String link = dtP.getLinkSitio();
						if(link != null && link != "") {
					%>
					<a href="<%=link%>" target="_blank">
						<button class="btn btn-warning" type="button">
							<img class="emailboton" src="/media/images/link.png">
						</button>
					</a>
					<%
						}
					%>
					<a href="<%="mailto:" + dtP.getEmail()%>"><button
							class="btn btn-success meilito" type="button"
							data-original-title="Send message to user">
							<img class="emailboton" src="/media/images/email.png">
						</button></a>
				</div>
			</div>
		</div>
	</div>

	<%
		} else if (request.getAttribute("usr") instanceof DtColaborador) {
			DtColaborador dtC = (DtColaborador) (request.getAttribute("usr"));
	%>


	<div class="well span8 offset2">
		<div class="panel">
			<div class="main text-color">
				<div class="panel-heading ">
					<h3 class="panel-title text-color"><%=dtC.getNombre().concat(" ").concat(dtC.getApellido()).concat("  (Colaborador)")%></h3>
				</div>
				<div class=" panel-body  " id="userimage">
					<div class="izquierdauser">
						<%
							if (dtC.getRutaImg() == "") {
						%>
						<img src="/media/images/defecto.png" />
						<%
							} else {
						%>

						<img
							src="/media/images/imagenes/usuarios/colaboradores/<%=dtC.getRutaImg()%>.jpg" />
						<%
							}
						
							if(request.getAttribute("siguiendo") != null) {
						%>
							<br><br>
							<form id="formSeguir" name="formSeguir" method="post"
								action="/SeguimientoUsuario?seguido=<%= dtC.getNickName() %>">
								<jsp:include page="toggleSeguimiento.jsp"/>
							</form>
						<% } %>
					</div>
					<div class="derechauser">
						<div>
							<table
								class="table table-condensed table-responsive table-user-information ">
								<tbody>
									<tr>
										<td>Nickname:</td>
										<td><%=dtC.getNickName()%></td>
									</tr>
									<tr>
										<td>Email:</td>
										<td><%=dtC.getEmail()%></td>
									</tr>
									<tr>
										<td>Fecha de nacimiento:</td>
										<td><%=new SimpleDateFormat("dd/MM/yyyy").format(dtC.getFechaNacimiento().getTime())%></td>
									</tr>
									<tr>
										<td>Colaboraciones:</td>
										<td>
											<%
											ArrayList<DtColaboracion> colaboraciones = (ArrayList<DtColaboracion>)dtC.getColaboraciones();
											if(colaboraciones != null) {
												for(int i = 0; i < colaboraciones.size(); i++) {
													String titulo = colaboraciones.get(i).getTitulo();
										%> <a href="consultaPropuesta?propuesta=<%= titulo %>"><%= titulo %></a>
											<br> <%
												}
											}
										%>
										</td>
									</tr>
									<tr>
										<td></td>
										<td></td>
									</tr>

								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="panel-footer group">
					<div class="span left">
						<span style="text-align: center"><h3>Seguidores</h3></span>
						<%
							ArrayList<DtUsuario> listaSeguidores = (ArrayList<DtUsuario>)Fabrica.getInstance().getICtrlUsuario().listarSeguidores(dtC.getNickName());
							if (listaSeguidores.size() > 0) {
								for (int i = 0; i < listaSeguidores.size(); i++) {
									DtUsuario seguidor = listaSeguidores.get(i);
						%>
						<a href="consultaUsuario?usuario=<%= seguidor.getNickName() %>">
							<%= seguidor.getNombre()+ " " + seguidor.getApellido() + " (" + seguidor.getNickName() + ")" %>
						</a>
						<%= (seguidor instanceof DtProponente)?" - Proponente":" - Colaborador" %>
						<br>
						<%
								}
							}
						%>
					</div>
					<div class="span right">
						<span style="text-align: center"><h3>Seguidos</h3></span>
						<%
							ArrayList<DtUsuario> listaSeguidos = (ArrayList<DtUsuario>)Fabrica.getInstance().getICtrlUsuario().listarSeguidos(dtC.getNickName());
							if (listaSeguidos.size() > 0) {
								for (int i = 0; i < listaSeguidos.size(); i++) {
									DtUsuario seguido = listaSeguidos.get(i);
						%>
						<a href="consultaUsuario?usuario=<%= seguido.getNickName() %>">
							<%= seguido.getNombre()+ " " + seguido.getApellido() + " (" + seguido.getNickName() + ")" %>
						</a>
						<%= (seguido instanceof DtProponente)?" - Proponente":" - Colaborador" %>
						<br>
						<%
								}
							}
						%>
					</div>
				</div>
				<div class="panel-footer">
					<a href="<%="mailto:" + dtC.getEmail()%>"><button
							class="btn btn-success meilito" type="button"
							data-original-title="Send message to user">
							<img class="emailboton" src="/media/images/email.png">
						</button></a>
				</div>
			</div>
		</div>
	</div>


	<%
		}
	%>

	<script>
		$(function() {
			$('#boton_seguir').change(function() {
				$(formSeguir).submit();
			})
		})
	</script>
	<script src="media/bootstrap-toggle/doc/script.js"></script>
	<script src="../media/bootstrap-toggle/js/bootstrap-toggle.js"></script>
	<script src="/media/styles/userProfile.css"></script>
	<div class="footer">
		<jsp:include page="/WEB-INF/template/footer.jsp" />
	</div>
</body>
<style>
.left {
	float: left;
	width: 50%;
}

.right {
	float: right;
	width: 50%;
}

.group:after {
	content: "";
	display: table;
	clear: both;
}

img {
	max-width: 100%;
	height: auto;
}

@media screen and (max-width: 480px) {
	.left, .right {
		float: none;
		width: auto;
	}
}
</style>

</html>