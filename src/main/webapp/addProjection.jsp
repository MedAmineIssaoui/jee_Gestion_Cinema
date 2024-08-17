<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="model.entities.Film" %>
<%@ page import="model.entities.Salle" %>
<%@ page import="model.metier.modelFilm" %>
<%@ page import="model.metier.modelSalle" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter une projection</title>
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="bootstrap.css">
<style>
form {
    width: 70%;
    margin: auto;
    margin-top: 0;
}
</style>
</head>
<body>

<div class="app">
	<jsp:include page="/navbar.jsp" />
	<h1 class="mt-5">Ajouter une projection</h1>
	<form method="post" action="ProjectionServlet?action=add">
		<div>
			<label class="col-form-label mt-4" for="selectFilm">Film</label>
			<select name="id_film" class="form-control" id="selectFilm">
				<%
					List<Film> films = modelFilm.getAll();
					for (Film film : films) {
				%>
					<option value="<%= film.getId() %>"><%= film.getTitre() %></option>
				<%
					}
				%>
			</select>
		</div>
		<div>
			<label class="col-form-label mt-4" for="selectSalle">Salle</label>
			<select name="id_salle" class="form-control" id="selectSalle">
				<%
					List<Salle> salles = modelSalle.getAll();
					for (Salle salle : salles) {
				%>
					<option value="<%= salle.getId() %>"><%= salle.getNom() %></option>
				<%
					}
				%>
			</select>
		</div>
		<div>
			<label class="col-form-label mt-4" for="inputDate">Date</label>
			<input type="datetime-local" name="full_date" class="form-control" id="inputDate">
		</div>
		<div>
			<label class="col-form-label mt-4" for="inputPrix">Prix</label>
			<input type="number" name="prix" step="0.01" class="form-control" id="inputPrix" placeholder="Prix">
		</div>
		<div>
			<label class="col-form-label mt-4" for="inputPlaces">Places Réservées</label>
			<input type="number" name="nbr_reservee" class="form-control" id="inputPlaces" placeholder="Places Réservées">
		</div>
		<button class="btn btn-primary m-auto mt-4" type="submit" value="Ajouter">Ajouter</button>
	</form>
	<%
		String message = "";
		Object addedAttribute = request.getAttribute("added");
		if (addedAttribute != null) {
			if ((boolean) addedAttribute) {
				message = "Projection ajoutée avec succès";
			} else {
				message = "Erreur lors de l'ajout de la projection";
			}
		}
	%>
	<p><%= message %></p>
</div>
</body>
</html>
