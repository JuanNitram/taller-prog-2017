<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="dataTypes.DtPropuesta"%>
<%@page import="Logica.Fabrica"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<jsp:include page="/WEB-INF/template/head.jsp" />
<title>Nueva Colaboracion :: Culturarte</title>
</head>
<body>
	<jsp:include page="/WEB-INF/template/header.jsp" />
	
	<%
		if (request.getSession().getAttribute("usuario_logueado") != null && Fabrica.getInstance().getICtrlUsuario().esProponente((String) request.getSession().getAttribute("usuario_logueado"))){
	%>
	
	<% 
		DtPropuesta dtP = (DtPropuesta) (request.getAttribute("propuesta"));
	%>

	<form action="RegistrarColaboracion" method="post">
		<div style="display: none">
			<p>
				Proponente:
				<%= dtP.getNickProponente() %></p>
			<p>
				TituloPrueba: <label for="tituloPropGrupo05">:</label> <input
					name="tituloPropGrupo05" type="text" value="<%=dtP.getTitulo()%>"
					readonly="readonly" required id="tituloPropGrupo05">
			</p>
		</div>

		<p>
			Titulo:
			<%= dtP.getTitulo() %></p>
		<p name="tituloPropGrupo05" id="tituloPropGrupo05"
			value="<%=dtP.getTitulo()%>">
			Propuesta:
			<%= dtP.getTitulo() %></p>

		<p>
			Descripcion:
			<%= dtP.getDescripcion() %></p>
		<p>
			Lugar:
			<%= dtP.getLugar() %></p>
		<p>
			Fecha de realización:
			<%= dtP.getFechaPublicacion() %></p>
		<p>
			Fecha de realización:
			<%= dtP.getFechaRealizacion() %></p>
		<p>
			Monto a reunir:
			<%= dtP.getMontoRequerido() %></p>
		<p>
			Precio de la entrada:
			<%= dtP.getPrecioEntrada() %></p>
		<p>
			Tipo Retorno <select id="TRetorno" name="TRetorno">

				<%
 		if(dtP.getTipoRetorno().toString().equals("PORCENTAJE_Y_ENTRADAS")) {
 	%>
				<option value="PORCENTAJE_GANANCIA">Porcentaje de ganancia</option>
				<option value="ENTRADA_GRATIS">Entradas gratis</option>

				<%
 		} else if(dtP.getTipoRetorno().toString().equals("PORCENTAJE_GANANCIA")) {	
  	%>
				<option value="PORCENTAJE_GANANCIA">Porcentaje de ganancia</option>
				<%
 		} else {	
  	%>
				<option value="ENTRADA_GRATIS">Entrada gratis</option>

				<%
 		}
  	%>
			</select>

		</p>

		<p>
			Monto <label for="txNickname">:</label> <input name="txtMonto"
				type="number" required id="txtMonto">
		</p>
		<input type="submit" onClick="submit()" name="submit" value="Enviar">
	</form>

	<div class="footer">
		<jsp:include page="/WEB-INF/template/footer.jsp"/>
		</div>
</body>
<%
	} else {
		request.setAttribute("excepcion", true);
		request.setAttribute("excepcionTitulo", "Registrar colaboraciones");
		request.setAttribute("excepcionMensaje", "Inicia sesión como colaborador para registrar colaboraciones.");	
		request.getRequestDispatcher("/home").forward(request, response);
	}
%>
</html>