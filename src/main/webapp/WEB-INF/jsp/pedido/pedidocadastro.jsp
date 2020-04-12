<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br" xml:lang="pt-br">
<head>
	<meta charset="utf-8">
	<title>Projeto Java MVC - Novo Pedido</title>
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
    <h2 class="title">Novo Pedido</h2>
    	<form class="form-horizontal" action="/pedido/new" method="post">
	    	<div class="form-group">
		    	<label class="control-label col-sm-2" for="empresa">Empresa:</label>
		    	<div class="col-sm-10">
		    	<select class="form-control" id="empresa" name="empresaId">		    	
		    	<option value="" selected></option>
		    	<c:forEach var="emp" items="${empresas}">
		    	<option value="${emp.id}">${emp.nome}</option>
		    	</c:forEach>		    	
		    	</select>
		    	</div>
		    </div>
		    <input type="hidden" id="descricao" name="descricao" value="Pedido ${numNovoPedido}">
		    <div id="itens">
		    <div class="form-group" id="item 1">
		    	<label class="control-label col-sm-2">Item:</label>
		    	<div class="col-sm-4" id="clonado">
		    	<select class="form-control" id="item1" name="produtosId">		    	
		    	<option value="" selected></option>
		    	<c:forEach var="prod" items="${produtos}">
		    	<option value="${prod.id}">${prod.descricao} | R$ ${prod.preco}</option>
		    	</c:forEach>		    	
		    	</select>
		    	</div>
		    	<label class="control-label col-sm-2" for="quantidade">Quantidade:</label>
		    	<div class="col-sm-2">
		    		<input type="number" class="form-control" id="quantidade" name="prodQuantidade" placeholder="Quantidade">
		    	</div>
		    	<input type="button" onclick="novoItem()" class="btn btn-success" value="+Item">		    	
		    </div>
		    </div>		    
		    	    	
	    	<div class="form-group">
		    	<label class="control-label col-sm-2" for="descricao">Observacao:</label>
		    	<div class="col-sm-10">
		    		<input type="text" class="form-control" id="observacao" name="observacao" placeholder="Observação">
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

var novo = 2;

function novoItem(){
	
	var $itens = document.querySelector('#itens');
	
	var $item01 = document.getElementById('clonado');
	
	var $itemNovo = $item01.cloneNode(true);
	
	$itemNovo.setAttribute('id', novo);
	
	incluir = '<div class="form-group" id="'+novo+'">'
			  +'<label class="control-label col-sm-2">Item:</label>'
			  +'<div class="col-sm-4">'
			  +$item01.innerHTML
			  +'</div>'
				+'<label class="control-label col-sm-2" for="quantidade">Quantidade:</label>'
				+'<div class="col-sm-2">'
				+'<input type="number" class="form-control" id="quantidade" name="prodQuantidade" placeholder="Quantidade">'
				+'</div>'
				+'<input type="button" onclick="novoItem()" class="btn btn-success" value="+Item">'				
				+'<input style="margin-left:8px" type="button" onclick="excluirItem('+novo+')" class="btn btn-danger" value="X">'				
				+'</div>';
	
	$itens.insertAdjacentHTML('beforeend', incluir);
	novo++;
}

function excluirItem(botao){
	
	var removeBotao = document.getElementById(botao);
	removeBotao.remove();
}

</script>

</html>