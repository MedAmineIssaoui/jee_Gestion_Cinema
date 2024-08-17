<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.entities.Projection" %>
<%@ page import="model.entities.Film" %>
<%@ page import="model.entities.Salle" %>
<%@ page import="model.metier.modelFilm" %>
<%@ page import="model.metier.modelSalle" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifier la projection</title>
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
	<jsp:include page="/ProjectionServlet?action=get&id_projection=${param.id_projection}" />
	<%
		Object projection = request.getAttribute("projection");
		if(projection != null) {
			Projection p = (Projection) projection;
			List<Film> films = modelFilm.getAll();
			List<Salle> salles = modelSalle.getAll();
	%>
			<fieldset>
				<legend><h1 class="mt-5">Modifier la projection d'Id <%= p.getId_projection() %></h1></legend>
				<form method="post" action="ProjectionServlet?action=edit&id_projection=${param.id_projection}">
					<div>
						<label class="col-form-label mt-4" for="selectFilm">Film</label>
						<select name="id_film" class="form-control" id="selectFilm">
							<%
								for (Film film : films) {
							%>
								<option value="<%= film.getId() %>" <%= (film.getId() == p.getFilm().getId()) ? "selected" : "" %>><%= film.getTitre() %></option>
							<%
								}
							%>
						</select>
					</div>
					<div>
						<label class="col-form-label mt-4" for="selectSalle">Salle</label>
						<select name="id_salle" class="form-control" id="selectSalle">
							<%
								for (Salle salle : salles) {
							%>
								<option value="<%= salle.getId() %>" <%= (salle.getId() == p.getSalle().getId()) ? "selected" : "" %>><%= salle.getNom() %></option>
							<%
								}
							%>
						</select>
					</div>
					<div>
						<label class="col-form-label mt-4" for="inputDate">Date</label>
						<input type="datetime-local" name="full_date" value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm").format(p.getFull_date()) %>" class="form-control" id="inputDate">
					</div>
					<div>
						<label class="col-form-label mt-4" for="inputPrix">Prix</label>
						<input type="number" name="prix" step="0.01" value="<%= p.getPrix() %>" class="form-control" id="inputPrix" placeholder="Prix">
					</div>
					<div>
						<label class="col-form-label mt-4" for="inputPlaces">Places Réservées</label>
						<input type="number" name="nbr_reservee" value="<%= p.getNbr_reservee() %>" class="form-control" id="inputPlaces" placeholder="Places Réservées">
					</div>
					<button class="btn btn-primary mt-4" type="submit">Modifier</button>
				</form>
			</fieldset>
	<%
		} else {
	%>
		<p>La projection n'existe pas :(</p>
	<% } %>
</div>
</body>
</html>
