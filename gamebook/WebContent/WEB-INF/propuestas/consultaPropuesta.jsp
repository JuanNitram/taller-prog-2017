<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="Logica.Fabrica" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
   <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	    <jsp:include page="/WEB-INF/template/head.jsp"/>
		<title>Consulta Propuesta :: Culturarte</title>
</head>
<body>
<jsp:include page="/WEB-INF/template/header.jsp"/>

 
<%= request.getAttribute("titulo")%>
<br>
<br>
<%= request.getAttribute("desc") %>
<br>
<br>
<%= request.getAttribute("lugar") %>
<br>
<%= request.getAttribute("fechaPrevista") %>
<br>
<%= request.getAttribute("precioEntrada") %>
<br>
<%= request.getAttribute("montoNecesario") %>
<br>
<%= request.getAttribute("tipoRetorno") %>
<br>	


<jsp:include page="/WEB-INF/template/footer.jsp"/>
</body>
</html>