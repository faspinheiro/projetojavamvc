<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br" xml:lang="pt-br">
<head>
	<meta charset="utf-8">
	<title>Projeto Java MVC - Cadastrar Empresa</title>
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
    <h2 class="title">Cadastro de empresa</h2>
    	<form class="form-horizontal" action="/empresa/new" method="post">
	    	<div class="form-group">
		    	<label class="control-label col-sm-2" for="nome">Nome:</label>
		    	<div class="col-sm-10">
		    		<input type="text" class="form-control" id="nome" name="nome" placeholder="Informe o nome">
		    	</div>
	    	</div>
	    	<div class="form-group">
	    		<label class="control-label col-sm-2" for="email">E-mail:</label>
	    		<div class="col-sm-10">
	    			<input type="email" class="form-control" id="email" name="email" placeholder="Informe o e-mail">
	    		</div>
	    	</div>
	    	<div class="form-group">
	    		<label class="control-label col-sm-2" for="endereco">Endereco:</label>
	    		<div class="col-sm-10">
	    			<input type="text" class="form-control" id="endereco" name="endereco" placeholder="Informe o endereço">
	    		</div>
	    	</div>
	    	<div class="form-group">	    	
	    		<div class="col-sm-offset-2 col-sm-10">
	    			<div class="checkbox">
	    			<label><input type="checkbox" id="nacional" name="nacional" value="true">Nacional</label>
	    			</div>
	    		</div>
	    	</div>
	    	<input type="submit" value="Cadastrar" class="btn btn-primary">
	    	<a href="/empresas" class="btn btn-danger">Cancelar</a>
    	</form>
    </main>    	
</div>
</body>
</html>