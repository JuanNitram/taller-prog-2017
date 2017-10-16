<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="dataTypes.DtProponente" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="dataTypes.DtColaborador" %>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	   <jsp:include page="/WEB-INF/template/head.jsp"/>
	<title>Usuarios :: gamebook</title>
    </head>
<body>
<jsp:include page="/WEB-INF/template/header.jsp" />
<br><br>
<%
		if(request.getAttribute("usr") instanceof DtProponente){
			DtProponente dtP = (DtProponente)(request.getAttribute("usr"));
%>
<div class ="main">
<div class="container">
 <div class="well span8 offset2">
        <div class="row-fluid user-row">
            <div class="span10">
                <span class="text-color">Nivel: Proponente</span>
            </div>
        </div>
        <div class="row-fluid text-color" >
            <div class="span8 offset1">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title text-color"><%=	dtP.getNombre().concat(" ").concat(dtP.getApellido())%></h3>
                    </div>
                    <div class="panel-body">
                        <div class="row-fluid">
                            <div class="span3">
                                <img class="img-circle"
                                     src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=100"
                                     alt="User Pic">
                            </div>
                            <hr style="width: 1px; height: 1px; display: inline-block;">-
                            <div class="span6" >
                                <table class="table table-condensed table-responsive table-user-information">
                                    <tbody>
                                    <tr>
                                        <td>Nickname: </td>
                                        <td><%=	dtP.getNickName()%></td>
                                    </tr>
                                    <tr>
                                        <td>Email: </td>
                                        <td><%=	dtP.getEmail()%></td>
                                    </tr>
                                    <tr>
                                        <td>Fecha de nacimiento: </td>
										<td><%=
											new SimpleDateFormat("dd/MM/yyyy").format(dtP.getFechaNacimiento().getTime())
										%></td>
										</tr>
                                    <tr>
                                        <td>Direccion: </td>
                                        <td><%=	dtP.getDireccion()%></td>
                                    </tr>
                                    <tr>
                                        <td>Biografia: </td>
                                        <td><%=	dtP.getBiografia()%></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="panel-footer">
                        <a href="<%=dtP.getLinkSitio()%>"><button class="btn btn-danger meilito" type="button"
                                data-original-title="Send message to user"><img class="emailboton" src="/media/images/link.png" > </i></button></a>
                   		<a href="<%="mailto:" + dtP.getEmail()%>"><button class="btn btn-success meilito" type="button"
                                data-original-title="Send message to user"><img class="emailboton" src="/media/images/email.png" > </i></button></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<% } else if(request.getAttribute("usr") instanceof DtColaborador){ 
	DtColaborador dtC = (DtColaborador)(request.getAttribute("usr")); %>	 
<div class ="main">
<div class="container">
 <div class="well span8 offset2">
        <div class="row-fluid user-row">
            <div class="span10">
                <span class="text-color">Nivel: Colaborador</span>
            </div>
        </div>
        
        <div class="row-fluid user-infos cyruxx text-color" >
            <div class="span10 offset1">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title text-color"><%=	dtC.getNombre().concat(" ").concat(dtC.getApellido())%></h3>
                    </div>
                    <div class="panel-body">
                        <div class="row-fluid">
                            <div class="span6">
                                <img class="img-circle"
                                     src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=100"
                                     alt="User Pic">
                            </div>
                            <hr style="width: 1px; height: 5px; display: inline-block;">
                            <div class="span6">
                                <table class="table table-condensed table-responsive table-user-information">
                                    <tbody>
                                    <tr>
                                        <td>Nickname: </td>
                                        <td><%=	dtC.getNickName()%></td>
                                    </tr>
                                    <tr>
                                        <td>Email: </td>
                                        <td><%=	dtC.getEmail()%></td>
                                    </tr>
                                    <tr>
                                        <td>Fecha de nacimiento: </td>
										<td><%=
											new SimpleDateFormat("dd/MM/yyyy").format(dtC.getFechaNacimiento().getTime())
										%></td>
										</tr>
                                   
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="panel-footer">
                   		<a href="<%="mailto:" + dtC.getEmail()%>"><button class="btn btn-success meilito" type="button"
                                data-original-title="Send message to user"><img class="emailboton" src="/media/images/email.png" > </i></button></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
	<%	} %>
<jsp:include page="/WEB-INF/template/footer.jsp" />
</body>
</html>