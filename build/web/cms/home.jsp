<%
  //checando se o cabra está logado
  HttpSession sessao  = request.getSession();
  
  if(sessao.getAttribute("idUsuario") != null){
      Integer idUsuario = (Integer) sessao.getAttribute("idUsuario");
      if(idUsuario == 0){
          response.sendRedirect("index.jsp");
      }
  }else{
      response.sendRedirect("index.jsp");
  }
%>    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/principal.css">
        <title>HOME - CMS - Destruction Inteligence 1.0</title>
        
    </head>
    <body>
        
        <!-- nav bar -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">Destruction Inteligence - CMS</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                  <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Dropdown
                  </a>
                  <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">Action</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Something else here</a>
                  </div>
                </li>
                <li class="nav-item">
                  <a class="nav-link disabled" href="#">Disabled</a>
                </li>
              </ul>
              <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
              </form>
            </div>
          </nav>
        <!-- fecha a nav bar -->
        
        <!-- abre a sessão principal do corpo do sistema -->
        <section class="container corpo">
            <table class="table">
                <thead class="thead-dark">
                  <tr>
                    <th scope="col">#</th>
                    <th scope="col">Nome</th>
                    <th scope="col">Descrição</th>
                    <th scope="col">Del</th>
                  </tr>
                </thead>
                <tbody id="corpoTabela">
                                 
                </tbody>
              </table>

            <div id="div1"></div>
        </section>
        
        <!-- fecha  sessão principal do corpo do sistema -->
        
    </body>
    <script src="js/jquery.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script>
        var idProduto = 0;
        var idColunaEmEdicao = null;
        
       $(document).ready(function() {
           carregaDados();
       });
       
       function carregaDados(){
           $.ajax({
               url:"dados"
           }).done(function(data){
               dados = JSON.parse(data);
               //alert(dados.data.length);
               count=1;
               $.each(dados.data,function(indice,valor){
                   //alert(valor.idProduto + "--" + valor.produtoNm);
                   var div = document.getElementById('corpoTabela');
                   var prev = div.innerHTML;
                   var idNome = 'colNm'+ count;
                   var idDesc = 'colDesc'+count;
                   div.innerHTML =prev + "<tr>\n\
                                            <td>"+ valor.idProduto +"</td>\n\
                                            <td id='"+idNome+"' ondblclick=\"editaColuna('"+valor.idProduto+"','"+idNome+"')\">" + valor.produtoNm +"</td>\n\
\n\                                         <td id='"+idDesc+"' ondblclick=\"editaColuna('"+valor.idProduto+"','"+idDesc+"')\">" + valor.produtoDesc +"</td>\n\
\n\                                         <td>x</td>\n\
\n\                                     </tr>";
                   count++;
               });
           });
       }
       function editaColuna(idP, idCol){
           idProduto = idP;
           idColunaEmEdicao = idCol;
           
           var div = document.getElementById(idCol);
           div.innerHTML = "<input type='text' onBlur='salvaAlteracao(this)' value='"+div.innerHTML+"'>";
           div.getElementsByTagName("input")[0].focus();
       }
       function salvaAlteracao(input){
           //alert(input.value + "-" + id);
           $.ajax({
               url : "dados",
               data : {"idProduto":idProduto,"valor":input.value,"col":idColunaEmEdicao,"acao":"salvaUp"}
           }).done(function(data){
               alert(data);
           });
       }
    </script>
</html>
