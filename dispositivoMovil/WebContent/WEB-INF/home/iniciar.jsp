<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.culturarte.controllers.Home"%>
<%@page import="com.culturarte.model.EstadoSesion"%>
<%@page errorPage="/WEB-INF/500.jsp"%>
<!doctype html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<link rel="stylesheet" href="/CulturarteWeb/media/fonts/font-awesome-4.7.0/css/font-awesome.min.css">

<title>Culturarte</title>
</head>
<body class="iniciofooter">
 	
	<jsp:include page="/WEB-INF/template/header.jsp" />
	<%	if (!Home.getEstado(request).equals(EstadoSesion.LOGIN_CORRECTO)){	
		%>
	
		<div class="panel-body" id="iniciar">
					<form action="login?action=iniciar" method="POST">
						<div class="form-group">
							<div class="input-group">
								<div class="input-group-addon"><i class="fa fa-user"></i></div>
								<input class="form-control" type="text" name="login" />
							</div>
							<br/>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon"><i class="fa fa-lock"></i></div>
									<input class="form-control" type="password" name="password"/>
								</div>
							</div>
							<button type="button" class="btn btn-primary" onclick="submit();">Iniciar</button>
						</div>
					</form>
				</div>
		<%} %>
	<div class="iniciofooter">	
		<jsp:include page="/WEB-INF/template/footer.jsp"/>
	</div>
</body>
</html>
