<%@page import="dataTypes.DtProponente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="dataTypes.DtProponente"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="dataTypes.DtColaborador"%>
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
		if(request.getAttribute("usr") instanceof DtProponente){
			DtProponente dtP = (DtProponente)(request.getAttribute("usr"));
%>
<div class="well span8 offset2">
	<div class="panel">
		<div class="main text-color">
			<div class="panel-heading ">
				<h3 class="panel-title text-color"><%=	dtP.getNombre().concat(" ").concat(dtP.getApellido()).concat("  (Proponente)")%></h3>
			</div>
			<div class=" panel-body  "  id="userimage">
				<div class="izquierdauser">
				<% if (dtP.getRutaImg() == ""){ %>
						<img src="/media/images/defecto.png" />
					<%}else { %>
						
						<img src="/media/images/imagenes/usuarios/proponentes/<%=dtP.getRutaImg()%>.jpg" />
					<%}%>
					
				</div>
				<div class="derechauser">
					<div >
						<table
							class="table table-condensed table-responsive table-user-information ">
							<tbody>
								<tr>
									<td>Nickname:</td>
									<td><%=	dtP.getNickName()%></td>
								</tr>
								<tr>
									<td>Email:</td>
									<td><%=	dtP.getEmail()%></td>
								</tr>
								<tr>
									<td>Fecha de nacimiento:</td>
									<td><%=
											new SimpleDateFormat("dd/MM/yyyy").format(dtP.getFechaNacimiento().getTime())
										%></td>
								</tr>
								<tr>
									<td>Direccion:</td>
									<td><%=	dtP.getDireccion()%></td>
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
				<div>Biografia:
				<%=	dtP.getBiografia()%></div>
			<div class="panel-footer">
				
				
				<a onclick="window.location='<%=dtP.getLinkSitio()%>';"><button      
					class="btn btn-warning" type="button">
						<img class="emailboton" src="/media/images/link.png"></button></a>
						 
						 
						 <a href="<%="mailto:" + dtP.getEmail()%>"><button
						class="btn btn-success meilito" type="button"
						data-original-title="Send message to user">
						<img class="emailboton" src="/media/images/email.png"></button></a>
				</div>
			</div>
		</div>
	</div>
	</div>

	<% } else if(request.getAttribute("usr") instanceof DtColaborador){ 
	DtColaborador dtC = (DtColaborador)(request.getAttribute("usr")); %>

	
<div class="well span8 offset2">
	<div class="panel">
		<div class="main text-color">
			<div class="panel-heading ">
				<h3 class="panel-title text-color"><%=	dtC.getNombre().concat(" ").concat(dtC.getApellido()).concat("  (Colaborador)")%></h3>
			</div>
			<div class=" panel-body  " id="userimage">
				<div class="izquierdauser">
					<% if (dtC.getRutaImg() == ""){ %>
						<img src="/media/images/defecto.png" />
					<%}else { %>
						
						<img src="/media/images/imagenes/usuarios/colaboradores/<%=dtC.getRutaImg()%>.jpg" />
					<%}%>

				</div>
				<div class="derechauser">
					<div >
						<table
							class="table table-condensed table-responsive table-user-information ">
							<tbody>
								<tr>
									<td>Nickname:</td>
									<td><%=	dtC.getNickName()%></td>
								</tr>
								<tr>
									<td>Email:</td>
									<td><%=	dtC.getEmail()%></td>
								</tr>
								<tr>
									<td>Fecha de nacimiento:</td>
									<td><%=
											new SimpleDateFormat("dd/MM/yyyy").format(dtC.getFechaNacimiento().getTime())
										%></td>
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
				<a href="<%="mailto:" + dtC.getEmail()%>"><button
						class="btn btn-success meilito" type="button"
						data-original-title="Send message to user">
						<img class="emailboton" src="/media/images/email.png">
					</button></a>
			</div>
		</div>
	</div>
	</div>


	<%	} %>
	<script src="/media/styles/userProfile.css"></script>
	<div class="footer">
		<jsp:include page="/WEB-INF/template/footer.jsp" />
	</div>
</body>
</html>