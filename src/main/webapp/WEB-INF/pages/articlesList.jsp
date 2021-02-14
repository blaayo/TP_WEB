<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Liste des articles</title>
		<%@include file="commons/header.jsp" %>
	</head>
	<body>
		<div class="container">
			<%@include file="commons/menu.jsp" %>
			
			<h1>Liste des articles</h1>
			
			<table>
				<thead>
		          <tr>
		              <th>N°</th>
		              <th>nom du produit</th>
		              <th>prix</th>
		          </tr>
		        </thead>
				<c:forEach var="article" items="${listArticles}" >
				  <tr>
				      <td><c:out value="${article.codeBarre}"></c:out></td>
   				      <td><c:out value="${article.nom}"></c:out></td>
   				      <td><c:out value="${article.prix}"></c:out></td>
				  </tr>
				</c:forEach>
			</table>
			
			<a class="waves-effect waves-light btn" href="articles?action=create">Ajouter un article </a>
			
		</div>
		
	</body>
</html>