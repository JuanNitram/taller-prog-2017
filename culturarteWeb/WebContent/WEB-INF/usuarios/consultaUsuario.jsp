<%@page import="servidor.DataList"%>
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
<%@page import="java.util.List"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="/WEB-INF/template/head.jsp" />
<title>Usuario | Culturarte</title>
<script type="text/javascript">
	$(document).ready(function(){
		$('#divSeguimiento').click(function(){
			$.ajax({
				type : 'POST',
				data : {
					nickname : $('#nickname').html(),
					nomApel : $('#nombre_apellido').html(),
					valorBoton : $('#divSeguimiento').data("estado")
				},
				url : 'SeguimientoUsuario',
				success : function(result) {
					$('#panelSeguidores').html(result);
					
					if($('#divSeguimiento').data("estado") == 'Seguir')
						$('#divSeguimiento').data("estado",'Siguiendo');
					else
						$('#divSeguimiento').data("estado",'Seguir');
				}
			});
		});
	});
</script>
</head>
<body>
	<jsp:include page="/WEB-INF/template/header.jsp" />
	<br>
	<br>
	<%
		servidor.PublicadorService service =  new servidor.PublicadorService();
		servidor.Publicador port = service.getPublicadorPort();
		session.setAttribute("usr", request.getAttribute("usr"));
		if (request.getAttribute("usr") instanceof servidor.DtProponente) {
			servidor.DtProponente dtP = (servidor.DtProponente) (request.getAttribute("usr"));
	%>
	<div class="well span8 offset2">
		<div class="panel">
			<div class="main text-color">
				<div class="panel-heading ">
					<h3 id="nombre_apellido" class="panel-title text-color"><%=dtP.getNombre().concat(" ").concat(dtP.getApellido()).concat(" (Proponente)")%></h3>
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
						<%	}
							
							if(request.getAttribute("siguiendo") != null) {
						%>
							<br><br>
							<div id="divSeguimiento" data-estado="<%= ((boolean) (request.getAttribute("siguiendo")))?"Siguiendo":"Seguir" %>">
								<jsp:include page="toggleSeguimiento.jsp" />
							</div>
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
										<td><%out.println();//new SimpleDateFormat("dd/MM/yyyy").format(dtP.getFechaNacimiento().getTime())%></td>
									</tr>
									<tr>
										<td>Direccion:</td>
										<td><%=dtP.getDireccion()%></td>
									</tr>
									<tr>
										<td>Propuestas:</td>
										<td>
											<%

												
												servidor.DataList dtPs = port.listarPropuestas();
												List<servidor.DtPropuesta> propuestas = (ArrayList) dtPs.getDatos();
										
												if(propuestas != null) {
													for(int i = 0; i < propuestas.size(); i++) {
														if(dtP.getNickName().equals(request.getAttribute("usuario_logueado")) 
															|| propuestas.get(i).getEstado() != servidor.TEstado.INGRESADA) {
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
					<div id="panelSeguidores" class="span left">
						<span style="text-align: center"><h3>Seguidores</h3></span>
						<%
							
						servidor.DataList dtSeguidores = port.listarSeguidores(dtP.getNickName());
						List<servidor.DtUsuario> listaSeguidores = (ArrayList) dtSeguidores.getDatos();
						
							//ArrayList<DtUsuario> listaSeguidores = (ArrayList<DtUsuario>)Fabrica.getInstance().getICtrlUsuario().listarSeguidores(dtP.getNickName());
							if (listaSeguidores.size() > 0) {
								for (int i = 0; i < listaSeguidores.size(); i++) {
									servidor.DtUsuario seguidor = listaSeguidores.get(i);
						%>
						<a href="consultaUsuario?usuario=<%= seguidor.getNickName() %>">
							<%= seguidor.getNombre()+ " " + seguidor.getApellido() + " (" + seguidor.getNickName() + ")" %>
						</a>
						<%= (seguidor instanceof servidor.DtProponente)?" - Proponente":" - Colaborador" %>
						<br>
						<%
								}
							}
						%>
					</div>
					<div class="span right">
						<span style="text-align: center"><h3>Seguidos</h3></span>
						<%
						
							servidor.DataList dtSeguidos = port.listarSeguidos(dtP.getNickName());
							ArrayList<servidor.DtUsuario> listaSeguidos = (ArrayList) dtSeguidos.getDatos();
						
							if (listaSeguidos.size() > 0) {
								for (int i = 0; i < listaSeguidos.size(); i++) {
											servidor.DtUsuario seguido = listaSeguidos.get(i);
						%>

						<a href="consultaUsuario?usuario=<%= seguido.getNickName() %>">
							<%= seguido.getNombre()+ " " + seguido.getApellido() + " (" + seguido.getNickName() + ")" %>
						</a>
						<%= (seguido instanceof servidor.DtProponente)?" - Proponente":" - Colaborador" %>
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
		} else if (request.getAttribute("usr") instanceof servidor.DtColaborador) {
			servidor.DtColaborador dtC = (servidor.DtColaborador) (request.getAttribute("usr"));
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
							<div id="divSeguimiento" data-estado="<%= ((boolean) (request.getAttribute("siguiendo")))?"Siguiendo":"Seguir" %>">
								<jsp:include page="toggleSeguimiento.jsp" />
							</div>
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
										<td><%out.println();//new SimpleDateFormat("dd/MM/yyyy").format(dtC.getFechaNacimiento().getTime())%></td>
									</tr>
									<tr>
										<td>Colaboraciones:</td>
										<td>
											<%
											ArrayList<servidor.DtColaboracion> colaboraciones = (ArrayList<servidor.DtColaboracion>)dtC.getColaboraciones();
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
					<div id="panelSeguidores" class="span left">
						<span style="text-align: center"><h3>Seguidores</h3></span>
						<%
							servidor.DataList dtSeguidores = port.listarSeguidores(dtC.getNickName());
							List<servidor.DtUsuario> listaSeguidores = (ArrayList) dtSeguidores.getDatos();
							
							if (listaSeguidores.size() > 0) {
								for (int i = 0; i < listaSeguidores.size(); i++) {
									servidor.DtUsuario seguidor = listaSeguidores.get(i);
						%>
						<a href="consultaUsuario?usuario=<%= seguidor.getNickName() %>">
							<%= seguidor.getNombre()+ " " + seguidor.getApellido() + " (" + seguidor.getNickName() + ")" %>
						</a>
						<%= (seguidor instanceof servidor.DtProponente)?" - Proponente":" - Colaborador" %>
						<br>
						<%
								}
							}
						%>
					</div>
					<div class="span right">
						<span style="text-align: center"><h3>Seguidos</h3></span>
						<%
							servidor.DataList dtSeguidos = port.listarSeguidos(dtC.getNickName());
							List<servidor.DtUsuario> listaSeguidos = (ArrayList) dtSeguidos.getDatos();
							
							if (listaSeguidos.size() > 0) {
								for (int i = 0; i < listaSeguidos.size(); i++) {
									servidor.DtUsuario seguido = listaSeguidos.get(i);
						%>
						<a href="consultaUsuario?usuario=<%= seguido.getNickName() %>">
							<%= seguido.getNombre()+ " " + seguido.getApellido() + " (" + seguido.getNickName() + ")" %>
						</a>
						<%= (seguido instanceof servidor.DtProponente)?" - Proponente":" - Colaborador" %>
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

	<!-- <script>
		$(function() {
			$('#boton_seguir').change(function() {
				$(formSeguir).submit();
			})
		})
	</script> -->
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