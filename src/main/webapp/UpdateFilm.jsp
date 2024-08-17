<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.entities.Film" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<jsp:include page="/FilmServlet?action=get&id=${param.id}" />
	<%
		Object film = request.getAttribute("Film");
		if(  film != null ){
			Film f = (Film) film;
			%>
			<fieldset>
				<legend><h1  class="mt-5">Modifier le film d'Id <%= f.getId() %> </h1></legend>
				
				<form method="post" action="FilmServlet?action=edit&id=${param.id}">
					<div>
					  <label class="col-form-label mt-4" for="inputDefault">Titre </label>
					  <input type="text" name="titre" value="<%= f.getTitre() %>" class="form-control" placeholder="Titre" id="inputDefault">
					</div>
					<div>
					  <label class="col-form-label mt-4" for="inputDefault">Genre</label>
					  <input type="text" class="form-control" name="genre" value="<%= f.getGenre() %>" placeholder="Genret" id="inputDefault">
					</div>
					<div>
					  <label class="col-form-label mt-4" for="inputDefault">Date de sortie</label>
					  <input type="date" name="date_sortie" value="<%= f.getDate_sortie() %>" class="form-control" placeholder="Date de sortie" id="inputDefault">
					</div>
					<div>
					  <label class="col-form-label mt-4" for="inputDefault">Durée de film</label>
					  <input type="number" name="duree" class="form-control" value="<%= f.getDuree() %>" placeholder="Durée de film" id="inputDefault">
					</div>
					<button  class="btn btn-primary mt-4" type="submit" name="titre" value="Modifier">Modifier</button>
				</form>
			</fieldset>
			
			<%
		}else{ 
			%>
			le Film est n'existe pas :(
		<% } %>
</div>
</body>
</html>