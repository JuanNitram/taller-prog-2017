<%-- 
    Document   : listar
    Author     : Igui
--%>
<%@page import="dataTypes.DtUsuario"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="/WEB-INF/errorPages/500.jsp" %>
<!doctype html>
<html>
   <head>
	   <jsp:include page="/WEB-INF/template/head.jsp"/>
	<title>Usuarios :: gamebook</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/template/header.jsp"/>

		<div id="listar" class="main">
			<% 
				ArrayList<DtUsuario> usuarios = (ArrayList<DtUsuario>)request.getAttribute("usuarios");

				for(DtUsuario usuario: usuarios){
			%>
			<div class="usuario">
				<img src="/media/images/defecto.png" alt="foto"/>
				
				<div class="derecha">
					<a class="nombre" href="consultaUsuario?usuario=<%= usuario.getNickName()  %>">
						<%= usuario.getNickName() %>
					</a>

					<span class="registrarcolaboracion text-color">
						<%= usuario.getNombre() %>
					</span>
					
					<span class="email text-color">
						<%= usuario.getEmail() %>
					</span>
				</div>
			</div>		
			<% } %>
		</div>
		
    
		<jsp:include page="/WEB-INF/template/footer.jsp"/>
</body>
</html>