<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<div class="modal fade" id="aviso" aria-labelledby="aviso">
	<div class="modal-dialog">
		<div class="modal-content">
			<!--  Header de la ventana -->
			<div class="modal-header">
				<h4 class="modal-title">Colaboraci�n paga</h4>
				<button type="button" class="close" data-dismiss="modal"
					arial-hidden="true">&times;</button>

			</div>			
			<!--  Body de la ventana-->
			<div class="modal-body">
				<p>
				La colaboraci�n se ha pagado con �xito.<br>
				�Desea una notificaci�n de pago via e-mail?
				</p>
			</div>
			<!--  Fotter de la ventana-->
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">No</button>
				<button type="button" id="btnConstancia" data-dismiss="modal" class="btn btn-primary">S�</button>
			</div>
		</div>
	</div>
</div>