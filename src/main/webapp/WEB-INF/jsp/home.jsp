<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br" xml:lang="pt-br">
<head>
	<meta charset="utf-8">
	<title>Projeto Java MVC</title>	
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
                <li><a href="#" title="Pedidos">PEDIDOS</a></li>
                <li><a href="/empresas" title="Empresas">EMPRESAS</a></li>
                <li><a href="/produtos" title="Produtos">PRODUTOS</a></li>                
            </ul>
        </nav>        
    </header>
    <main id="principal">
    <h2 class="title">Pedidos</h2>
    <p>
    	<a href="/pedido/new" class="btn btn-success">Incluir pedido</a>
    </p>
	    <table class="table table-hover">
			<thead>
				<tr>
					<th>Pedido</th>
					<th>Cliente</th>
					<th>Status</th>
					<th>Valor</th>
					<th></th>		
				</tr>
			</thead>
			<tbody>	
				<c:forEach var="ped" items="${Lista}">
					<tr>
						<td>${ped.descricao}</td>
						<td>${ped.empresa.nome}</td>
						<td>
							<c:choose>
								<c:when test="${ped.entregue == true}">
									Entregue
								</c:when>
								<c:when test="${ped.entregue == false}">
									A caminho
								</c:when>
							</c:choose>
						</td>
						<td>${ped.valor}</td>
						<td><a href="<c:url value="/pedido/detalhes/${ped.id}"/>" title="Detalhes do pedido"> Detalhes</a> | <a href="<c:url value="/pedido/excluir/${ped.id}"/>">Excluir</a></td>						
					</tr>					
				</c:forEach>
			</tbody>	
		</table>    
    </main>	
</div>
</body>
</html>