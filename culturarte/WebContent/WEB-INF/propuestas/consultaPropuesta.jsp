<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="logica.Fabrica"%>
<%@page import="dataTypes.DtPropuesta"%>
<%@page import="dataTypes.TRetorno"%>
<%@page import="dataTypes.DtProponente"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% DtPropuesta propuesta = (DtPropuesta)(request.getAttribute("dtProp")); %>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<jsp:include page="/WEB-INF/template/head.jsp" />
	<title><%= propuesta.getTitulo() %> | Culturarte</title>
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
								<h3 class="panel-title text-color"><%= propuesta.getTitulo()%>
									(<%= propuesta.getCategoria().getNombre() %>)
								</h3>
							</div>
							<div class="panel-body">
								<div class="row-fluid">
									<div class="span6">
										<table
											class="table table-condensed table-responsive table-user-information">
											<tr>
												<%= propuesta.getDescripcion() %>
											</tr>
											<tbody>
												<tr>
													<td>Lugar:</td>
													<td><%= propuesta.getLugar() %></td>
												</tr>
												<tr>
													<td>Proponente:</td>
													<%
                                        	DtProponente proponente = Fabrica
                                            		.getInstance()
                                            		.getICtrlUsuario()
                                            		.infoProponente(propuesta.getNickProponente());
                                        	String strProp = proponente.getNombre();
                                        	strProp += " " + proponente.getApellido();
                                        	strProp += " (" + proponente.getNickName() + ")";
										%>
													<td><a
														href="consultaUsuario?usuario=<%= proponente.getNickName() %>">
															<%= strProp %>
													</a></td>
												</tr>
												<tr>
													<td>Estado:</td>
													<td><%= propuesta.getEstado().toString().substring(0,1).toUpperCase() +  propuesta.getEstado().toString().toLowerCase().substring(1).replace("_", " ") %></td>
												</tr>
												<tr>
													<td>Fecha de publicación:</td>
													<td><%= new SimpleDateFormat("dd/MM/yyyy").format(propuesta.getFechaPublicacion()) %></td>
												</tr>
												<tr>
													<td>Fecha prevista:</td>
													<td><%= new SimpleDateFormat("dd/MM/yyyy").format(propuesta.getFechaRealizacion()) %></td>
												</tr>
												<tr>
													<td>Precio entrada:</td>
													<td><%= "$ " + propuesta.getPrecioEntrada() %></td>
												</tr>
												<tr>
													<td>Monto necesario:</td>
													<td><%="$ " + propuesta.getMontoRequerido() %></td>
												</tr>
												<tr>
													<td>Monto recaudado:</td>
													<td><%="$ " + propuesta.getMontoReunido() %></td>
												</tr>
												<tr>
													<td>Tipo de retorno:</td>
													<%
                                        	String retorno = "Error al cargar el retorno";
                                        	if(propuesta.getTipoRetorno() == TRetorno.ENTRADA_GRATIS)
                                        		retorno = "Entradas gratis";
                                        	else if(propuesta.getTipoRetorno() == TRetorno.PORCENTAJE_GANANCIA)
                                            	retorno = "Porcentaje de ganancia";
                                        	else if(propuesta.getTipoRetorno() == TRetorno.PORCENTAJE_Y_ENTRADAS)
                                                retorno = "Porcentaje de Ganancia | Entradas gratis";
                                        %>
													<td><%= retorno %></td>
												</tr>

											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<form action="RegistrarColaboracion" method="post">
			<% if(request.getSession().getAttribute("usuario_logueado") != null && !Fabrica.getInstance().getICtrlUsuario().esProponente((String) request.getSession().getAttribute("usuario_logueado"))){ %>
			<h2 align="center">
				<font color="white">REGISTRAR COLABORACION</font>
			</h2>

			<div class="form-group col-lg-4" align="left">
				<label for="titulo"><font color="white">Monto</font></label> <input
					input name="txtMonto" type="number" required id="txtMonto"
					class="form-control">
			</div>

			<div class="form-group col-lg-4" align="left">
				<label for="select"><font color="white">Tipo Retorno</font></label>
				<select class="form-control" id="selectRetorno" name="selectRetorno">
					<% if(propuesta.getTipoRetorno() == TRetorno.PORCENTAJE_GANANCIA){ %>
					<option value="PORCENTAJE_GANANCIA">Porcentaje de ganancia</option>
					<%} else if(propuesta.getTipoRetorno() == TRetorno.ENTRADA_GRATIS){ %>
					<option value="ENTRADA_GRATIS">Entradas gratis</option>
					<%} else {%>
					<option value="ENTRADA_GRATIS">Entradas gratis</option>
					<option value="PORCENTAJE_GANANCIA">Porcentaje de ganancia</option>
					<% } %>
				</select>
			</div>

			<div class="form-group col-lg-4 " align="center">
				<button type="submit" name="submit" id="submit"
					class="btn btn-default">Registrar Colaboracion</button>
				<button type="reset" class="btn btn-default" onClick="goBack()">Volver</button>
			</div>
			<%} %>
		</form>
	</div>

	<div class="footer">
		<jsp:include page="/WEB-INF/template/footer.jsp" />
	</div>
	<script>
	function goBack() {
		window.history.back();
	}	
</script>
</body>
</html>