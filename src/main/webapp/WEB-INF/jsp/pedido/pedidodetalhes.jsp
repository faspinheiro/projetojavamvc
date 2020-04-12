<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br" xml:lang="pt-br">
<head>
	<meta charset="utf-8">
	<title>Projeto Java MVC - Pedido ${pedido.descricao}</title>
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
    <h2 class="title">Detalhes do pedido ${pedido.descricao} - <c:choose>
								<c:when test="${pedido.entregue == true}">
									Entregue
								</c:when>
								<c:when test="${pedido.entregue == false}">
									A caminho
								</c:when>
							</c:choose> </h2>
	<table class="table table-hover">
			<thead>
				<tr>
					<th>Item</th>
					<th>Descrição</th>
					<th>Quantidade</th>
					<th>Preço</th>
					<th>Valor do Item</th>
					<th></th>		
				</tr>
			</thead>
			<tbody>
				<c:set var="cont" value="0"></c:set>	
				<c:forEach var="item" items="${pedido.itens}">
				<c:set var="cont" value="${cont + 1}"></c:set>				
					<tr>
						<td><a href="<c:url value="/itempedido/${item.id}"/>" title="Detalhar item"> ${cont}</a></td>
						<td><a href="<c:url value="/itempedido/${item.id}"/>" title="Detalhar item"> ${item.produto.descricao}</a></td>
						<td>${item.quantidade}</td>
						<td>${item.produto.preco}</td>
						<td>${item.valor}</td>												
					</tr>					
				</c:forEach>
			</tbody>	
		</table>
		<a href="/pedidos"class="btn btn-danger">Voltar</a>     
    </main>    	
</div>
</body>
</html>