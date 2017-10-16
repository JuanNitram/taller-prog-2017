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

	<form class="formulario_centrar main" action="iniciar-sesion" ACTION="POST">
		<div class="error">
		<b>La combinación de correo electrónico/contraseña es incorrecta.</b>
			<p>
				Asegurese de ingresar su usuario y contraseña correctamente
			</p>
		</div>

		<div class="fila_input">
			<label for="error_login">Correo: </label>
			<input id="error_login" type="text" name="login"/>
		</div>

		<div class="fila_input">
			<label for="error_password">Contraseña:</label>
			<input id="error_password" type="password" name="password"/>
		</div>

		<div class="fila_input">
			<input class="con_margen" type="button"
				   value="Entrar" onclick="submit()"/>
		</div>
	</form>

	<jsp:include page="/WEB-INF/template/footer.jsp"/>
</body>
</html>