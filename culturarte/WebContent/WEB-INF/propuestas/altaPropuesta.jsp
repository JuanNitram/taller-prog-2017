<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="Logica.Fabrica"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dataTypes.DtCategoria"%>
<%@ page import="dataTypes.DtUsuario"%>
<%@ page import="javax.swing.tree.DefaultMutableTreeNode"%>
<%@ page import="javax.swing.tree.TreeNode"%>
<%@ page import="javax.swing.tree.TreeModel"%>
<%@ page import="javax.swing.JTree"%>
<%@page import="com.culturarte.controllers.Propuestas"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="/WEB-INF/template/head.jsp" />
<title>Registrar propuesta :: Culturarte</title>
</head>
<body>
	<jsp:include page="/WEB-INF/template/header.jsp" />
<body>
	<h1 align="center">REGISTRAR PROPUESTA</h1>
	<form id="form1" name="form1" method="post" action="AltaPropuesta">

<%
	if (request.getSession().getAttribute("usuario_logueado") != null && Fabrica.getInstance().getICtrlUsuario().esProponente((String) request.getSession().getAttribute("usuario_logueado"))){
%>
<div class="main" align="center">
	<div class="form-group col-lg-4" align="left">
    	<label for="titulo"><font color="white">Título</font></label>
    	<input name="txTitulo" type="text" required id="txTitulo" class="form-control" >
 	</div>

  	<div class="form-group col-lg-4 " align="left">
    	<label for="titulo" ><font color="white">Descripción</font></label>
    	<textarea name="txDescripcion" type="text" required id="txDescripcion" class="form-control input-normal"></textarea>
 	</div>
 	
 	<div class="form-group col-lg-4 " align="left">
    	<label for="titulo"><font color="white">Lugar</font></label>
    	<input name="txLugar" type="text" required id="txLugar" class="form-control input-normal"></input>
 	</div>
 	
 	<div class = "form-group col-lg-4" align="left">
		<label for="select"><font color="white">Categoría</font></label>
		<select class="form-control" id="selectCategoria" name="selectCategoria">
			<%
    		DefaultMutableTreeNode raiz = Fabrica.getInstance().getICtrlPropuesta().listarCategorias();
			Propuestas.vaciarCategoriasList();
     		Propuestas.recursivoTree(raiz);
     		for(TreeNode t : Propuestas.getCategoriasList()) {
    		%>
			<option value="<%=t.toString()%>">
			<%= t.toString() %></option>
			<%  } %>
		</select>
	</div>

 	<div class="form-group col-lg-4 " align="left">
    	<label for="precio"><font color="white">Precio de entrada</font></label>
    	<input name="txMontoEntrada" type="number" required id="txMontoEntrada" class="form-control input-normal"></input>
 	</div>

 	<div class="form-group col-lg-4 " align="left">
    	<label for="monto"><font color="white">Monto necesario</font></label>
    	<input name="txMontoNecesario" type="number" required id="txMontoNecesario" class="form-control input-normal"></input>
 	</div>
 	
 	<div class="form-group col-lg-4 " align="left">
    	<label for="monto"><font color="white">Fecha prevista</font></label>
    	<input name="txFechaPrevista" type="date" required id="txFechaPrevista" class="form-control input-normal" placeholder="dd/mm/aaaa"></input>
 	</div>
 	
 	<div class="form-group col-lg-4 " align="left">
    	<label for="monto"><font color="white">Tipo de retorno</font></label>
		<div class="radio">
  			<label><input type="radio" name="rdTipoRetorno" value="entGratis" id="rdTipoRetorno_0" checked="checked"><font color="white">Entrada Gratis</font></label>
		</div>
		<div class="radio">
  			<label><input type="radio" name="rdTipoRetorno" value="porcGanancia" id="rdTipoRetorno_1"><font color="white">Porcentaje Ganancia</font></label>
		</div>
		<div class="radio">
  			<label><input type="radio" name="rdTipoRetorno" value="ambos" id="rdTipoRetorno_2"><font color="white">Porcentaje Ganancias y Entradas Gratis</font></label>
		</div>
 	</div>

 	<div class="form-group col-lg-4 " align="center">
			<button type="submit" name="submit" id="submit" class="btn btn-default" >Aceptar</button>
			<button type="reset" class="btn btn-default">Limpiar campos</button>
 	</div>
 </div>
<%
	} else {
		request.setAttribute("excepcion", true);
		request.setAttribute("excepcionTitulo", "Registrar propuestas");
		request.setAttribute("excepcionMensaje", "Inicia sesión como proponente para registrar propuestas.");	
		request.getRequestDispatcher("/home").forward(request, response);
	}
%>

<div class="footer">
	<jsp:include page="/WEB-INF/template/footer.jsp"/>
</div>

</body>
</html>