<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br" xml:lang="pt-br">
<head>
	<meta charset="utf-8">
	<title>Projeto Java MVC - Empresas</title>
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
                <li><a href="#" title="Empresas">EMPRESAS</a>  </li>
                <li><a href="/produtos" title="Produtos">PRODUTOS</a>  </li>                
            </ul>
        </nav>        
    </header>
    <main id="principal">
    <h2 class="title">Empresas</h2>
    <p>
    	<a href="/empresa/new" class="btn btn-success">Nova empresa</a>
    </p>
	<table class="table table-hover">
			<thead>
				<tr>					
					<th>Nome</th>
					<th>Endereço</th>
					<th>Nacional</th>
					<th>E-mail</th>
					<th></th>		
				</tr>
			</thead>
			<tbody>				
				<c:forEach var="empresa" items="${listaEmpresas}">								
					<tr>
						<td>${empresa.nome}</td>
						<td>${empresa.endereco}</td>
						<td>
							<c:choose>
								<c:when test="${empresa.nacional == true}">
									Sim
								</c:when>
								<c:when test="${empresa.nacional == false}">
									Não
								</c:when>
							</c:choose>
						</td>
						<td>${empresa.email}</td>
						<td><a href="<c:url value="/empresa/detalhes/${empresa.id}"/>" title="Detalhar Empresa">Detalhes</a> | <a href="<c:url value="/empresa/excluir/${empresa.id}"/>" title="Excluir Empresa">Excluir</a></td>												
					</tr>					
				</c:forEach>
			</tbody>	
		</table>		     
    </main>    
</div>
</body>
</html>