<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<div class="modal fade" id="modalPagar"
	aria-labelledby="modalPagar">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<!--  Header de la ventana -->
			<div class="modal-header">
				<h4 class="modal-title">Pagar colaboración</h4>
				<button type="button" class="close" data-dismiss="modal"
					arial-hidden="true">&times;</button>

			</div>
			<div class="modal-body">
				<form action="" method="POST">
					<div class="panel-body">
						<div class="container">
							<div class="row">
								<div class="col-md-12">
									<div class="row">
										<div class=" form-group col-md-12">
											<input type="text" class="form-control" pattern="[1-9][0-9]*"
												id="montoPago" placeholder="Monto" required />
										</div>
									</div>
									<div class="panel-group" id="acordionTipoPago">
										<div class="panel panel-default" align="left">
											<div class="panel-heading">
												<h4 class="panel-title"
													style="font-size: 15px; font-color: black" align=left>
													<a data-toggle="collapse" data-parent="#acordionTipoPago"
														href="#collapseTarjeta"> <span
														class="glyphicon glyphicon-file"></span> <font
														color="black">Tarjeta de crédito</font></a>
												</h4>
											</div>
											<div id="collapseTarjeta" class="panel-collapse collapse">
												<div class="panel-body">
													<div class="row">
														<div class="col-md-12">
															<div class="form-group" align=left>
																Tipo:<select class="form-control" id="tipoTarjeta">
																	<option selected>Oca</option>
																	<option>Visa</option>
																	<option>Master</option>
																</select>
															</div>
														</div>
													</div>
													<div class="row">
														<div class="col-md-6">
															<div class="form-group">
																<input type="text" class="form-control"
																	id='titularTarjeta' placeholder="Titular" required />
															</div>
														</div>
														<div class="col-md-6">
															<div class="form-group">
																<input type="text" class="form-control" id="nroTarjeta"
																	placeholder="Número de tarjeta" required />
															</div>
														</div>
														<div class="col-md-6">
															<div class="form-group">
																<input type="text" class="form-control"
																	pattern="(0[1-9]|(1[0-2])/(1[8-9]|2[0-7])"
																	id="vencimientoTarjeta" placeholder="Vencimiento MM/AA"
																	required />
															</div>
														</div>
														<div class="col-md-6">
															<div class="form-group">
																<input type="text" class="form-control" id='cvcTarjeta'
																	placeholder="CVC" pattern="[0-9]{3,4}" required />
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="panel panel-default">
											<div class="panel-heading">
												<h4 class="panel-title" style="font-size: 15px" align=left>
													<a data-toggle="collapse" data-parent="#acordionTipoPago"
														href="#collapsePayPal"> <span
														class="glyphicon glyphicon-th-list"></span> <font
														color="black">PayPal</font></a>
												</h4>
											</div>
											<div id="collapsePayPal" class="panel-collapse collapse">
												<div class="panel-body">
													<div class="row">
														<div class="col-md-6">
															<div class="form-group">
																<input type="text" class="form-control"
																	id='titularPayPal' placeholder="Titular" required />
															</div>
														</div>
														<div class="col-md-6">
															<div class="form-group">
																<input type="text" class="form-control" id="nroPayPal"
																	placeholder="Número de cuenta" required />
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="panel panel-default">
											<div class="panel-heading">
												<h4 class="panel-title" style="font-size: 15px" align=left>
													<a data-toggle="collapse" data-parent="#acordionTipoPago"
														href="#collapseTransferencia"> <span
														class="glyphicon glyphicon-th-list"></span> <font
														color="black">Transferencia bancaria</font></a>
												</h4>
											</div>
											<div id="collapseTransferencia"
												class="panel-collapse collapse">
												<div class="panel-body">
													<div class="row">
														<div class="col-md-12">
															<div class="form-group">
																<input type="text" class="form-control"
																	id='titularTransferencia' placeholder="Titular" required />
															</div>
														</div>
													</div>
													<div class="row">
														<div class="col-xs-6 col-sm-6 col-md-6">
															<div class="form-group">
																<input type="text" class="form-control"
																	id="bancoTransferencia" placeholder="Nombre del banco"
																	required />
															</div>
														</div>
														<div class="col-xs-6 col-sm-6 col-md-6">
															<div class="form-group">
																<input type="text" class="form-control"
																	id="nroTransferencia" placeholder="Número de cuenta"
																	required />
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
			
					<!--  Fotter de la ventana-->
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
						<button type="button" id="btnModalPagar" class="btn btn-primary" data-target="#aviso" data-toggle="modal" data-dismiss="modal">Pagar</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<script>
	$('document').ready(function(){
		$(".collapse").on("show.bs.collapse", function(){
			if($(this).parent().parent().attr('id') == "acordionTipoPago")
				$('#btnModalPagar').data('tipo',$(this).attr('id'));
		});
		$(".collapse").on("hide.bs.collapse", function(){
			if($(this).parent().parent().attr('id') == "acordionTipoPago")
				$('#btnModalPagar').data('tipo',null);
		});
		$('#btnModalPagar').click(function(){
			if($(this).data('tipo') == 'collapseTarjeta')
				var data = {
					action : 'confirmaPagar',
					idColab : $('#btnModalPagar').data('idColab'),
					monto : $('#montoPago').val(),
					tipoPago : 'tarjeta',
					tipoTarjeta : $('#tipoTarjeta').val(),
					titular : $('#titular').val(),
					nroTarjeta : $('#nroTarjeta').val(),
					vencimiento : $('#vencimientoTarjeta').val(),
					cvc : $('#cvcTarjeta').val()
				};
			else if($(this).data('tipo') == 'collapsePayPal')
				var data = {
					action : 'confirmaPagar',
					idColab : $('#btnModalPagar').data('idColab'),
					monto : $('#montoPago').val(),
					tipoPago : 'paypal',
					nroPayPal : $('#nroPayPal').val(),
					titularPayPal : $('#titularPayPal').val()
				};
			else if($(this).data('tipo') == 'collapseTransferencia')
				var data = {
					action : 'confirmaPagar',
					idColab : $('#btnModalPagar').data('idColab'),
					monto : $('#montoPago').val(),
					tipoPago : 'transferencia',
					titularTransferencia : $('#titularTransferencia').val(),
					bancoTransferencia : $('#bancoTransferencia').val(),
					nroTransferencia : $('#nroTransferencia').val()
				};
			if($(this).data('tipo') != null && $(this).data('tipo') != "") {
				$.ajax({
					type : 'POST',
					data,
					url : 'Colaboraciones',
					success : function() {

					}
				});
			}
		});
	});
</script>