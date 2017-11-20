<%@page import="javax.swing.tree.TreeNode"%>
<%@page import="java.util.List"%>
<%@page import="javax.swing.tree.TreeNode"%>
<%@page import="com.culturarte.controllers.Propuestas"%>
<%@page import="javax.swing.tree.DefaultMutableTreeNode"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.culturarte.controllers.Login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="/WEB-INF/errorPages/500.jsp"%>

<!doctype html>
<html>
<head>
<link href="/MobileDevice/media/styles/shop-homepage.css" rel="stylesheet">
<script src="/MobileDevice/recursos/jquery/jquery.js"></script>
<script src="/MobileDevice/recursos/bootstrap/css/bootstrap.css"></script>
<link href="/MobileDevice/recursos/bootstrap/css/bootstrap.css" rel="stylesheet">
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
	<% 
		servidor.PublicadorService service = new servidor.PublicadorService();
		servidor.Publicador port = service.getPublicadorPort();
		String actual = request.getParameter("filtro");
		String todos = "Todos";
	%>

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
									List<String> categorias = (ArrayList) port.listarCategorias().getDatos();
								%>
								<li><a href="propuestas">Todos</a></li>
								<%
									for (String s : categorias) {
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
						ArrayList<servidor.DtPropuesta> propuestas = (ArrayList<servidor.DtPropuesta>) request.getAttribute("propuestas");

						for (servidor.DtPropuesta propuesta : propuestas) {
							if (propuesta.getEstado() != servidor.TEstado.INGRESADA) {
					%>
					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<%
								if (propuesta.getRutaImg() == "") {
							%>
							<img class="card-img-top" src="/MobileDevice/media/images/no-image.png" />
							<%
								} else {
							%>
							<img class="card-img-top"
								src="/MobileDevice/media/images/imagenes/propuestas/<%=propuesta.getRutaImg()%>.jpg" />
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
									<%=port.infoProponente(propuesta.getNickProponente())
							.getNombre() + " " + port.infoProponente(propuesta.getNickProponente())
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