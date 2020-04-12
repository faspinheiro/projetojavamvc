<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br" xml:lang="pt-br">
<head>
	<meta charset="utf-8">
	<title>Projeto Java MVC - Produtos</title>
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
                <li><a href="/empresas" title="Clientes">EMPRESAS</a>  </li>
                <li><a href="#" title="Produtos">PRODUTOS</a>  </li>                
            </ul>
        </nav>        
    </header>
    <main id="principal">
    <h2 class="title">Produtos</h2>
    <p>
    	<a href="/produto/new" class="btn btn-success">Novo produto</a>
    </p>
	<table class="table table-hover">
			<thead>
				<tr>					
					<th>Tipo de Produto</th>
					<th>Descrição</th>
					<th>Preço</th>					
					<th></th>		
				</tr>
			</thead>
			<tbody>				
				<c:forEach var="produto" items="${listaProdutos}">								
					<tr>
						<td>${produto.tipoProduto}</td>
						<td>${produto.descricao}</td>
						<td>${produto.preco}</td>
						<td><a href="<c:url value="/produto/detalhes/${produto.id}"/>" title="Detalhes do Produto">Detalhes</a> | <a href="<c:url value="/produto/excluir/${produto.id}"/>" title="Excluir produto">Excluir</a></td>												
					</tr>					
				</c:forEach>
			</tbody>	
		</table>     
    </main>    
</div>
</body>
</html>