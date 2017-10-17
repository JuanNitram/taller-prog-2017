<%-- 
    Document   : listar
    Author     : Igui
--%>
<%@page import="dataTypes.DtPropuesta"%>
<%@page import="dataTypes.DtUsuario"%>
<%@page import="dataTypes.DtCategoria"%>
<%@page import="dataTypes.TEstado"%>
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
    <body id="listaimage">
	<jsp:include page="/WEB-INF/template/header.jsp" />
	<div id="listar" class="main">
			<% 
				String espacio = " ";
				String precio = "$ ";
				ArrayList<DtPropuesta> propuestas = (ArrayList<DtPropuesta>)request.getAttribute("propuestas");

				for(DtPropuesta propuesta: propuestas){
			%>
			<div class="usuario">
				<div class="izquierdaimg">
					<% if (propuesta.getRutaImg() == ""){ %>
						<img src="\media\images\no-image.png" />
					<%}else { %>
						<img src="/media/images/imagenes/propuestas/<%=propuesta.getRutaImg() %>.jpg" />
					<%}%>
				</div>
				<div class="derecha" ><p>
					<a class="titulo" href="consultaPropuesta?propuesta=<%= propuesta.getTitulo()  %>">
						<h3><%= propuesta.getTitulo() %></h3> </a>
						<br>
					<% DtUsuario user = (DtUsuario) (Login.getUsuarioLogueado(request));
						if (user!=null && !Fabrica.getInstance().getICtrlUsuario().esProponente(user.getNickName())){
					%>		
						<span class="registrarcolaboracion">
						<a href="nuevaColaboracion?propuesta=<%= propuesta.getTitulo() %>">Registrar Colaboracion</a>
						</span>
					<% 	}%>
						<span class="text-color"> Proponente: 
						<%=Fabrica.getInstance().getICtrlUsuario().infoProponente(propuesta.getNickProponente()).getNombre()%>	
						<%=espacio%>
						<%=Fabrica.getInstance().getICtrlUsuario().infoProponente(propuesta.getNickProponente()).getApellido()%>		
						</span>
						<br>
						<span class="email text-color"> Categoria: 
						<%= propuesta.getTitulo() %>
						</span>
						<br>
						<span class="email text-color"> Estado: 
						<%= propuesta.getEstado().toString() %>
						</span>
						<br>
						<span class="email text-color"> Precio Entrada: 
						<%= precio %>
						<%= propuesta.getPrecioEntrada() %>
						</span>	</p>
				</div>
			</div>		
			<% } %>
		</div>
		
		<div class="footer">
		<jsp:include page="/WEB-INF/template/footer.jsp"/>
		</div>
</body>
</html>