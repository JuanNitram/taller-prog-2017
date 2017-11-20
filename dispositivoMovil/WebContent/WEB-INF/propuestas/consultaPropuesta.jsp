<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	servidor.PublicadorService service = new servidor.PublicadorService();
	servidor.Publicador port = service.getPublicadorPort();
	servidor.DtPropuesta propuesta = (servidor.DtPropuesta) (request.getAttribute("dtProp"));
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="/WEB-INF/template/head.jsp" />
<title><%=propuesta.getTitulo()%> | Culturarte</title>
</head>
<body>
	<jsp:include page="/WEB-INF/template/header.jsp" />
	<div class="main" align="center">
		<div class="container">
			<div class="well span8 offset2">
				<div class="row-fluid user-row"></div>
				<div class="row-fluid text-color">
					<div class="span8 offset1">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h3 class="panel-title text-color"><%=propuesta.getTitulo()%>
									(<%=propuesta.getCategoria().getNombre()%>)
								</h3>
							</div>
							<div class="panel-body">
								<div class="row-fluid">
									<div class="span6">
										<table
											class="table table-condensed table-responsive table-user-information">
											<tr>
												<%=propuesta.getDescripcion()%>
											</tr>
											<tbody>
												<tr>
													<td>Lugar:</td>
													<td><%=propuesta.getLugar()%></td>
												</tr>
												<tr>
													<td>Proponente:</td>
													<%
														servidor.DtProponente proponente = port.infoProponente(propuesta.getNickProponente());
														String strProp = proponente.getNombre();
														strProp += " " + proponente.getApellido();
														strProp += " (" + proponente.getNickName() + ")";
													%>
													<td><a
														href="consultaUsuario?usuario=<%=proponente.getNickName()%>">
															<%=strProp%>
													</a></td>
												</tr>
												<tr>
													<td>Estado:</td>
													<td><%=propuesta.getEstado().toString().substring(0, 1).toUpperCase()
					+ propuesta.getEstado().toString().toLowerCase().substring(1).replace("_", " ")%></td>
												</tr>
												<tr>
													<td>Fecha de publicación:</td>
													<td>
														<%	if(propuesta.getFechaPublicacion()!=null) { %>
															<%= new SimpleDateFormat("dd/MM/yyyy").format(propuesta.getFechaPublicacion().toGregorianCalendar().getTime()) %>
														<%	} else { %>
																<blackquote><cite>No se ha publicado</cite></blackquote>
														<%	} %>
													</td>
												</tr>
												<tr>
													<td>Fecha prevista:</td>
													<td><%= new SimpleDateFormat("dd/MM/yyyy").format(propuesta.getFechaRealizacion().toGregorianCalendar().getTime())%></td>
												</tr>
												<tr>
													<td>Precio entrada:</td>
													<td><%="$ " + propuesta.getPrecioEntrada()%></td>
												</tr>
												<tr>
													<td>Monto necesario:</td>
													<td><%="$ " + propuesta.getMontoRequerido()%></td>
												</tr>
												<tr>
													<td>Monto recaudado:</td>
													<td><%="$ " + propuesta.getMontoReunido()%></td>
												</tr>
												<tr>
													<td>Tipo de retorno:</td>
													<%
														String retorno = "Error al cargar el retorno";
														if (propuesta.getTipoRetorno() == servidor.TRetorno.ENTRADA_GRATIS)
															retorno = "Entradas gratis";
														else if (propuesta.getTipoRetorno() == servidor.TRetorno.PORCENTAJE_GANANCIA)
															retorno = "Porcentaje de ganancia";
														else if (propuesta.getTipoRetorno() == servidor.TRetorno.PORCENTAJE_Y_ENTRADAS)
															retorno = "Porcentaje de ganancia | Entradas gratis";
													%>
													<td><%=retorno%></td>
												</tr>
											</tbody>
										</table>
										<%
											if ((propuesta.getEstado() == servidor.TEstado.PUBLICADA || propuesta.getEstado() == servidor.TEstado.EN_FINANCIACION) &&
												request.getSession().getAttribute("usuario_logueado") != null
																&& !port.esProponente((String) request.getSession().getAttribute("usuario_logueado"))) {
										%>
										<div class="panel-footer group">
											<div class="span left" id="panelColaboradores">
												<span style="text-align: center"><h3>Colaboradores</h3></span>
												<%
													servidor.DataList DtC = port.listarColaboraciones();
													List<servidor.DtColaboracion> colaboraciones = (ArrayList)DtC.getDatos();
														for (int i = 0; i < colaboraciones.size(); i++) {
															servidor.DtColaboracion dtColab = colaboraciones.get(i);
															if (dtColab.getTitulo().equals(propuesta.getTitulo())) {
																servidor.DtColaborador colaborador = port.infoColaborador(dtColab.getNickname());
												%>
												<a
													href="consultaUsuario?usuario=<%=colaborador.getNickName()%>">
													<%=colaborador.getNombre() + " " + colaborador.getApellido() + " (" + colaborador.getNickName() + ")"%>
												</a><br>
												<%
													}
														}
												%>
											</div>
											<div class="span right">
												<span style="text-align: center"><h3>
														<font color="white">Registra una colaboración</font>
													</h3></span>
												<div class="container">
													<form>
														<div class="form-group" align="left">
															<label for="titulo"><font color="white">Monto</font></label><input
																name="txtMonto" type="text" pattern="[1-9][0-9]*" id="txtMonto"
																class="form-control" required>
														</div>

														<div class="form-group" align="left">
															<label for="select"><font color="white">Tipo
																	de retorno</font></label> <select class="form-control"
																id="selectRetorno" name="selectRetorno">
																<%
																	if (propuesta.getTipoRetorno() == servidor.TRetorno.PORCENTAJE_GANANCIA) {
																%>
																<option value="PORCENTAJE_GANANCIA" selected>Porcentaje
																	de ganancia</option>
																<%
																	} else if (propuesta.getTipoRetorno() == servidor.TRetorno.ENTRADA_GRATIS) {
																%>
																<option value="ENTRADA_GRATIS" selected>Entradas
																	gratis</option>
																<%
																	} else {
																%>
																<option value="PORCENTAJE_GANANCIA" selected>Porcentaje
																	de ganancia</option>
																<option value="ENTRADA_GRATIS">Entradas gratis</option>
																<%
																	}
																%>
															</select>
														</div>

														<div class="form-group" align="center">
															<button type="button" name="submit" id="btn_colaborar"
																class="btn btn-default" data-titulo="<%=propuesta.getTitulo()%>">Aceptar</button>
														</div>
													</form>
												</div>
											</div>
										</div>
										<%
											} else {
										%>
										<div class="panel-footer group">
											<div class="span center">
												<span style="text-align: center"><h3>Colaboradores</h3></span>
												<%
													servidor.DataList DtC = port.listarColaboraciones();
													List<servidor.DtColaboracion> colaboraciones = (ArrayList)DtC.getDatos();
														for (int i = 0; i < colaboraciones.size(); i++) {
															servidor.DtColaboracion dtColab = colaboraciones.get(i);
															if (dtColab.getTitulo().equals(propuesta.getTitulo())) {
																servidor.DtColaborador colaborador = port.infoColaborador(dtColab.getNickname());
												%>
												<a
													href="consultaUsuario?usuario=<%=colaborador.getNickName()%>">
													<%=colaborador.getNombre() + " " + colaborador.getApellido() + " (" + colaborador.getNickName() + ")"%>
												</a><br>
												<%
															}
														}
												%>
											</div>
										</div>
										<%
											}
										%>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="/MobileDevice/media/styles/userProfile.css"></script>
	<div class="footer">
		<jsp:include page="/WEB-INF/template/footer.jsp" />
	</div>
	<script>
		function goBack() {
			window.history.back();
		};
		$('document').ready(function(){
			$('#btn_colaborar').click(function(){
				console.log("click btn colaborar");
				console.log($('#txtMonto').val());				
				$.ajax({
					type : 'POST',
					url : 'Colaboraciones',
					data : {
						action : 'registrarColaboracion',
						tituloProp : $('#btn_colaborar').data("titulo"),
						selectRetorno : $('#selectRetorno').val(),
						txtMonto : $('#txtMonto').val()
					},
					success : function(res) {
						$('#txtMonto').val('');
						$('#panelColaboradores').html(res);
					}
				});
			});
		    
		});
	</script>
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
