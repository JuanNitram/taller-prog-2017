<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page errorPage="/WEB-INF/500.jsp" %>
<!doctype html>
<html>
   <head>
	   <jsp:include page="/WEB-INF/template/head.jsp"/>
	</head>
	<!-- VENTANA MODAL -->
	<div class="modal fade" id="registro"  aria-labelledby="registro">
		<div class="modal-dialog">
			<div class="modal-content">
				<!--  Header de la ventana -->
				<div class="modal-header">
					<h4 class="modal-title">Registro</h4>
					<button type="button" class="close" data-dismiss="modal"
						arial-hidden="true">&times;</button>

				</div>
				<!--  Contenido de la ventana-->
				<div class="modal-body">
					<form action="iniciar-sesion" method="POST">
						<div class="form-group">
						<div class="input-group">
							<div class="input-group-addon">Nickname: </div>
							<input class="form-control" type="text" name="login"/>
						</div>
						<br/>
						<div class="form-group">
						<div class="input-group">
							<div class="input-group-addon">Contraseña: </div>
							<input class="form-control" type="password" name="password"/>
						</div>
				</div>

				</div>
				</form>
				<!--  Fotter de la ventana-->
				<div class="modal-footer">
					<button type="button" class="btn btn-success" data-dismiss="modal">Cerrar</button>
					<button type="button" class="btn btn-primary" onclick="submit()">Iniciar</button>
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
