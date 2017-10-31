<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page errorPage="/WEB-INF/500.jsp" %>
<!doctype html>
<html>
   <head>
	   <jsp:include page="/WEB-INF/template/head.jsp"/>
	</head>
	<!-- VENTANA MODAL -->
	<div class="modal fade" id="excepcion"  aria-labelledby="excepcion">
		<div class="modal-dialog">
			<div class="modal-content">
				<!--  Header de la ventana -->
				<div class="modal-header">
					<h4 class="modal-title"><%= request.getAttribute("excepcionTitulo") %></h4>
					<button type="button" class="close" data-dismiss="modal"
						arial-hidden="true">&times;</button>

				</div>
				<!--  Contenido de la ventana-->
				<div class="modal-body">
					<p><%= request.getAttribute("excepcionMensaje") %></p>
				</div>
				<!--  Fotter de la ventana-->
				<div class="modal-footer">
					<button type="button" class="btn btn-success" data-dismiss="modal">Cerrar</button>
				</div>
			</div>
		</div>
	</div>
</body>
	

</html>
