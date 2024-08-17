<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.entities.Projection" %>
<%@ page import="model.entities.Film" %>
<%@ page import="model.entities.Salle" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des Projections</title>
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
<div class="app">
	<jsp:include page="/navbar.jsp" />
	<h1 class="mt-5">
		Liste de toutes les projections
		<a href="addProjection.jsp"><button type="button" class="btn btn-success">Ajouter une projection</button></a>
	</h1>

	<table class="table table-hover mt-4">
		<thead>
			<tr>
				<th class="text-center" scope="col">ID</th>
				<th class="text-center" scope="col">Film</th>
				<th class="text-center" scope="col">Salle</th>
				<th class="text-center" scope="col">Date</th>
				<th class="text-center" scope="col">Prix</th>
				<th class="text-center" scope="col">Places Réservées</th>
				<th colspan="3" class="text-center">Actions</th>
			</tr>
		</thead>
		<tbody>
			<% 
		        ArrayList<Projection> projections = (ArrayList<Projection>) request.getAttribute("projections");
		        if (projections != null) {
		            for (Projection p : projections) {
		        %>
		        <tr class="table-active" >
		            <td class="text-center" scope="row">
		            	<strong><%= p.getId_projection() %></strong>	
		            </td>
		            <td class="text-center">
		            	<%= p.getFilm().getTitre() %>
		            </td>
		            <td class="text-center">
		            	<%= p.getSalle().getNom() %>
		            </td>
		            <td class="text-center">
		            	<%= p.getFull_date() %>
		            </td>
		            <td class="text-center">
		            	<%= p.getPrix() %> 
		            </td>
		            <td class="text-center">
		            	<%= p.getNbr_reservee() %>
		            </td>
		            <td><a href="ProjectionServlet?action=get&id_projection=<%= p.getId_projection() %>"><button type="button" class="btn btn-info">Afficher</button></a></td>
		            <td><a href="UpdateProjection.jsp?id_projection=<%= p.getId_projection() %>"><button type="button" class="btn btn-primary">Modifier</button></a></td>
		            <td><a href="ProjectionServlet?action=delete&id_projection=<%= p.getId_projection() %>">
							<button type="button" class="btn btn-danger">Supprimer</button>
					</a></td>
		        </tr>
		        <% 
		            }
		        } else {
		        %>
		        <tr>
		            <td colspan="9">Aucune projection trouvée.</td>
		        </tr>
		        <% } %>
		</tbody>
	</table>
</div>
</body>
</html>
