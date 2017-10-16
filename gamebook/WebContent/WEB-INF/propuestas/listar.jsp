<%-- 
    Document   : listar
    Author     : Igui
--%>
<%@page import="dataTypes.DtPropuesta"%>
<%@page import="dataTypes.DtUsuario"%>
<%@page import="Logica.Fabrica"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.Culturarte.controllers.Login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="/WEB-INF/errorPages/500.jsp" %>

<!doctype html>
<html>
   <head>
	   <jsp:include page="/WEB-INF/template/head.jsp"/>
	<title>Propuestas :: Culturarte</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/template/header.jsp"/>

		<div id="listar" class="main">
			<% 
				ArrayList<DtPropuesta> propuestas = (ArrayList<DtPropuesta>)request.getAttribute("propuestas");

				for(DtPropuesta propuesta: propuestas){
			%>
			<div class="usuario">
				<img src="/media/images/no-image.png" alt="foto"/>
				
				<div class="derecha">
					<a class="titulo" href="consultaPropuesta?propuesta=<%= propuesta.getTitulo()  %>">
						<%= propuesta.getTitulo() %>
						
					<% DtUsuario user = (DtUsuario) (Login.getUsuarioLogueado(request));
						if (user!=null && !Fabrica.getInstance().getICtrlUsuario().esProponente(user.getNickName())){
					%>		
						<span class="registrarcolaboracion">
						<a href="nuevaColaboracion?propuesta=<%= propuesta.getTitulo() %>">Registrar Colaboracion</a>
						</span>
					<% 	}%>
						
					
						
					
				</div>
			</div>		
			<% } %>
		</div>
		
		<jsp:include page="/WEB-INF/template/footer.jsp"/>
</body>
</html>