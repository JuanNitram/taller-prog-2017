<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="dataTypes.DtProponente" %>
<%@page import="dataTypes.DtColaborador" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	   <jsp:include page="/WEB-INF/template/head.jsp"/>
	<title>Usuarios :: gamebook</title>
    </head>
<body>
<jsp:include page="/WEB-INF/template/header.jsp" />

	 
	<%
		if(request.getAttribute("usr") instanceof DtProponente){
			DtProponente dtP = (DtProponente)(request.getAttribute("usr"));
	%>
		<%=	dtP.getNickName() %><br>
		<%=	dtP.getNombre()%><br>
		<%=	dtP.getApellido()%><br>
		<%=	dtP.getDireccion()%><br>
		<%=	dtP.getBiografia()%><br>
		<%=	dtP.getFechaNacimiento().toString()%><br>
		<%=	dtP.getEmail()%><br>
		<%=	dtP.getLinkSitio()%><br>
		<%=	dtP.getRutaImg()%><br>
	<%
		} else if(request.getAttribute("usr") instanceof DtColaborador){ 
			DtColaborador dtC = (DtColaborador)(request.getAttribute("usr"));
	%>
			<%=dtC.getNickName()%><br>
			<%=dtC.getNombre()%><br>
			<%=	dtC.getApellido()%><br>
			<%=	dtC.getEmail()%><br>
			<%=	dtC.getFechaNacimiento().toString()%><br>
			<%=	dtC.getRutaImg()%><br>
	<%	} %>
<jsp:include page="/WEB-INF/template/footer.jsp" />
</body>
</html>