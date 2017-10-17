<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page errorPage="/WEB-INF/errorPages/500.jsp" %>
<!doctype html>
<html>
   <head>
	   <jsp:include page="/WEB-INF/template/head.jsp"/>
	<title>Iniciar sesión :: gamebook</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/template/header.jsp"/>

	<form class="formulario_centrar main">
		<div class="error">
		<b>Las contraseñas ingresadas no coinciden!</b>
			<p>
				Registro erróneo.
			</p>
		</div>

		<div class="fila_input"></div>

		<div class="fila_input"></div>

		<div class="fila_input">
			<input class="con_margen" type="button"
				   value="Regresar" onclick="goBack()"/>
		</div>
	</form>

	<div class="footer">
		<jsp:include page="/WEB-INF/template/footer.jsp"/>
		</div>
	
	<script>
		function goBack() {
			window.history.back();
		}	
	</script>
	
</body>
</html>