<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Liste des clients</title>
		<%@include file="commons/header.jsp" %>
	</head>
	<body>
		<div class="container">
			<%@include file="commons/menu.jsp" %>
			
			<h1>Liste des clients</h1>
			
			<table>
				<thead>
		          <tr>
		              <th>Nom</th>
		              <th>Adresse</th>
		          </tr>
		        </thead>
		        
        		<tbody>
				<c:if test="${listClients.isEmpty()}">
					<td>Aucun client !</td>
				</c:if>
				<c:if test="${!listClients.isEmpty()})">
					<c:forEach var="client" items="${listClients}">
						<tr>
							<td><c:out value="${client.nom}"></c:out></td>
							<td><c:out value="${client.adresse}"></c:out></td>
						</tr>
					</c:forEach>
				</c:if>
				</tbody>
			</table>
			
			<a class="waves-effect waves-light btn" href="clients?action=create">Ajouter un client</a>
			
		</div>
		
	</body>
</html>