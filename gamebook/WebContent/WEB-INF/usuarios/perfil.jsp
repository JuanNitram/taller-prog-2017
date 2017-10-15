<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page errorPage="/WEB-INF/errorPages/500.jsp" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="dataTypes.DtUsuario"%>
<!doctype html>
<html>
   <head>
	   <jsp:include page="/WEB-INF/template/head.jsp"/>
	<title>Perfil :: gamebook</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/template/header.jsp"/>

		<% DtUsuario usr = (DtUsuario) request.getAttribute("usuario"); %>
		
	<div id="perfil" class ="main">
		<div id="perfil_izquierda">
			<img src="media/images/defecto.gif" alt="imagen"/>
		</div>

		<div id="perfil_derecha">
			<div class="contenedor">
				<h2>Información básica</h2>
				<label class="rotulo">Nombre:</label>
				<label class="valor"><%= usr.getNombre() %></label>
				<br/>
				<label class="rotulo">Fecha de nacimiento:</label>
				<label class="valor">
					<%= 
						new SimpleDateFormat("dd/MM/yyyy").format(usr.getFechaNacimiento().getTime())
					%>
				</label>
			</div>

			<div class="contenedor">
				<h2>Información de contacto</h2>
				<label class="rotulo">Correo electrónico:</label>
				<label class="valor">
					<a href="mailto:<%= usr.getEmail() %>">
						<%= usr.getEmail() %>
					</a>
				</label>
			</div>
		</div>
	</div>
    
		<jsp:include page="/WEB-INF/template/footer.jsp"/>
</body>
</html>
