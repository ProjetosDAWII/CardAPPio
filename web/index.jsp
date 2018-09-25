<%@page import="model.Categoria"%>
<%@page import="java.util.List"%>
<%@page import="ado.CategoriaADO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/principal.css">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    </head>
    <body>
        
        <!-- abre o menu principal -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light menu">
            <a class="navbar-brand" href="#">
                <div class="logo">CardAPPio</div>
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                  <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>
                <%
                    List<Categoria> listaCategoria = (List<Categoria>) request.getAttribute("listaCategoria");
                    
                    for(Categoria c:listaCategoria){
                        %>
                            <li class="nav-item">
                                <a class="nav-link" href="entradas"><%= c.getCategoriaNm() %></a>
                            </li>
                        <%
                    }
                %>
                
              </ul>
              <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
              </form>
            </div>
          </nav>
        <!-- //fecha o menu principal -->        
        
        <section class="container fotos-destaque">
            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                  <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                  <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                  <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                  <div class="carousel-item active">
                    <img class="d-block w-100" src="img/f1.jpeg" alt="First slide">
                  </div>
                  <div class="carousel-item">
                    <img class="d-block w-100" src="img/f2.jpg" alt="Second slide">
                  </div>
                  <div class="carousel-item">
                    <img class="d-block w-100" src="img/f3.jpeg" alt="Third slide">
                  </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                  <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                  <span class="carousel-control-next-icon" aria-hidden="true"></span>
                  <span class="sr-only">Next</span>
                </a>
              </div>
        </section>
        <!-- abre o corpo do site -section1 -->
        <section class="container corpo">
            <div class="jumbotron">
                <h4>Bem-vindo ao <span>CardAPPio</span></h4>
            </div>    
        </section>
        <!-- //fecha o corpo do site -section1 -->
        
        
    </body>
    <script src="js/jquery.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
</html>
