<%@page import="com.culturarte.controllers.Home"%>
<%@page import="com.culturarte.model.EstadoSesion"%>
<%@page import="javax.swing.tree.TreeNode"%>
<%@page import="java.util.List"%>
<%@page import="com.culturarte.controllers.Propuestas"%>
<%@page import="javax.swing.tree.DefaultMutableTreeNode"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.culturarte.controllers.Login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="/WEB-INF/errorPages/500.jsp"%>

<!doctype html>
<html>
<head>
<link href="/CulturarteWeb/media/styles/shop-homepage.css" rel="stylesheet">
<script src="/CulturarteWeb/recursos/jquery/jquery.js"></script>
<script src="/CulturarteWeb/recursos/bootstrap/css/bootstrap.css"></script>
<link href="/CulturarteWeb/recursos/bootstrap/css/bootstrap.css" rel="stylesheet">

<link href="/CulturarteWeb/media/styles/tabs.css" rel="stylesheet">


<style>
.scrollable-menu {
    height: auto;
    max-height: 300px;
    overflow-x: hidden;
}
.navegaciontab{
		margin-top: 50px;
		border-bottom: 2px solid #FFF;
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
<body id="listaimage" style="font-size:15px;">
	<jsp:include page="/WEB-INF/template/header.jsp" />

	<!-- Contenido -->
	
	<% 	

		String actual = request.getParameter("filtro");
		String todos = "Todos";
		servidor.PublicadorService service =  new servidor.PublicadorService();
		servidor.Publicador port = service.getPublicadorPort();
		servidor.DataList dtPs = port.listarPropuestas();
		List<servidor.DtPropuesta> propuestas = (ArrayList) dtPs.getDatos();
	%>

<script type="text/javascript">
function dodajAktywne(elem) {
    // get all 'a' elements
    var a = document.getElementsByTagName('a');
    // loop through all 'a' elements
    for (i = 1; i < a.length; i++) {
        // Remove the class 'active' if it exists
        a[i].classList.remove('active')
    }
    // add 'active' classs to the element that was clicked
    elem.classList.add('active');
}
</script>
<div class="container text-color" >	
<div class="row" >
<!-- Tab panels -->
<div class="tab-content" style="width: 100%">

<ul class="nav nav-pills nav-justified navegaciontab main" style="font-size: 14px">
    <li class="nav-item">
        <div class="btn-group">
							<%
								if (request.getParameter("filtro") == null || request.getParameter("filtro") == "") {
							%>

							<button type="button" class="btn btn-success dropdown-toggle" style="font-size: 14px"
								data-toggle="dropdown">Categorias
								<span class="caret"></span>
							</button>
							<%
								} else {
							%>
							<button type="button" class="btn btn-success dropdown-toggle"
								data-toggle="dropdown"><%=request.getParameter("filtro")%>
								<span class="caret"></span>
							</button>
							<%
								}
							%>
							<ul class="dropdown-menu scrollable-menu" role="menu">
								<%
									List<String> categorias = (ArrayList)service.getPublicadorPort().listarCategorias().getDatos();
								%>
								<li><a href="/CulturarteWeb/propuestas">Todos</a></li>
								<%
									for (String s : categorias) {
								%>

								<li><a href="/CulturarteWeb/propuestas?filtro=<%=s%>"><%=s%></a></li>
								<%
									}
								%>
							</ul>

						</div>
    </li>
    
    <li class="nav-item">
        <a class="nav-link active" data-toggle="tab" href="#panel1" role="tab"onclick="dodajAktywne(this)">Todas</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" data-toggle="tab" href="#panel2" role="tab"onclick="dodajAktywne(this)">Publicada</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" data-toggle="tab" href="#panel3" role="tab"onclick="dodajAktywne(this)">Financiada</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" data-toggle="tab" href="#panel4" role="tab"onclick="dodajAktywne(this)">No Financiada</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" data-toggle="tab" href="#panel5" role="tab"onclick="dodajAktywne(this)">En financiacion</a>
    </li>
    <li class="nav-item">
        <a class="nav-link " data-toggle="tab" href="#panel6" role="tab"onclick="dodajAktywne(this)">Cancelada</a>
    </li>
</ul>



	  

	
	
	
    <!--Panel 1-->
   <div class="tab-pane active" id="panel2" role="tabpanel">
        <br>
       <div class="col-lg-9 main" id="proponentes">

				<div class="row">
					<%

						for (servidor.DtPropuesta propuesta : propuestas) {
							if (propuesta.getEstado() != servidor.TEstado.INGRESADA) {
					%>
					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<%
								if (propuesta.getRutaImg() == "") {
							%>
							<img class="card-img-top" src="/CulturarteWeb\media\images\no-image.png" />
							<%
								} else {
							%>
							<img class="card-img-top"
								src="/CulturarteWeb/media/images/imagenes/propuestas/<%=propuesta.getRutaImg()%>.jpg" />
							<%
								}
							%>

							<div class="card-body">
								<h4 class="card-title">
									<a class="titulo"
										href="/CulturarteWeb/consultaPropuesta?propuesta=<%=propuesta.getTitulo()%>">
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
							<div class="card-footer">
							<%
								servidor.DataList dtF = port.listarFavoritos(propuesta.getTitulo());
								List<String> favoritas = (ArrayList) dtF.getDatos();
								
							 	if(Home.getEstado(request).equals(EstadoSesion.LOGIN_CORRECTO)){
									
							 	  if(favoritas.contains(Login.getUsuarioLogueado(request).getNickName())){
							 		  if(favoritas.size()>1){
							 			  out.print("Tu y "+ (favoritas.size() -1) + " personas mas han marcado esta propuesta como favorito.");
							 		  }else
							 			  out.print("Has marcado esta propuesta como favorito");
							 	  }else{
							 		 if(favoritas.size()>0){
							 			  out.print(favoritas.size()+ " personas han marcado esta propuesta como favorito.");
							 		 }else
							 			  out.print("Nadie ha marcado esta propuesta como favorito");
							 	  }
							 		  
							 	}else{
							 		 if(favoritas.size()>0){
							 			  out.print(favoritas.size()+ " personas han marcado esta propuesta como favorito.");
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
			
    </div>
    <!--/.Panel 1-->
    <!--Panel 2-->
    <div class="tab-pane fade" id="panel2" role="tabpanel">
        <br>
       <div class="col-lg-9 main" id="proponentes">

				<div class="row">
					<%

						for (servidor.DtPropuesta propuesta : propuestas) {
							if (propuesta.getEstado() != servidor.TEstado.INGRESADA && propuesta.getEstado() == servidor.TEstado.PUBLICADA) {
					%>
					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<%
								if (propuesta.getRutaImg() == "") {
							%>
							<img class="card-img-top" src="/CulturarteWeb\media\images\no-image.png" />
							<%
								} else {
							%>
							<img class="card-img-top"
								src="/CulturarteWeb/media/images/imagenes/propuestas/<%=propuesta.getRutaImg()%>.jpg" />
							<%
								}
							%>

							<div class="card-body">
								<h4 class="card-title">
									<a class="titulo"
										href="/CulturarteWeb/consultaPropuesta?propuesta=<%=propuesta.getTitulo()%>">
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
							<div class="card-footer">
							<%
								servidor.DataList dtF = port.listarFavoritos(propuesta.getTitulo());
								List<String> favoritas = (ArrayList) dtF.getDatos();
								
							 	if(Home.getEstado(request).equals(EstadoSesion.LOGIN_CORRECTO)){
									
							 	  if(favoritas.contains(Login.getUsuarioLogueado(request).getNickName())){
							 		  if(favoritas.size()>1){
							 			  out.print("Tu y "+ (favoritas.size() -1) + " personas mas han marcado esta propuesta como favorito.");
							 		  }else
							 			  out.print("Has marcado esta propuesta como favorito");
							 	  }else{
							 		 if(favoritas.size()>0){
							 			  out.print(favoritas.size()+ " personas han marcado esta propuesta como favorito.");
							 		 }else
							 			  out.print("Nadie ha marcado esta propuesta como favorito");
							 	  }
							 		  
							 	}else{
							 		 if(favoritas.size()>0){
							 			  out.print(favoritas.size()+ " personas han marcado esta propuesta como favorito.");
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
			
    </div>
    <!--/.Panel 2-->
    <!--Panel 3-->
    <div class="tab-pane fade" id="panel3" role="tabpanel">
         <br>
       <div class="col-lg-9 main" id="proponentes">

				<div class="row">
					<%

						for (servidor.DtPropuesta propuesta : propuestas) {
							if (propuesta.getEstado() != servidor.TEstado.INGRESADA && propuesta.getEstado() == servidor.TEstado.FINANCIADA) {
					%>
					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<%
								if (propuesta.getRutaImg() == "") {
							%>
							<img class="card-img-top" src="/CulturarteWeb\media\images\no-image.png" />
							<%
								} else {
							%>
							<img class="card-img-top"
								src="/CulturarteWeb/media/images/imagenes/propuestas/<%=propuesta.getRutaImg()%>.jpg" />
							<%
								}
							%>

							<div class="card-body">
								<h4 class="card-title">
									<a class="titulo"
										href="/CulturarteWeb/consultaPropuesta?propuesta=<%=propuesta.getTitulo()%>">
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
							<div class="card-footer">
							<%
								servidor.DataList dtF = port.listarFavoritos(propuesta.getTitulo());
								List<String> favoritas = (ArrayList) dtF.getDatos();
								
							 	if(Home.getEstado(request).equals(EstadoSesion.LOGIN_CORRECTO)){
									
							 	  if(favoritas.contains(Login.getUsuarioLogueado(request).getNickName())){
							 		  if(favoritas.size()>1){
							 			  out.print("Tu y "+ (favoritas.size() -1) + " personas mas han marcado esta propuesta como favorito.");
							 		  }else
							 			  out.print("Has marcado esta propuesta como favorito");
							 	  }else{
							 		 if(favoritas.size()>0){
							 			  out.print(favoritas.size()+ " personas han marcado esta propuesta como favorito.");
							 		 }else
							 			  out.print("Nadie ha marcado esta propuesta como favorito");
							 	  }
							 		  
							 	}else{
							 		 if(favoritas.size()>0){
							 			  out.print(favoritas.size()+ " personas han marcado esta propuesta como favorito.");
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
    </div>
    <div class="tab-pane fade" id="panel4" role="tabpanel">
         <br>
       <div class="col-lg-9 main" id="proponentes">

				<div class="row">
					<%

						for (servidor.DtPropuesta propuesta : propuestas) {
							if (propuesta.getEstado() != servidor.TEstado.INGRESADA && propuesta.getEstado() == servidor.TEstado.NO_FINANCIADA) {
					%>
					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<%
								if (propuesta.getRutaImg() == "") {
							%>
							<img class="card-img-top" src="/CulturarteWeb\media\images\no-image.png" />
							<%
								} else {
							%>
							<img class="card-img-top"
								src="/CulturarteWeb/media/images/imagenes/propuestas/<%=propuesta.getRutaImg()%>.jpg" />
							<%
								}
							%>

							<div class="card-body">
								<h4 class="card-title">
									<a class="titulo"
										href="/CulturarteWeb/consultaPropuesta?propuesta=<%=propuesta.getTitulo()%>">
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
							<div class="card-footer">
							<%
								servidor.DataList dtF = port.listarFavoritos(propuesta.getTitulo());
								List<String> favoritas = (ArrayList) dtF.getDatos();
								
							 	if(Home.getEstado(request).equals(EstadoSesion.LOGIN_CORRECTO)){
									
							 	  if(favoritas.contains(Login.getUsuarioLogueado(request).getNickName())){
							 		  if(favoritas.size()>1){
							 			  out.print("Tu y "+ (favoritas.size() -1) + " personas mas han marcado esta propuesta como favorito.");
							 		  }else
							 			  out.print("Has marcado esta propuesta como favorito");
							 	  }else{
							 		 if(favoritas.size()>0){
							 			  out.print(favoritas.size()+ " personas han marcado esta propuesta como favorito.");
							 		 }else
							 			  out.print("Nadie ha marcado esta propuesta como favorito");
							 	  }
							 		  
							 	}else{
							 		 if(favoritas.size()>0){
							 			  out.print(favoritas.size()+ " personas han marcado esta propuesta como favorito.");
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
    </div>
    <div class="tab-pane fade" id="panel5" role="tabpanel">
        <br>
       <div class="col-lg-9 main" id="proponentes">

				<div class="row">
					<%

						for (servidor.DtPropuesta propuesta : propuestas) {
							if (propuesta.getEstado() != servidor.TEstado.INGRESADA && propuesta.getEstado() == servidor.TEstado.EN_FINANCIACION) {
					%>
					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<%
								if (propuesta.getRutaImg() == "") {
							%>
							<img class="card-img-top" src="/CulturarteWeb\media\images\no-image.png" />
							<%
								} else {
							%>
							<img class="card-img-top"
								src="/CulturarteWeb/media/images/imagenes/propuestas/<%=propuesta.getRutaImg()%>.jpg" />
							<%
								}
							%>

							<div class="card-body">
								<h4 class="card-title">
									<a class="titulo"
										href="/CulturarteWeb/consultaPropuesta?propuesta=<%=propuesta.getTitulo()%>">
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
							<div class="card-footer">
							<%
								servidor.DataList dtF = port.listarFavoritos(propuesta.getTitulo());
								List<String> favoritas = (ArrayList) dtF.getDatos();
								
							 	if(Home.getEstado(request).equals(EstadoSesion.LOGIN_CORRECTO)){
									
							 	  if(favoritas.contains(Login.getUsuarioLogueado(request).getNickName())){
							 		  if(favoritas.size()>1){
							 			  out.print("Tu y "+ (favoritas.size() -1) + " personas mas han marcado esta propuesta como favorito.");
							 		  }else
							 			  out.print("Has marcado esta propuesta como favorito");
							 	  }else{
							 		 if(favoritas.size()>0){
							 			  out.print(favoritas.size()+ " personas han marcado esta propuesta como favorito.");
							 		 }else
							 			  out.print("Nadie ha marcado esta propuesta como favorito");
							 	  }
							 		  
							 	}else{
							 		 if(favoritas.size()>0){
							 			  out.print(favoritas.size()+ " personas han marcado esta propuesta como favorito.");
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
    </div>
    <div class="tab-pane fade" id="panel6" role="tabpanel">
        <br>
       <div class="col-lg-9 main" id="proponentes">

				<div class="row">
					<%

						for (servidor.DtPropuesta propuesta : propuestas) {
							if (propuesta.getEstado() != servidor.TEstado.INGRESADA && propuesta.getEstado() != servidor.TEstado.CANCELADA) {
					%>
					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<%
								if (propuesta.getRutaImg() == "") {
							%>
							<img class="card-img-top" src="/CulturarteWeb\media\images\no-image.png" />
							<%
								} else {
							%>
							<img class="card-img-top"
								src="/CulturarteWeb/media/images/imagenes/propuestas/<%=propuesta.getRutaImg()%>.jpg" />
							<%
								}
							%>

							<div class="card-body">
								<h4 class="card-title">
									<a class="titulo"
										href="/CulturarteWeb/consultaPropuesta?propuesta=<%=propuesta.getTitulo()%>">
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
							<div class="card-footer">
							<%
								servidor.DataList dtF = port.listarFavoritos(propuesta.getTitulo());
								List<String> favoritas = (ArrayList) dtF.getDatos();
								
							 	if(Home.getEstado(request).equals(EstadoSesion.LOGIN_CORRECTO)){
									
							 	  if(favoritas.contains(Login.getUsuarioLogueado(request).getNickName())){
							 		  if(favoritas.size()>1){
							 			  out.print("Tu y "+ (favoritas.size() -1) + " personas mas han marcado esta propuesta como favorito.");
							 		  }else
							 			  out.print("Has marcado esta propuesta como favorito");
							 	  }else{
							 		 if(favoritas.size()>0){
							 			  out.print(favoritas.size()+ " personas han marcado esta propuesta como favorito.");
							 		 }else
							 			  out.print("Nadie ha marcado esta propuesta como favorito");
							 	  }
							 		  
							 	}else{
							 		 if(favoritas.size()>0){
							 			  out.print(favoritas.size()+ " personas han marcado esta propuesta como favorito.");
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
    </div>
    <!--/.Panel 3-->
    
    <!-- /.col-lg-3 -->

			
			<!-- /.col-lg-9 -->
    
    
</div>

	</div>	
	</div>

	<!-- Contenido -->
	<!-- SCRIPT -->

	<div class="footer">
		<jsp:include page="/WEB-INF/template/footer.jsp" />
	</div>

</body>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

</html>