<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="/WEB-INF/errorPages/500.jsp"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!doctype html>
<html>
<head>
<jsp:include page="/WEB-INF/template/head.jsp" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Perfil | Culturarte</title>
<script type="text/javascript">
	$(document).ready(function() { //Define una funcion que se linkea a document cuando este se carga(ready)
		$('#extenderFinanciacion').click(function() { //Define una funcion que se linkea cuando el boton se clickea
			$.ajax({ //El .ajax hace una llamada al servlet sin que la pagina se recargue
				type : 'POST', //type define el metodo
				data : { // los datos que se acceden en el servlet por getParameter
					tituloProp : $('#extenderFinanciacion').data("titulo"),
					action : "extender",
				},
				url : 'GestionPropuesta', //este seria como el 'action' en el form (url del servlet)
				success : function() { // aca se definen las acciones que se hacen despues que el codigo del servlet se ejecuta
					$('#extenderFinanciacion').attr('title',"Ya has extendido esta financiación");
					$('#extenderFinanciacion').attr('disabled',true);
				}
			});
		});
		$('#cancelarPropuesta').click(function() {
			$.ajax({
				type : 'POST',
				data : {
					tituloProp : $('#cancelarPropuesta').data("titulo"),
					action : "cancelar",
				},
				url : 'GestionPropuesta',
				success : function() {
					$('#cancelarPropuesta').css("display","none");
					$('#avisoTitulo').html('Cancelar propuesta');
					$('#avisoMensaje').html('La propuesta ' + $('#cancelarPropuesta').data("titulo") + ' se ha cancelado con éxito.');
				}
			});
		});
	});
</script>
</head>
<body>
	<div class="modal fade" id="aviso" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<!--  Header de la ventana -->
				<div class="modal-header">
					<h4 id="avisoTitulo" class="modal-title">Extender financiación</h4>
					<button type="button" class="close" data-dismiss="modal"
						arial-hidden="true">&times;</button>

				</div>
				<!--  Contenido de la ventana-->
				<div class="modal-body">
					<p id="avisoMensaje">La financiación de la propuesta se ha extendido con éxito.</p>
				</div>
				<!--  Fotter de la ventana-->
				<div class="modal-footer">
					<button type="button" class="btn btn-success" data-dismiss="modal">Cerrar</button>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/template/header.jsp" />

	<%
		servidor.PublicadorService service =  new servidor.PublicadorService();
		servidor.Publicador port = service.getPublicadorPort();
		servidor.DtUsuario dtU = (servidor.DtUsuario) (request.getAttribute("usr"));
		if (request.getAttribute("usr") instanceof servidor.DtProponente) {
			servidor.DtProponente dtP = (servidor.DtProponente) dtU;
	%>
	<div class="well span8 offset2">
		<div class="panel">
			<div class="main text-color">
				<div class="panel-heading ">
					<h3 class="panel-title text-color"><%="Bienvenido " + dtP.getNombre() + " " + dtP.getApellido()%></h3>
				</div>
				<div class="panel-body group " id="userimage">
					<div class="left">
						<%
							if (dtP.getRutaImg() == "") {
						%>
						<img src="/CulturarteWeb/media/images/defecto.png" />
						<%
							} else {
						%>

						<img
							src="/CulturarteWeb/media/images/imagenes/usuarios/proponentes/<%=dtP.getRutaImg()%>.jpg" />
						<%
							}
						%>

					</div>
					<div class="right">
						<div>
							<table
								class="table table-condensed table-responsive table-user-information ">
								<tbody>
									<tr>
										<td>Nickname:</td>
										<td><%=dtP.getNickName()%></td>
									</tr>
									<tr>
										<td>¿ Darse baja ?</td>
										<td>					
											<div>
												<form action="bajaUsuario?nickName=<%=dtP.getNickName()%>" method="post">
													<button onclick="submit()" id="baja" style="margin-left: 10px"
															type="button" class="btn btn-danger">
															<i class="fa fa-times-circle"></i>
													</button>
												</form>
											</div>
										</td>
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
											<div>
												<%
													servidor.DataList dtPs = port.listarPropuestas();
													List<servidor.DtPropuesta> propuestas = (ArrayList) dtPs.getDatos();
													
													//ArrayList<DtPropuesta> propuestas = (ArrayList<DtPropuesta>) dtP.getPropuestas();
														if (propuestas != null) {
															for (int i = 0; i < propuestas.size(); i++) {
																String titulo = propuestas.get(i).getTitulo();
												%>
												<a href="consultaPropuesta?propuesta=<%=titulo%>"><%=titulo%></a>
												<%
													if (propuestas.get(i).getEstado() == servidor.TEstado.PUBLICADA
																		|| propuestas.get(i).getEstado() == servidor.TEstado.EN_FINANCIACION) {
														if (propuestas.get(i).getFechaExtension() != null) {
												%>
												<button id="extenderFinanciacion" style="margin-left: 10px"
													type=button class="btn btn-success"
													title="Ya has extendido esta financiación"
													data-titulo="<%=titulo%>" disabled>
													<i class="fa fa-calendar-plus-o"></i>
												</button>
												<%
														} else {
												%>
												<button id="extenderFinanciacion" style="margin-left: 10px"
													type=button class="btn btn-success"
													title="Extender financiación" data-titulo="<%=titulo%>"
													data-toggle="modal" data-target="#aviso">
													<i class="fa fa-calendar-plus-o"></i>
												</button>

												<%
														}
													} else if(propuestas.get(i).getEstado() == servidor.TEstado.FINANCIADA) {
												%>
													<button id="cancelarPropuesta" style="margin-left: 10px"
														type=button class="btn btn-danger"
														title="Cancelar propuesta" data-titulo="<%=titulo%>"
														data-toggle="modal" data-target="#aviso">
														<i class="fa fa-times-circle"></i>
													</button>
												<% } %>
												<br>
												<%
															}
														}
												%>
											</div>
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
							servidor.DataList dtSeguidores = port.listarSeguidores(dtP.getNickName());
							List<servidor.DtUsuario> listaSeguidores = (ArrayList) dtSeguidores.getDatos();
							if (listaSeguidores.size() > 0) {
								for (int i = 0; i < listaSeguidores.size(); i++) {
									servidor.DtUsuario seguidor = listaSeguidores.get(i);
						%>
						<a href="consultaUsuario?usuario=<%=seguidor.getNickName()%>">
							<%=seguidor.getNombre() + " " + seguidor.getApellido() + " (" + seguidor.getNickName()
								+ ")"%>
						</a>
						<%=(seguidor instanceof servidor.DtProponente) ? " - Proponente" : " - Colaborador"%>
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
							List<servidor.DtUsuario> listaSeguidos = (ArrayList) dtSeguidos.getDatos();
							if (listaSeguidos.size() > 0) {
								for (int i = 0; i < listaSeguidos.size(); i++) {
									servidor.DtUsuario seguido = listaSeguidos.get(i);
						%>

						<a href="consultaUsuario?usuario=<%=seguido.getNickName()%>">
							<%=seguido.getNombre() + " " + seguido.getApellido() + " (" + seguido.getNickName() + ")"%>
						</a>
						<%=(seguido instanceof servidor.DtProponente) ? " - Proponente" : " - Colaborador"%>
						<br>
						<%
							}
								}
						%>
					</div>
				</div>
				<div class="panel-footer">
					<a onclick="window.location='<%=dtP.getLinkSitio()%>';"><button
							class="btn btn-warning" type="button">
							<img class="emailboton" src="/CulturarteWeb/media/images/link.png">
						</button></a> <a href="<%="mailto:" + dtP.getEmail()%>"><button
							class="btn btn-success meilito" type="button"
							data-original-title="Send message to user">
							<img class="emailboton" src="/CulturarteWeb/media/images/email.png">
						</button></a>
				</div>
			</div>
		</div>
	</div>

	<%
		} else if (request.getAttribute("usr") instanceof servidor.DtColaborador) {
			//servidor.DtColaborador dtP = (servidor.DtColaborador) dtU;
			System.out.println("Entro");
			servidor.DtColaborador dtC = (servidor.DtColaborador) dtU;
			System.out.println("Casteo");
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
						<img src="/CulturarteWeb/media/images/defecto.png" />
						<%
							} else {
						%>

						<img
							src="/CulturarteWeb/media/images/imagenes/usuarios/colaboradores/<%=dtC.getRutaImg()%>.jpg" />
						<%
							}
						%>

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
										<td></td>
										<td></td>
									</tr>

								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="panel-footer">
					<div class="span">
						<table class="table">
							<tr>
								<span style="text-align: center"><h3>Colaboraciones</h3></span>
							</tr>
							<%
								ArrayList<servidor.DtColaboracion> colaboraciones = (ArrayList<servidor.DtColaboracion>) dtC.getColaboraciones();
									for (int i = 0; i < colaboraciones.size(); i++) {
										servidor.DtColaboracion dtColab = colaboraciones.get(i);
							%>
							<tr>
								<td><a
									href="consultaPropuesta?propuesta=<%=dtColab.getTitulo()%>"><%=dtColab.getTitulo()%></td>
								<td>$ <%=dtColab.getMontoAporte()%>
								</td>
								<td><%out.println();//new SimpleDateFormat("dd/MM/yyyy").format(dtColab.getFechaRealizacion().getTime())%>
								</td>
							</tr>
							<%
								}
							%>
						</table>
					</div>
				</div>
				<div class="panel-footer group">
					<div class="span left">
						<span style="text-align: center"><h3>Seguidores</h3></span>
						<%
							servidor.DataList dtSeguidores = port.listarSeguidores(dtC.getNickName());
							List<servidor.DtUsuario> listaSeguidores = (ArrayList) dtSeguidores.getDatos();
							if (listaSeguidores.size() > 0) {
								for (int i = 0; i < listaSeguidores.size(); i++) {
									servidor.DtUsuario seguidor = listaSeguidores.get(i);
						%>
						<a href="consultaUsuario?usuario=<%=seguidor.getNickName()%>">
							<%=seguidor.getNombre() + " " + seguidor.getApellido() + " (" + seguidor.getNickName()
								+ ")"%>
						</a>
						<%=(seguidor instanceof servidor.DtProponente) ? " - Proponente" : " - Colaborador"%>
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
						<a href="consultaUsuario?usuario=<%=seguido.getNickName()%>">
							<%=seguido.getNombre() + " " + seguido.getApellido() + " (" + seguido.getNickName() + ")"%>
						</a>
						<%=(seguido instanceof servidor.DtProponente) ? " - Proponente" : " - Colaborador"%>
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
							<img class="emailboton" src="/CulturarteWeb/media/images/email.png">
						</button></a>
				</div>
			</div>
		</div>
	</div>


	<%
		}
	%>
	<script src="/CulturarteWeb/media/styles/userProfile.css"></script>
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
