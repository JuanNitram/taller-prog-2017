<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Logica.Fabrica" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
   <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	    <jsp:include page="/WEB-INF/template/head.jsp"/>
		<title>Consulta Propuesta | Culturarte</title>
</head>
<body>
<jsp:include page="/WEB-INF/template/header.jsp"/>
<div class ="main">
<div class="container">
 <div class="well span8 offset2">
        <div class="row-fluid user-row">
        </div>
        <div class="row-fluid text-color" >
            <div class="span8 offset1">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title text-color"><%= request.getAttribute("titulo")%> (<%=request.getAttribute("categoria") %>)</h3>
                    </div>
                    <div class="panel-body">
                        <div class="row-fluid">
                         
                            <div class="span6" >
                                <table class="table table-condensed table-responsive table-user-information">
                                	<tr>
                                    	Descripcion: <%=request.getAttribute("descripcion") %>
                                    </tr>
                                    <tbody>
                                    <tr>
                                        <td>Lugar: </td>
                                        <td><%= request.getAttribute("lugar") %></td>
                                    </tr>
                                    <tr>
                                        <td>Fecha Prevista:</td>
                                        <td><%= new SimpleDateFormat("dd/MM/yyyy").format(request.getAttribute("fechaPrevista")) %></td>
                                    </tr>
                                    <tr>
                                        <td>Precio Entrada: </td>
										<td><%= "$ " + request.getAttribute("precioEntrada") %></td>
										</tr>
                                    <tr>
                                        <td>Monto Necesario: </td>
                                        <td><%="$ " + request.getAttribute("montoNecesario") %></td>
                                    </tr>
                                     <tr>
                                        <td>Monto Recaudado: </td>
                                        <td><%="$ " + request.getAttribute("montoRecaudado") %></td>
                                    </tr>
                                    <tr>
                                        <td>Tipo de retorno: </td>
                                        <td><%= request.getAttribute("tipoRetorno") %></td>
                                    </tr>
                                    
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
 


<div class="footer">
		<jsp:include page="/WEB-INF/template/footer.jsp"/>
		</div>
</body>
</html>