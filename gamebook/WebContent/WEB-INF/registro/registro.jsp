<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
   <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	    <jsp:include page="/WEB-INF/template/head.jsp"/>
		<title>Alta Usuario :: Culturarte</title>
</head>

<body>

	<jsp:include page="/WEB-INF/template/header.jsp"/>
	
	<form action="AltaUsuario" id="formUsuario" name="formUsuario" method="post">

	<p>Tipo de usuario:
    
    <input type="radio" name="TipoUsuario" value="Proponente" onClick="mostrarDatosProponente()">
    <label>Proponente</label>
  	
  	<input type="radio" name="TipoUsuario" value="Colaborador" onClick="ocultarDatosProponente()" checked>
  	<label>Colaborador</label>
	
	</p>


  <p>Nickname
    <label for="txNickname">:</label>
    <input name="txNickname" type="text" required id="txNickname">
  </p>
  <p>Nombre
    <label for="txNombre">:</label>
    <input name="txNombre" type="text" required id="txNombre">
  </p>
  <p>Apellido
    <label for="txApellido">:</label>
    <input name="txApellido" type="text" required id="txApellido">
  </p>
  <p>Fecha de nacimiento: 
    <label for="date">:</label>
    <input type="date" name="date" id="date">
  </p>
  <p>Email
    <label for="txEmail">:</label>
    <input name="txEmail" type="text" required id="txEmail">
  </p>
  <p>Contrase&ntilde;a
    <label for="txContrasenia">:</label>
    <input name="txContrasenia" type="password" required id="txContrasenia">
  </p>
  <p>Confirmaci&oacute;n de contrase&ntilde;a
    <label for="txConfContrasenia">:</label>
    <input name="txConfContrasenia" type="password" required id="txConfContrasenia">
  </p>
  <div id="panelProponente" style="display: none">
    <p>Direcci&oacute;n
      <label for="textfield13">:</label>
      <input name="txDireccion" type="text" id="textfield13">
    </p>
    <p>Biograf&iacute;a
      <label for="textfield14">:</label>
      <input name="txBiografia" type="text" id="textfield14">
    </p>
    <p>Link del sitio
      <label for="textfield15">:</label>
      <input name="txLinkSitio" type="text" id="textfield15">
    </p>
  </div>
  <p>
    <input type="submit" onClick="submit()" name="submit" value="Enviar">
    <input type="reset" name="reset" value="Restablecer">
    <br>
  </p>
</form>

<script>
	function ocultarDatosProponente() {
    	document.getElementById('panelProponente').style.display = "none";
	}
	function mostrarDatosProponente() {
    	document.getElementById('panelProponente').style.display = "block";
	}
	
</script>
								
<jsp:include page="/WEB-INF/template/footer.jsp"/>
</body>


</html>