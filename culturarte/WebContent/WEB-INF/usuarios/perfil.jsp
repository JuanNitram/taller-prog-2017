<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page errorPage="/WEB-INF/errorPages/500.jsp" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="dataTypes.DtProponente"%>
<%@page import="dataTypes.DtColaborador"%>
<!doctype html>
<html>
   <head>
	   <jsp:include page="/WEB-INF/template/head.jsp"/>
	<title>Perfil | Culturarte</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/template/header.jsp"/>
		
		<%
		String bienvenido = "Bienvenido ";
		if(request.getAttribute("usuario") instanceof DtProponente){
			DtProponente dtP = (DtProponente)(request.getAttribute("usuario"));
			%>
	<div class="well span8 offset2">
	<div class="panel">
		<div class="main text-color">
			<div class="panel-heading ">
				<h3 class="panel-title text-color"><%=	bienvenido.concat(dtP.getNombre().concat(" ").concat(dtP.getApellido()))%></h3>
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

		</div>
	</div>
	</div>

	<% } else if (request.getAttribute("usuario") instanceof DtColaborador){
		DtColaborador dtC = (DtColaborador)(request.getAttribute("usuario")); %>

	
<div class="well span8 offset2">
	<div class="panel">
		<div class="main text-color">
			<div class="panel-heading ">
				<h3 class="panel-title text-color"><%=	bienvenido.concat(dtC.getNombre().concat(" ").concat(dtC.getApellido()))%></h3>
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

			
		</div>
	</div>
	</div>
    <%	} %>
		<div class="iniciofooter">
	<jsp:include page="/WEB-INF/template/footer.jsp"/>
	</div>
</body>
</html>
