<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<div class="modal fade" id="aviso" aria-labelledby="aviso">
	<div class="modal-dialog">
		<div class="modal-content">
			<!--  Header de la ventana -->
			<div class="modal-header">
				<h4 class="modal-title">Colaboración paga</h4>
				<button type="button" class="close" data-dismiss="modal"
					arial-hidden="true">&times;</button>

			</div>			
			<!--  Body de la ventana-->
			<div class="modal-body">
				<p>
				La colaboración se ha pagado con éxito.<br>
				¿Desea una notificación de pago via e-mail?
				</p>
			</div>
			<!--  Fotter de la ventana-->
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">No</button>
				<button type="button" id="btnConstancia" data-dismiss="modal" class="btn btn-primary">Sí</button>
			</div>
		</div>
	</div>
</div>