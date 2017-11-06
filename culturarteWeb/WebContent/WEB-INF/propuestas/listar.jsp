<%-- 
    Document   : listar
    Author     : Igui
--%>
<%@page import="com.culturarte.controllers.Home"%>
<%@page import="com.culturarte.model.EstadoSesion"%>
<%@page import="logica.clases.Propuesta"%>
<%@page import="javax.swing.tree.TreeNode"%>
<%@page import="dataTypes.DtPropuesta"%>
<%@page import="dataTypes.DtUsuario"%>
<%@page import="dataTypes.DtCategoria"%>
<%@page import="java.util.List"%>
<%@page import="javax.swing.tree.TreeNode"%>
<%@page import="logica.clases.Categoria"%>
<%@page import="com.culturarte.controllers.Propuestas"%>
<%@page import="dataTypes.TEstado"%>
<%@page import="logica.Fabrica"%>
<%@page import="javax.swing.tree.DefaultMutableTreeNode"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.culturarte.controllers.Login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="/WEB-INF/errorPages/500.jsp"%>

<!doctype html>
<html>
<head>
<link href="/media/styles/shop-homepage.css" rel="stylesheet">
<script src="/recursos/jquery/jquery.js"></script>
<script src="/recursos/bootstrap/css/bootstrap.css"></script>
<link href="recursos/bootstrap/css/bootstrap.css" rel="stylesheet">
<style>
.scrollable-menu {
    height: auto;
    max-height: 300px;
    overflow-x: hidden;
}
</style>
<title>Propuestas :: Culturarte</title>
<!-- <script type="text/javascript">
	$(document).ready(function(){
		$('li > a').click(function(){
			console.log("click");
			$.ajax({
				type : 'GET',
				data : {
					filtro : $(this).html(),
					action : "filtro"
				},
				url : 'propuestas',
				success : function(result) {
					$('#panelPropuestas').html(result);
				}
			});
		});
	});
</script> -->
</head>
<body id="listaimage">
	<jsp:include page="/WEB-INF/template/header.jsp" />

	<!-- Contenido -->
	<% String actual = request.getParameter("filtro");
	String todos = "Todos";%>




	<div class="container text-color">

		<div class="row ">

			<div class="col-lg-3 ">
				<div class="list-group">
					<div class="main">
						<h5>Categoria:</h5>
						<div class="btn-group">
							<%
								if (request.getParameter("filtro") == null || request.getParameter("filtro") == "") {
							%>

							<button type="button" class="btn btn-info dropdown-toggle"
								data-toggle="dropdown">Todos
								<span class="caret"></span>
							</button>
							<%
								} else {
							%>
							<button type="button" class="btn btn-info dropdown-toggle"
								data-toggle="dropdown"><%=request.getParameter("filtro")%>
								<span class="caret"></span>
							</button>
							<%
								}
							%>
							<ul class="dropdown-menu scrollable-menu" role="menu">
								<%
									DefaultMutableTreeNode raiz = Fabrica.getInstance().getICtrlPropuesta().listarCategorias();
									Propuestas.vaciarCategoriasList();
									Propuestas.recursivoTree(raiz);
								%>
								<li><a href="propuestas">Todos</a></li>
								<%
									for (TreeNode s : Propuestas.getCategoriasList()) {
								%>

								<li><a href="propuestas?filtro=<%=s.toString()%>"><%=s.toString()%></a></li>
								<%
									}
								%>
							</ul>

						</div>
					</div>
				</div>

			</div>

			<!-- /.col-lg-3 -->

			<div class="col-lg-9 main" id="proponentes">

				<div class="row">
					<%
						ArrayList<DtPropuesta> propuestas = (ArrayList<DtPropuesta>) request.getAttribute("propuestas");

						for (DtPropuesta propuesta : propuestas) {
							if (propuesta.getEstado() != TEstado.INGRESADA) {
					%>
					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<%
								if (propuesta.getRutaImg() == "") {
							%>
							<img class="card-img-top" src="\media\images\no-image.png" />
							<%
								} else {
							%>
							<img class="card-img-top"
								src="/media/images/imagenes/propuestas/<%=propuesta.getRutaImg()%>.jpg" />
							<%
								}
							%>

							<div class="card-body">
								<h4 class="card-title">
									<a class="titulo"
										href="consultaPropuesta?propuesta=<%=propuesta.getTitulo()%>">
										<h3><%=propuesta.getTitulo()%></h3>
									</a>
								</h4>
								<p class="card-text" Style="border-bottom: 1px solid #DDDDDD;">
									Precio de entrada: $<%=propuesta.getPrecioEntrada()%>
								</p>
								<p class="card-text" Style="border-bottom: 1px solid #DDDDDD;">
									Proponente:
									<%=Fabrica.getInstance().getICtrlUsuario().infoProponente(propuesta.getNickProponente())
							.getNombre() + " " + Fabrica.getInstance().getICtrlUsuario().infoProponente(propuesta.getNickProponente())
							.getApellido()%>
								</p>
								<p class="card-text" Style="border-bottom: 1px solid #DDDDDD;">
									Categoria:
									<%=propuesta.getCategoria().getNombre()%>
								</p>
								<p class="card-text" Style="border-bottom: 1px solid #DDDDDD;">
									Estado:
									<%=propuesta.getEstado().toString().substring(0, 1).toUpperCase()
							+ propuesta.getEstado().toString().toLowerCase().substring(1).replace("_", " ")%>

								</p>
							</div>
							<div class="card-footer">
							<%
							 	if(Home.getEstado(request).equals(EstadoSesion.LOGIN_CORRECTO)){
							 	  if(Fabrica.getInstance().getICtrlPropuesta().listarFavoritos(propuesta.getTitulo()).contains(Login.getUsuarioLogueado(request).getNickName())){
							 		  if(Fabrica.getInstance().getICtrlPropuesta().listarFavoritos(propuesta.getTitulo()).size()>1){
							 			  out.print("Tu y "+ Fabrica.getInstance().getICtrlPropuesta().listarFavoritos(propuesta.getTitulo()).size()+ " mas han marcado esta propuesta como favorito.");
							 		  }else
							 			  out.print("Has marcado esta propuesta como favorito");
							 	  }else{
							 		 if(Fabrica.getInstance().getICtrlPropuesta().listarFavoritos(propuesta.getTitulo()).size()>0){
							 			  out.print(Fabrica.getInstance().getICtrlPropuesta().listarFavoritos(propuesta.getTitulo()).size()+ " personas han marcado esta propuesta como favorito.");
							 		 }else
							 			  out.print("Nadie ha marcado esta propuesta como favorito");
							 	  }
							 		  
							 	}else{
							 		 if(Fabrica.getInstance().getICtrlPropuesta().listarFavoritos(propuesta.getTitulo()).size()>0){
							 			  out.print(Fabrica.getInstance().getICtrlPropuesta().listarFavoritos(propuesta.getTitulo()).size()+ " personas han marcado esta propuesta como favorito.");
							 		 }else{
							 			  out.print("Nadie ha marcado esta propuesta como favorito");
							 	   }
							 	   }
							 	   %>
							</div>
						</div>

					</div>

					<%
							}
						}
					%>
				</div>

				<!-- /.row -->

			</div>
			<!-- /.col-lg-9 -->

		</div>
		<!-- /.row -->

	</div>

	<!-- Contenido -->
	<!-- SCRIPT -->

	<div class="footer">
		<jsp:include page="/WEB-INF/template/footer.jsp" />
	</div>
</body>
</html>