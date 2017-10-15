<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page errorPage="/WEB-INF/500.jsp" %>
<!doctype html>
<html>
   <head>
	   <jsp:include page="/WEB-INF/template/head.jsp"/>
	<title>Iniciar sesión :: gamebook</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/template/header.jsp"/>

	<!-- ejemplo de estilo CSS enbebido en la página -->
	<style type="text/css">
	.input_blur {
		font-style: italic;
		color:#808080;
	}
	</style>

	<script type="text/javascript">
		/// saca el blur a un elemento y lo resetear
		function sacarBlurReset(event)
		{
			event.target.setAttribute('class', "");
			event.target.value = "";
		}
	</script>

	<div class="contenedor_principal main">
		<div class="izquierda">
			<h2>Ingresa tus datos para iniciar sesión</h2>
		</div>
		<div class="derecha">
				<!-- formulario de login -->
				<form action="iniciar-sesion" method="POST">
			<input class="input_blur" type="text" name="login"
						   value="NickName..."	onMouseDown="sacarBlurReset(event);"/>
					<br/>
			<input type="password" name="password"/>
					<br/>
			<input type="button" value="Entrar" onclick="submit()"/>
			</form>
		</div>
	</div>

	<jsp:include page="/WEB-INF/template/footer.jsp"/>
</body>
</html>
