<%-- 
    Document   : listar
    Author     : Igui
--%>
<%@page import="dataTypes.DtPropuesta"%>
<%@page import="java.util.ArrayList"%>
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
				<img src="/media/images/defecto.gif" alt="foto"/>
				
				<div class="derecha">
					<a class="titulo" href="consultaPropuesta?propuesta=<%= propuesta.getTitulo()  %>">
						<%= propuesta.getTitulo() %>
					</a>
				</div>
			</div>		
			<% } %>
		</div>
		
		<jsp:include page="/WEB-INF/template/footer.jsp"/>
</body>
</html>