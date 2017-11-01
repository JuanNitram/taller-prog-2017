<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href="media/bootstrap-toggle/doc/stylesheet.css" rel="stylesheet">
<link href="../media/bootstrap-toggle/css/bootstrap-toggle.css"
	rel="stylesheet">
<link href="../media/bootstrap-toggle/css/bootstrap3toggle.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>

<%
	if((boolean)(request.getAttribute("siguiendo"))) {
%>
	<input
		style="src: url(https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.css);"
		id="boton_seguir" name="boton_seguir" type="checkbox"
		data-toggle="toggle" data-on="Seguir"
		data-off="<i class='fa fa-check'></i> Siguiendo">
<% } else { %>
	<input
		style="src: url(https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.css);"
		checked id="boton_seguir" name="boton_seguir" type="checkbox"
		data-toggle="toggle" data-on="Seguir"
		data-off="<i class='fa fa-check'></i> Siguiendo">
<% } %>
