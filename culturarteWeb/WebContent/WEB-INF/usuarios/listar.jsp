<%@page import="java.util.ArrayList"%>
<%@page import="java.util.SortedMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="/WEB-INF/errorPages/500.jsp"%>
<!doctype html>
<html>
	<% 		boolean bandera = false;
				servidor.PublicadorService service =  new servidor.PublicadorService();
				servidor.Publicador port = service.getPublicadorPort();
				ArrayList<servidor.DtUsuario> usuarios = (ArrayList<servidor.DtUsuario>)request.getAttribute("usuarios"); 
				SortedMap<Integer, servidor.DtUsuario> seguidores = (SortedMap<Integer, servidor.DtUsuario>)request.getAttribute("seguidores");
				%>
<head>
<jsp:include page="/WEB-INF/template/header.jsp" />
<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
<link rel="stylesheet" href="/CulturarteWeb/media/styles/slide.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>

<title>Usuarios | Culturarte</title>
</head>
<body id="listaimage">
<script>
setInterval(function(){ 
	   $("#siguiente").click();
	},3000);
</script>	

<div class="container">

  <div class='row ' style="margin-top:50px">
    <div class='col-md-offset-2 col-md-8' style="width: 50%;
  margin: 0 auto;">
    
      <div class="carousel slide main" data-ride="carousel"   id="quote-carousel"  >
      <div  style="text-align:center;color: white;border-bottom: 2px solid #CCCCCC;">
      <h1> <a class="left carousel-control" href="#quote-carousel" role="button" data-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
		    <span class="sr-only">Prev</span>  		</a>Ranking<a class="carousel-control right" id="siguiente" href="#quote-carousel" role="button" data-slide="next">
		  <span class="carousel-control-next-icon" aria-hidden="true"></span>
		    <span class="sr-only">Next</span>
		  </a>      </h1>
      </div>
        <!-- Bottom Carousel Indicators -->
        <ol class="carousel-indicators" >
        <%int i = 0; %>
        <li data-target="#quote-carousel" data-slide-to="<%=i%>" class="active"></li>
         <% if(seguidores.size() > 0) for (i = 1; i < seguidores.size(); i++){ %>
         	<li data-target="#quote-carousel" data-slide-to="<%=i%>"></li>
         <% }%>
        </ol>
        
        <!-- Carousel Slides / Quotes -->
        <div class="carousel-inner" role="listbox" >
        
         <% boolean first = true;
         	for (SortedMap.Entry<Integer,servidor.DtUsuario> e : seguidores.entrySet()){ 
         		if (first){%>
	          <!-- Quote 1 -->
	          <div class="carousel-item active">
	            <blockquote>
	              <div class="row">
	                <div class="col-sm-3 text-center">
	                <% first= false;
	                	if (e.getValue().getRutaImg() == ""){ %>
						<img src="/CulturarteWeb\media\images\defecto.png" />
						<%}else if (port.esProponente(e.getValue().getNickName())){ %>
							<img class="img-circle" src="/CulturarteWeb/media/images/imagenes/usuarios/proponentes/<%=e.getValue().getRutaImg() %>.jpg" style="width: 100px;height:100px;">
						<%}else { %>
							<img class="img-circle" src="/CulturarteWeb/media/images/imagenes/usuarios/colaboradores/<%=e.getValue().getRutaImg() %>.jpg" style="width: 100px;height:100px;">
						<% } %>	
	                  
	                </div>
	                
	                <div class="col-sm-9">
	                  <h1><a href="consultaUsuario?usuario=<%= e.getValue().getNickName() %>"> <%=e.getValue().getNombre() + " "+ e.getValue().getApellido() %></a></h1>
	                  
	                  <small class="text-color">Seguidores: <%=e.getKey()%></small>
	                </div>
	              </div>
	            </blockquote>
	          </div>
          <%} else{ %>
	          <div class="carousel-item">
	            <blockquote>
	              <div class="row">
	                <div class="col-sm-3 text-center">
	                <% if (e.getValue().getRutaImg() == ""){ %>
						<img src="/CulturarteWeb\media\images\defecto.png" />
						<%}else if (port.esProponente(e.getValue().getNickName())){ %>
							<img class="img-circle" src="/CulturarteWeb/media/images/imagenes/usuarios/proponentes/<%=e.getValue().getRutaImg() %>.jpg" style="width: 100px;height:100px;">
						<%}else { %>
							<img class="img-circle" src="/CulturarteWeb/media/images/imagenes/usuarios/colaboradores/<%=e.getValue().getRutaImg() %>.jpg" style="width: 100px;height:100px;">
						<% } %>	
	                  
	                </div>
	                
	                <div class="col-sm-9">
	                  <h1><a href="consultaUsuario?usuario=<%= e.getValue().getNickName() %>"> <%=e.getValue().getNombre() + " "+ e.getValue().getApellido() %></a></h1>
	                  
	                  <small  class="text-color">Seguidores: <%=e.getKey()%></small>
	                </div>
	              </div>
	            </blockquote>
	          </div>
         		
         	<%	} 
         	}%>
         
        </div>
        
        <!-- Carousel Buttons Next/Prev -->
         
        </div>  
       
  		                  
    </div>
  </div>
</div>
	<div id="listar" class="main">
	

			<%	for(servidor.DtUsuario usuario: usuarios){
			%>
		<div class="usuario">
			<% if (usuario.getRutaImg() == ""){ %>
				<img src="/CulturarteWeb\media\images\defecto.png" />
			<%}else if (port.esProponente(usuario.getNickName())){ %>
						<img src="/CulturarteWeb/media/images/imagenes/usuarios/proponentes/<%=usuario.getRutaImg() %>.jpg" />
					<%}else { %>
						<img src="/CulturarteWeb/media/images/imagenes/usuarios/colaboradores/<%=usuario.getRutaImg() %>.jpg" />
					<% } %>	
			<div class="derecha">
				<p>

					<a class="nombre"
						href="consultaUsuario?usuario=<%= usuario.getNickName()  %>">
						<%= usuario.getNombre() + " " + usuario.getApellido() %>
					</a> <a class="nombre"
						href="consultaUsuario?usuario=<%= usuario.getNickName()  %>">
						(<%=usuario.getNickName() %>)
					</a> <br> <span class="email text-color"> <%=usuario.getEmail() %>
					</span> <br>
					<% if (port.esProponente(usuario.getNickName())) {
						bandera = true;
						%>
					<span class="email text-color">Nivel: Proponente </span>
					<% } else { %>
					<%	bandera = false; %>
					<span class="email text-color">Nivel: Colaborador </span>
					<% } %>
				</p>
			</div>
		</div>
		<% } %>
	</div>

	
    });
	<div class="footer">
		<jsp:include page="/WEB-INF/template/footer.jsp" />
	</div>

</body>
</html>