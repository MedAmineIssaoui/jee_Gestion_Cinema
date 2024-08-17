<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<h1 class="mt-5">Ajouter un film</h1>
	<form method="post" action="FilmServlet?action=add">
		<div>
					  <label class="col-form-label mt-4" for="inputDefault">Titre </label>
					  <input type="text" name="titre" class="form-control" placeholder="Titre" id="inputDefault">
					</div>
					<div>
					  <label class="col-form-label mt-4" for="inputDefault">Genre</label>
					  <input type="text" class="form-control" name="genre"placeholder="Genret" id="inputDefault">
					</div>
					<div>
					  <label class="col-form-label mt-4" for="inputDefault">Date de sortie</label>
					  <input type="date" name="date_sortie" class="form-control" placeholder="Date de sortie" id="inputDefault">
					</div>
					<div>
					  <label class="col-form-label mt-4" for="inputDefault">Durée de film</label>
					  <input type="number" name="duree" class="form-control"  placeholder="Durée de film" id="inputDefault">
					</div>
					<button  class="btn btn-primary m-auto mt-4 " type="submit" name="titre" value="Ajouter">Ajouter</button>
	</form>
	<%
		String message ="";
	Object addedAttribute = request.getAttribute("added");
		if(  addedAttribute != null ){
			if( ((boolean) addedAttribute) == true){
				message = "Film est ajouter avec succées";
			}else {
				message = "Film est ajouter avec succées";
			}
		}
	%>
	<%= message %>
</div>
</body>
</html>