<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="/WEB-INF/500.jsp"%>
<!doctype html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<jsp:include page="/WEB-INF/template/head.jsp" />

<title>Iniciar sesión | Culturarte</title>
</head>
<body class="iniciofooter">

	<jsp:include page="/WEB-INF/template/header.jsp" />

	<div class="iniciofooter">
	<jsp:include page="/WEB-INF/template/footer.jsp"/>
	</div>
	
</body>
<script src="/media/Data-picker/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" href="/media/Data-picker/css/bootstrap-datepicker.css" />

<script src="/media/app.js"></script>
<script>
	function mostrarinformacion() {
		document.getElementById('panelProponente').style.display = "block";
	}
	function ocultarinformacion() {
		document.getElementById('panelProponente').style.display = "none";
	}
</script>

<script type="text/javascript">
$('#password, #confirm_password').on('keyup', function () {
	  if ($('#password').val() == $('#confirm_password').val()) {
	    $('#message').html('Correcto').css('color', 'green');
	  } else 
	    $('#message').html('No coinciden').css('color', 'red');
	});
</script>


</html>
