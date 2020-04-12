<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br" xml:lang="pt-br">
<head>
	<meta charset="utf-8">
	<title>Projeto Java MVC - ${empresa.nome}</title>
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
    <h2 class="title">${empresa.nome}</h2>
    	<dl class="dl-horizontal">
    		<dt>Nome:</dt>
    		<dd>${empresa.nome}</dd>
    		<dt>Endereço:</dt>
    		<dd>${empresa.endereco}</dd>
    		<dt>E-mail:</dt>
    		<dd>${empresa.email}</dd>
    		<dt>Nacional:</dt>
    		<dd>
    		<c:choose>
				<c:when test="${empresa.nacional == true}">
					Sim
				</c:when>
				<c:when test="${empresa.nacional == false}">
					Não
				</c:when>
			</c:choose>    		
    		</dd>
    	</dl>    	
    		<a href="/empresas"class="btn btn-danger">Voltar</a>
    </main>    	
</div>
</body>
</html>