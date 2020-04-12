<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br" xml:lang="pt-br">
<head>
	<meta charset="utf-8">
	<title>Projeto Java MVC - ${produto.descricao}</title>
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
    <h2 class="title">${produto.descricao}</h2>
    	<dl class="dl-horizontal">
    		<dt>Tipo:</dt>
    		<dd>${produto.tipoProduto}</dd>
    		<dt>Descrição:</dt>
    		<dd>${produto.descricao}</dd>
	    	<c:forEach var="key" items="${camposProduto.keySet()}">
	    	<dt>${key}</dt>
	    	<dd>${camposProduto.get(key)}</dd>
	    	</c:forEach>
	    	<dt>Preço:</dt>
	    	<dd>${produto.preco}</dd>    		
    	</dl>    	
    		<a href="/produtos"class="btn btn-danger">Voltar</a>
    </main>   	
</div>
</body>
</html>