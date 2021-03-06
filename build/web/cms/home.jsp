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
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
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
                    <th scope="col">Fotos</th>
                  </tr>
                </thead>
                <tbody id="corpoTabela">
                                 
                </tbody>
              </table>

            <div id="div1"></div>
        </section>
        
        <!-- fecha  sessão principal do corpo do sistema -->
        
        
        
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLabel">Fotos do Produto</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body porta-fotos">
                <iframe class="modal-iframe">
                    
                </iframe>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
            </div>
          </div>
        </div>
      </div>
        
    </body>
    <script src="js/jquery.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="bootstrap/js/bootstrap-confirmation.min.js"></script>
    
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
                   var idTrash = 'colTrash'+count;
                   div.innerHTML =prev + "<tr>\n\
                                            <td>"+ valor.idProduto +"</td>\n\
                                            <td id='"+idNome+"' ondblclick=\"editaColuna('"+valor.idProduto+"','"+idNome+"')\">" + valor.produtoNm +"</td>\n\
\n\                                         <td id='"+idDesc+"' ondblclick=\"editaColuna('"+valor.idProduto+"','"+idDesc+"')\">" + valor.produtoDesc +"</td>\n\
\n\                                         <td onClick='excluir("+valor.idProduto+",\""+idTrash+"\")'><i id='"+idTrash+"' data-toggle=\"confirmation\" class='far fa-trash-alt'></i></td>\n\
\n\                                         <td><i class='far fa-images' data-toggle='modal' data-target='#exampleModal' data-nm='"+valor.produtoNm+"' data-id='"+valor.idProduto+"' ></i></td>\n\
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
               if(data>0){
                   document.getElementById(idColunaEmEdicao).innerHTML = input.value;
                   this.idProduto = 0;
                   this.idColunaEmEdicao = null;
                }else{
                    alert("Erro ao altera os dados!");
                }    
           });
       }
       function excluir(id,col){
           //abrindo o balão de confirmação
           $("#"+col).confirmation({
               buttons:[
                   {
                       class:'btn btn-danger',
                       label: 'Manda bala'
                   },
                   {
                       class:'btn btn-secondary',
                       label: 'Não',
                       cancel:true
                   }
               ],
               title:'Tem certeza?',
               content:'Não pode ser desfeito',               
               rootSelector: '[data-toggle=confirmation]',
               popout:true,
               singleton:true,
               onConfirm: function(value){
                   $.ajax({
                        url : "dados",
                        data : {"idProduto":id,"acao":"excluir"}
                    }).done(function(data){
                        if(data>0){
                            alert("Excluido com sucesso");
                         }else{
                             alert("Erro ao altera os dados!");
                         }    
                    });
               }
           }).confirmation('show');
           
       }
       $('#exampleModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget) // Button that triggered the modal
        var recipient = button.data('nm') // Extract info from data-* attributes
        // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
        // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
        var modal = $(this)
        modal.find('.modal-title').text(modal.find('.modal-title').text() +" - " + recipient)
        $('.modal-iframe').prop("src","fotos?id="+button.data('id'));
  })    
    </script>
</html>
