<%@page import="dataTypes.TEstado"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="logica.Fabrica"%>
<%@page import="dataTypes.DtPropuesta"%>
<%@page import="dataTypes.DtComentario"%>
<%@page import="dataTypes.TRetorno"%>
<%@page import="dataTypes.DtProponente"%>
<%@page import="dataTypes.DtUsuario"%>
<%@page import="dataTypes.DtColaborador"%>
<%@page import="dataTypes.DtColaboracion"%>
<%@page import="com.culturarte.controllers.Login"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	DtPropuesta propuesta = (DtPropuesta) (request.getAttribute("dtProp"));
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
														DtProponente proponente = Fabrica.getInstance().getICtrlUsuario()
																.infoProponente(propuesta.getNickProponente());
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
													<td><%=new SimpleDateFormat("dd/MM/yyyy").format(propuesta.getFechaPublicacion())%></td>
												</tr>
												<tr>
													<td>Fecha prevista:</td>
													<td><%=new SimpleDateFormat("dd/MM/yyyy").format(propuesta.getFechaRealizacion())%></td>
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
														if (propuesta.getTipoRetorno() == TRetorno.ENTRADA_GRATIS)
															retorno = "Entradas gratis";
														else if (propuesta.getTipoRetorno() == TRetorno.PORCENTAJE_GANANCIA)
															retorno = "Porcentaje de ganancia";
														else if (propuesta.getTipoRetorno() == TRetorno.PORCENTAJE_Y_ENTRADAS)
															retorno = "Porcentaje de ganancia | Entradas gratis";
													%>
													<td><%=retorno%></td>
												</tr>
											</tbody>
										</table>
										<%
											if ((propuesta.getEstado() == TEstado.PUBLICADA || propuesta.getEstado() == TEstado.EN_FINANCIACION) &&
												request.getSession().getAttribute("usuario_logueado") != null
																&& !Fabrica.getInstance().getICtrlUsuario()
																		.esProponente((String) request.getSession().getAttribute("usuario_logueado"))) {
										%>
										<div class="panel-footer group">
											<div id="panelColaboradores" class="span left">
												<span style="text-align: center"><h3>Colaboradores</h3></span>
												<%
													ArrayList<DtColaboracion> colaboraciones = (ArrayList<DtColaboracion>) Fabrica.getInstance()
																.getICtrlPropuesta().listarColaboraciones();
														for (int i = 0; i < colaboraciones.size(); i++) {
															DtColaboracion dtColab = colaboraciones.get(i);
															if (dtColab.getTitulo().equals(propuesta.getTitulo())) {
																DtColaborador colaborador = Fabrica.getInstance().getICtrlUsuario()
																		.infoColaborador(dtColab.getNickname());
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
																	if (propuesta.getTipoRetorno() == TRetorno.PORCENTAJE_GANANCIA) {
																%>
																<option value="PORCENTAJE_GANANCIA" selected>Porcentaje
																	de ganancia</option>
																<%
																	} else if (propuesta.getTipoRetorno() == TRetorno.ENTRADA_GRATIS) {
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
													ArrayList<DtColaboracion> colaboraciones = (ArrayList<DtColaboracion>) Fabrica.getInstance()
																.getICtrlPropuesta().listarColaboraciones();
														for (int i = 0; i < colaboraciones.size(); i++) {
															DtColaboracion dtColab = colaboraciones.get(i);
															if (dtColab.getTitulo().equals(propuesta.getTitulo())) {
																DtColaborador colaborador = Fabrica.getInstance().getICtrlUsuario()
																		.infoColaborador(dtColab.getNickname());
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
							<%	
								DtUsuario usr = Login.getUsuarioLogueado(request); 
							%>

							<style>
							.mypanel {
							    margin-bottom: 20px;
							    background-color: #fff;
							    border: 1px solid transparent;
							    border-radius: 4px;
							    -webkit-box-shadow: 0 1px 1px rgba(0,0,0,.05);
							    box-shadow: 0 1px 1px rgba(0,0,0,.05);
							}
							.mypanel-default {
							    border-color: #ddd;
							}
							.mypanel-default>.mypanel-heading {
							    color: #333;
							    background-color: #f5f5f5;
							    border-color: #ddd;
							}
							.mypanel-heading {
							    padding: 10px 15px;
							    border-bottom: 1px solid transparent;
							    border-top-left-radius: 3px;
							    border-top-right-radius: 3px;
							}
							
							.mypanel-body {
							    padding: 15px;
							}
							</style>
							<div id="panelComentarios" class="panel-footer group">
								<br>
							<% 
								List<DtComentario> comentarios = Fabrica.getInstance().getICtrlPropuesta().listarComentarios(propuesta.getTitulo()); 
								if(comentarios.size() > 0) {
							%>
								<h3><font color="white">Comentarios</font></h3>	<br>
							<% 
									for(int i = 0; i < comentarios.size() ; i++) {
							%>
										<div class="container" align="center">
										  <div class="mypanel mypanel-default" style="width:800px;">
										    <div class="mypanel-heading" align="left"><%= comentarios.get(i).getNickName() %></div>
										    <div class="mypanel-body" align="left"><font color ="black" ><%= comentarios.get(i).getComentario() %></font></div>
										  </div>
										</div>									
							<%
									}
								} else {
							%>
									<h3><font color="white">No hay comentarios!</font></h3>	<br>
							<%	} %>
							</div>
							
							<% 
								if(usr != null && !Fabrica.getInstance().getICtrlUsuario().esProponente(usr.getNickName())){
							%>
							<form>
								<div class="form-group" align="center">
  									<textarea class="form-control" rows="3" id="comentario" name="comentario" style="width:800px;" placeholder="Ingrese un comentario . . ." ></textarea>
								</div>
								<div class="form-group" align="center">
									<button type="button" id="btn_comentar" class="btn btn-default" data-titulo="<%=propuesta.getTitulo()%>">Aceptar</button>
									<button type="reset" class="btn btn-default" onClick="goBack()">Volver</button>
								</div>
							</form>
							<% } %>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="/media/styles/userProfile.css"></script>
	<div class="footer">
		<jsp:include page="/WEB-INF/template/footer.jsp" />
	</div>
	<script>
		function goBack() {
			window.history.back();
		};
		$('document').ready(function(){
			$('#btn_comentar').click(function(){
				$.ajax({
					type : 'POST',
					url : 'OperacionesPropuesta',
					data : {
						action : 'agregarComentario',
						tituloProp : $('#btn_comentar').data("titulo"),
						comentario : $('#comentario').val()
					},
					success : function(res) {
						$('#comentario').val('');
						$('#panelComentarios').html(res);
					}
				});
			});
			$('#btn_colaborar').click(function(){
				$.ajax({
					type : 'POST',
					url : 'OperacionesPropuesta',
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
</
html
>
