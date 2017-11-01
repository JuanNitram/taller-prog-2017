<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="/WEB-INF/errorPages/500.jsp"%>
<!doctype html>
<html>
<head>
<jsp:include page="/WEB-INF/template/head.jsp" />
<title>Iniciar sesión | Culturartek</title>
</head>
<body>
	<jsp:include page="/WEB-INF/template/header.jsp" />

	<form class="formulario_centrar main" action="iniciar-sesion"
		method="POST">
		<div>
			<b style="color: #F00;">La combinación de usuario/contraseña es incorrecta.</b>
			<p class="text-color">Asegurese de ingresar su usuario y contraseña correctamente.</p>
		</div>
		<br>
		<div class="fila_input text-color">
			<div class="input-group">
				<div class="input-group-addon">Nickname:</div>
				<input class="form-control"  id="error_login"
				type="text" name="login" />
			</div>
			
		</div>

		<div class="fila_input text-color">
			<div class="input-group">
				<div class="input-group-addon">Contraseña:</div>
				<input  class="form-control" id="error_password" type="password" name="password" />
			</div>
			
		</div>
		<br>
		<div class="fila_input">
			
			<input class="btn btn-success btn-block" type="button" value="Entrar"
				onclick="submit()" /> <input type="reset" name="reset"
				value="Restablecer" class="btn  btn-block">


		</div>
	</form>


	<div class="iniciofooter">
		<jsp:include page="/WEB-INF/template/footer.jsp" />
	</div>
</body>
</html>