<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Nouveau articles !</title>
	    <%@include file="commons/header.jsp" %>
	</head>
	
	<body>
		<div class="container">
		<%@include file="commons/menu.jsp" %>
		<h1>Formulaire de création d'article</h1>
		
		<form action="articles" method="post">
		  <label for="nameArticle">Nom</label>
		  <input type="text" name="nameArticle">
		  <label for="nameArticle">Code Barre</label>
		  <input type="text" name="nameCodeBarre">
		  <label for="priceArticle">Prix</label>
		  <input type="number" name="priceArticle">
		  <input type="hidden" value="formCreate" name="actionPost"/>
		  
		  <!-- Submit buton -->
		  <input type="submit" value="Valider"/>
		</form>
		</div>
	
	</body>
</html>