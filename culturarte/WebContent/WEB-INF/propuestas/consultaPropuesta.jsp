<%@page import="dataTypes.TRetorno"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Logica.Fabrica" %>
<%@page import="dataTypes.DtProponente" %>
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
                                    	<%=request.getAttribute("descripcion") %>
                                    </tr>
                                    <tbody>
                                    <tr>
                                        <td>Lugar: </td>
                                        <td><%= request.getAttribute("lugar") %></td>
                                    </tr>
                                    <tr>
                                        <td>Proponente: </td>
                                        <%
                                        	DtProponente proponente = Fabrica
                                            		.getInstance()
                                            		.getICtrlUsuario()
                                            		.infoProponente((String)(request.getAttribute("proponente")));
                                        	String strProp = proponente.getNombre();
                                        	strProp += " " + proponente.getApellido();
                                        	strProp += " (" + proponente.getNickName() + ")";
										%>
                                        <td>
                                        	<a href="consultaUsuario?usuario=<%= proponente.getNickName() %>">
                                        		<%= strProp %>
                                        	</a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Estado:</td>
                                        <td><%= request.getAttribute("estado").toString().substring(0,1).toUpperCase() +  request.getAttribute("estado").toString().toLowerCase().substring(1).replace("_", " ") %></td>
                                    </tr>
                                    <tr>
                                        <td>Fecha de publicación:</td>
                                        <td><%= new SimpleDateFormat("dd/MM/yyyy").format(request.getAttribute("fechaPublicacion")) %></td>
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
                                        <%
                                        	String retorno = "Error al cargar el retorno";
                                        	if(request.getAttribute("tipoRetorno") == TRetorno.ENTRADA_GRATIS)
                                        		retorno = "Entradas gratis";
                                        	else if(request.getAttribute("tipoRetorno") == TRetorno.PORCENTAJE_GANANCIA)
                                            	retorno = "Porcentaje de ganancia";
                                        	else if(request.getAttribute("tipoRetorno") == TRetorno.PORCENTAJE_Y_ENTRADAS)
                                                retorno = "Porcentaje de Ganancia | Entradas gratis";
                                        %>
                                        <td><%= retorno %></td>
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
	<form action="RegistrarColaboracion" method="post">
	
	<h2 align="center"><font color="white">REGISTRAR COLABORACION</font></h2>
	
	<div class="form-group col-lg-4" align="left">
    	<label for="titulo"><font color="white">Monto</font></label>
    	<input name="txTitulo" type="text" required id="txTitulo" class="form-control" >
 	</div>
 	
 	
 	<div class = "form-group col-lg-4" align="left">
		<label for="select"><font color="white">Tipo Retorno</font></label>
		<select class="form-control" id="selectRetorno" name="selectRetorno">
				<option value="PORCENTAJE_GANANCIA">Porcentaje de ganancia</option>
				<option value="ENTRADA_GRATIS">Entradas gratis</option>
		</select>
	</div>
			
 	<div class="form-group col-lg-4 " align="center">
		<button type="submit" name="submit" id="submit" class="btn btn-default" >Registrar Colaboracion</button>
		<button type="reset" class="btn btn-default">Volver</button>
 	</div>
 	
 	</form>
</div>
</div>
 


<div class="footer">
		<jsp:include page="/WEB-INF/template/footer.jsp"/>
		</div>
</body>
</html>