<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="servidor.PublicadorService"%>
<%@page import="servidor.Publicador"%>
<%@page import="servidor.DtPropuesta"%>
<%@page import="servidor.DtColaborador"%>
<%@page import="servidor.DtColaboracion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<jsp:include page="/WEB-INF/template/header.jsp" />
	<div class="container">
		<br>
		<div class="panel-group" id="accordion">
		<%
			PublicadorService servicios = new PublicadorService();
			Publicador port = servicios.getPublicadorPort();
			DtColaborador dtC = port.infoColaborador((String)session.getAttribute("usuario_logueado"));
			ArrayList<DtColaboracion> colaboraciones = (ArrayList<DtColaboracion>) dtC.getColaboraciones();
			for (int i = 0; i < colaboraciones.size(); i++) {
				DtColaboracion dtColab = colaboraciones.get(i);
		%>
			<div class="panel" style="background-color:#343a40;">
				<div class="panel-heading">
					<h4 class="panel-title" style="font-size: 15px">
						<a data-toggle="collapse" data-parent="#accordion"
							href="#collapse<%=i+1%>"><font color="white"><%= dtColab.getTitulo() %></font></a>
					</h4>
				</div>
				<div id="collapse<%=i+1%>" class="panel-collapse panel-primary collapse panelDark">
					<div class="panel-body" style="background-color: #f5f5f5;">
						<%
							DtPropuesta dtProp = port.infoPropuesta(dtColab.getTitulo());
							if(dtProp.getRutaImg() != "") {
						%>
						<img style="width: 100%;"
							src="/media/images/imagenes/propuestas/<%=dtProp.getRutaImg()%>.jpg" />
						<%
							}
						%>
						<br>
						<br> Fecha:
						<%=new SimpleDateFormat("dd/MM/yyyy").format(dtColab.getFechaRealizacion())%>
						<br> Monto: $<%= dtColab.getMontoAporte() %>
						<br> <button type="button" class="btn btn-dark btn_pagar_colaboracion"
									style="margin-top:10px;" data-idColab="<%= dtColab.getId() %>" data-id="<%=i+1%>"
									data-target="#modalPagar" data-toggle="modal">Pagar colaboración</button>
						<br>
						<div id="panelPagar<%=i+1%>" style="display:none;">
							
						</div>
					</div>
				</div>
			</div>
			<%	} %>
		</div>
	</div>
	<jsp:include page="/WEB-INF/colaboracion/aviso.jsp" />
	<jsp:include page="/WEB-INF/colaboracion/modalPagar.jsp" />
	<script>
		$('document').ready(function(){
			$(".panelDark").on("hide.bs.collapse", function(){
				$(this).parent().css('background-color','#343a40');
			});
			$(".panelDark").on("show.bs.collapse", function(){
				$(this).parent().css('background-color','black');
			});
			$(".btn_pagar_colaboracion").click(function() {
				$('#btnModalPagar').data('idColab',$(this).data("idcolab"));
				$('#panelPagar'+$(this).data('id')).attr('style','display:block');
			});
			$('#btnConstancia').click(function() {
				$.ajax({
					type : 'POST',
					data : {
						action : 'notificacionEmail'
					},
					url : 'Colaboraciones',
					success : function() {
						
					}
				});
			});
		});
	</script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>