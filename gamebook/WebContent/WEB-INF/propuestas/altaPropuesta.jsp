<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="Logica.Fabrica"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dataTypes.DtCategoria"%>
<%@ page import="javax.swing.tree.DefaultMutableTreeNode"%>
<%@ page import="javax.swing.tree.TreeModel"%>
<%@ page import="javax.swing.JTree"%>
<%@page import="com.Culturarte.controllers.AltaPropuesta"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="/WEB-INF/template/head.jsp" />
<title>Alta Propuesta :: Culturarte</title>
</head>
<body>
	<jsp:include page="/WEB-INF/template/header.jsp" />
<body>
	<form id="form1" name="form1" method="post" action="AltaPropuesta">

		<p>
			Categoría: <label for="select">:</label> <select id="selectCategoria"
				name="selectCategoria">

				<%
    	DefaultMutableTreeNode raiz = Fabrica.getInstance().getICtrlPropuesta().listarCategorias();
     	AltaPropuesta.recursivoTree(raiz);
    	
     	for(String s : new AltaPropuesta().getCategoriasList()) {
    %>
				<option value="<%=s%>">
					<%= s %></option>

				<%  } %>

			</select>

		</p>
		<p>
			<label for="txTitulo">Título de la propuesta:</label> <input
				name="txTitulo" type="text" required id="txTitulo">
		</p>
		<p>
			<label for="txDescripcion">Descripción: :</label> <input
				name="txDescripcion" type="text" required id="txDescripcion">
		</p>
		<p>
			<label for="txLugar">Lugar:</label> <input name="txLugar" type="text"
				required id="txLugar">
		</p>
		<p>
			<label for="txFechaPrevista">Fecha prevista:</label> <input
				name="txFechaPrevista" type="date" required id="txFechaPrevista">
		</p>
		<p>
			<label for="txMontoEntrada">Precio entrada:</label> <input
				name="txMontoEntrada" type="number" required id="txMontoEntrada">
		</p>
		<p>
			<label for="txMontoNecesario">Monto necesario:</label> <input
				name="txMontoNecesario" type="number" required id="txMontoNecesario">
		</p>
		<p>Tipo de Retorno:</p>
		<table width="200">
			<tr>
				<td><label> <input type="radio" name="rdTipoRetorno"
						value="entGratis" id="rdTipoRetorno_0"> Entradas gratis
				</label></td>
			</tr>
			<tr>
				<td><label> <input type="radio" name="rdTipoRetorno"
						value="porcGanancia" id="rdTipoRetorno_1"> Porcentaje
						ganancia
				</label></td>
			</tr>
			<tr>
				<td><label> <input type="radio" name="rdTipoRetorno"
						value="ambos" id="rdTipoRetorno_2"> Porcentaje y entradas
				</label></td>
			</tr>
		</table>
		<p>
			<input type="submit" name="submit" id="submit" value="Enviar">
			<input type="reset" name="reset" id="reset" value="Restablecer">
		</p>
	</form>
	<p>&nbsp;</p>



</body>



<div class="footer">
		<jsp:include page="/WEB-INF/template/footer.jsp"/>
		</div>
</body>
</html>