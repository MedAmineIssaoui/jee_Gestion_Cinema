<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.entities.Film" %>



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
<jsp:include page="/FilmServlet?action=list" />

<div class="app">
	<jsp:include page="/navbar.jsp" />
	<h1 class="mt-5">
		Liste de toutes les films
		<a href="addFilm.jsp"><button type="button" class="btn btn-success">Ajouter un film</button></a>
	</h1>

	<table class="table table-hover mt-4">
		<thead>
			<tr>
				<th class="text-center" scope="col">ID</th>
				<th class="text-center" scope="col">Titre</th>
				<th class="text-center" scope="col">Genre</th>
				<th class="text-center" scope="col">DateSortie</th>
				<th class="text-center" scope="col">Duree</th>
				<th  colspan="3"><th>
			</tr>
		</thead>
		<tbody>
			<% 
		        ArrayList<Film> films = (ArrayList<Film>) request.getAttribute("Films");
		        if (films != null) {
		            for (Film f : films) {
		        %>
		        <tr class="table-active" >
		            <td class="text-center" scope="row">
		            	<strong><%= f.getId() %></strong>	
		            </td>
		            <td class="text-center">
		            	<%= f.getTitre() %>
		            </td>
		            <td class="text-center">
		            	<%= f.getGenre() %>
		            </td>
		            <td class="text-center">
		            	<%= f.getDate_sortie() %>
		            </td>
		            <td class="text-center">
		            	<%= f.getDuree() %> Minutes
		            </td>
		            <td><a href="#"><button type="button" class="btn btn-info">Afficher</button></a></td>
		            <td><a href="UpdateFilm.jsp?id=<%= f.getId() %>"><button type="button" class="btn btn-primary">Modifier</button></a></td>
		            <td><a href="FilmServlet?action=delete&id=<%= f.getId() %>">
							<button type="button" class="btn btn-danger">Supprimer</button>
					</a></td>
		        </tr>
		        <% 
		            }
		        } else {
		        %>
		        <tr>
		            <td colspan="5">Aucun film trouvé.</td>
		        </tr>
		        <% } %>
		</tbody>
	</table>
</div>
</body>
</html>