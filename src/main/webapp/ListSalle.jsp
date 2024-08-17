<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.entities.Salle" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="bootstrap.css">
<style type="text/css">
	h1{
		display:flex;
		justify-content:space-between;
	}
</style>
</head>

<body>
<jsp:include page="/SalleServlet?action=list" />

<div class="app">
	<jsp:include page="/navbar.jsp" />
	<h1 class="mt-5">
		Liste de toutes les Salle
		<a href="addSalle.jsp"><button type="button" class="btn btn-success">Ajouter une Salle</button></a>
	</h1>

	<table class="table table-hover mt-4">
		<thead>
			<tr>
				<th class="text-center" scope="col">ID</th>
				<th class="text-center" scope="col" colspan="2">Nom de salle</th>
				<th class="text-center" scope="col" colspan="2">Capacité</th>
				<th colspan="3"><th>
			</tr>
		</thead>
		<tbody>
			<% 
		        ArrayList<Salle> salles = (ArrayList<Salle>) request.getAttribute("Salles");
		        if (salles != null) {
		            for (Salle s :salles) {
		        %>
		        <tr class="table-active">
		            <td class="text-center" scope="row"><%= s.getId() %></td>
		            <td class="text-center" colspan="2"><%= s.getNom() %></td>
		            <td class="text-center"  colspan="2"><%= s.getCapacite() %></td>
		            <td class="text-center">
		            	<a href="#">
		            		<button type="button" class="btn btn-info">Afficher</button>
		            	</a>
		            </td>
		            <td class="text-center">
		            	<a href="UpdateSalle.jsp?id=<%= s.getId() %>">
		            		<button type="button" class="btn btn-primary">Modifier</button></a>
		            	</td>
		            <td class="text-center">
		            	<a href="SalleServlet?action=delete&id=<%= s.getId() %>">
							<button type="button" class="btn btn-danger">Supprimer</button>
						</a>
					</td>
		        </tr>
		        <% 
		            }
		        } else {
		        %>
		        <tr>
		            <td colspan="6">Aucun Salle trouvé.</td>
		        </tr>
		        <% } %>
		</tbody>
	</table>
</div>
</body>
</html>