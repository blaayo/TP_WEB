<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Liste des factures</title>
		<%@include file="commons/header.jsp" %>
	</head>
	<body>
		<div class="container">
			<%@include file="commons/menu.jsp" %>
			
			<h1>Liste des factures</h1>
			
			<table>
				<thead>
		          <tr>
		              <th>N°</th>
		              <th>date</th>
		              <th>client</th>
		              <th>prix</th>
		          </tr>
		        </thead>
			 
				<c:if test="${listFactures.isEmpty()}">
					<td>Pas de factures</td>
				</c:if>
				<c:if test="${!listFactures.isEmpty()}">
					<c:forEach var="facture" items="${listFactures}">
						<tr>
							<td>FC-1</td>
							<td><c:out value="${facture.date}"></c:out></td>
							<td><c:out value="${facture.client.nom}"></c:out></td>
							<td><c:out value="${facture.prix}"></c:out></td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
			
		</div>
		
	</body>
</html>