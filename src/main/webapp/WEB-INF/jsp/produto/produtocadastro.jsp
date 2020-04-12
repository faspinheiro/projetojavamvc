<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br" xml:lang="pt-br">
<head>
	<meta charset="utf-8">
	<title>Projeto Java MVC - Cadastrar Produto</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">	
	<link rel="stylesheet" type="text/css" href="<c:url value="/estilos/estilo.css"/>">		
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">  		
</head>
<body>
<div id="container" class="container">
	<header id="cabecalho">
		<h1>App Pedido</h1>        
        <nav id="menu">
            <ul>
                <li><a href="/pedidos" title="Pedidos">PEDIDOS</a>  </li>
                <li><a href="/empresas" title="Empresas">EMPRESAS</a>  </li>
                <li><a href="/produtos" title="Produtos">PRODUTOS</a>  </li>                
            </ul>
        </nav>        
    </header>
    <main id="principal">
    <h2 class="title">Cadastrar Produto</h2>
    	<form class="form-horizontal" action="/produto/new" method="post">
	    	<div class="form-group">
		    	<label class="control-label col-sm-2" for="tipoProduto">Tipo de produto:</label>
		    	<div class="col-sm-10">
		    	<select class="form-control" onchange="selecionaTipo(this.value)" id="tipoProduto" name="tipoProduto" required>
		    	<option value="" selected></option>
		    	<option value="Bebida">Bebida</option>
		    	<option value="Computador">Computador</option>
		    	<option value="Livro">Livro</option>
		    	</select>
		    	</div>
		    </div>	    	
	    	<div class="form-group">
		    	<label class="control-label col-sm-2" for="descricao">Descrição:</label>
		    	<div class="col-sm-10">
		    		<input type="text" class="form-control" id="descricao" name="descricao" placeholder="Informe a descrição">
		    	</div>
	    	</div>
	    	<div id="camposAdicionais">
	    	</div>
	    	<input type="submit" value="Cadastrar" class="btn btn-primary">
	    	<a href="/produtos" class="btn btn-danger">Cancelar</a>
    	</form>
    </main>    	
</div>
</body>
<script>

function selecionaTipo(valor){
	
	var camposAdicionais = document.getElementById('camposAdicionais');
	
	camposAdicionais.innerHTML = "";
	
	switch(valor){
	
	case 'Bebida':
		camposAdicionais.innerHTML = '<div class="form-group">'
			+'<label class="control-label col-sm-2" for="fabricante">Fabricante:</label>'
			+'<div class="col-sm-10">'
			+'<input type="text" class="form-control" id="fabricante" name="fabricante" placeholder="Informe o fabricante">'
			+'</div>'
			+'</div>'
			+'<div class="form-group">'
			+'<label class="control-label col-sm-2" for="rotulo">Rótulo:</label>'
			+'<div class="col-sm-10">	<input type="text" class="form-control" id="rotulo" name="rotulo" placeholder="Informe o rótulo">'
			+'</div>'
			+'</div>'
			+'<div class="form-group">'
			+'<label class="control-label col-sm-2" for="preco">Preço:</label>'
			+'<div class="col-sm-10">'
			+'<input type="text" class="form-control" id="preco" name="preco" placeholder="Informe o preço">'
			+'</div>'
			+'</div>';			
			break;			
	case 'Computador':
		camposAdicionais.innerHTML = '<div class="form-group">'
			+'<label class="control-label col-sm-2" for="fabricante">Fabricante:</label>'
			+'<div class="col-sm-10">	<input type="text" class="form-control" id="fabricante" name="fabricante" placeholder="Informe o fabricante">'
			+'</div>'
			+'</div>'
			+'<div class="form-group">'
			+'<label class="control-label col-sm-2" for="modelo">Modelo:</label>'
			+'<div class="col-sm-10">'
			+'<input type="text" class="form-control" id="modelo" name="modelo" placeholder="Informe o modelo">'
			+'</div>'
			+'</div>'
			+'<div class="form-group">'
			+'<label class="control-label col-sm-2" for="preco">Preço:</label>'
			+'<div class="col-sm-10">'
			+'<input type="text" class="form-control" id="preco" name="preco" placeholder="Informe o preço">'
			+'</div>'
			+'</div>';
			break;
	case 'Livro':
		camposAdicionais.innerHTML = '<div class="form-group">'
			+'<label class="control-label col-sm-2" for="titulo">Título:</label>'
			+'<div class="col-sm-10">'
			+'<input type="text" class="form-control" id="titulo" name="titulo" placeholder="Informe o título">'
			+'</div>'
			+'</div>'
			+'<div class="form-group">'
			+'<label class="control-label col-sm-2" for="autor">Autor:</label>'
			+'<div class="col-sm-10">'
			+'<input type="text" class="form-control" id="autor" name="autor" placeholder="Informe o autor">'
			+'</div>'
			+'</div>'
			+'<div class="form-group">'
			+'<label class="control-label col-sm-2" for="editora">Editora:</label>'
			+'<div class="col-sm-10">'
			+'<input type="text" class="form-control" id="editora" name="editora" placeholder="Informe a editora">'
			+'</div>'
			+'</div>'
			+'<div class="form-group">'
			+'<label class="control-label col-sm-2" for="anoEdicao">Ano de edição:</label>'
			+'<div class="col-sm-10">'
			+'<input type="text" class="form-control" id="anoEdicao" name="anoEdicao" placeholder="Informe o ano de edição">'
			+'</div>'
			+'</div>'
			+'<div class="form-group">'
			+'<label class="control-label col-sm-2" for="preco">Preço:</label>'
			+'<div class="col-sm-10">'
			+'<input type="text" class="form-control" id="preco" name="preco" placeholder="Informe o preço">'
			+'</div>'
			+'</div>';
			break;	
	default:
		camposAdicionais.innerHTML = "";
	}	
}

</script>

</html>