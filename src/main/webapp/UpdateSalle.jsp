<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.entities.Salle" %>
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
<jsp:include page="/SalleServlet?action=get&id=${param.id}" />
	<%
		Object salle = request.getAttribute("Salle");
		if(  salle != null ){
			Salle s = (Salle) salle;
			%>
			<fieldset>
				<legend><h1 class="mt-5">Modifier le film d'Id <%= s.getId() %> </h1></legend>
				
				<form method="post" action="SalleServlet?action=edit&id=${param.id}">
					<div>
					  <label class="col-form-label mt-4" for="inputDefault">Nom:</label>
					  <input type="text" class="form-control" name="nom" value="<%= s.getNom() %>" placeholder="Nom de salle" id="inputDefault">
					</div>
					<div>
					  <label class="col-form-label mt-4" for="inputDefault">Capacité</label>
					  <input type="number" name="capacite" class="form-control" value="<%= s.getCapacite() %>" placeholder="Capacité" id="inputDefault">
					</div>
					<button  class="btn btn-primary mt-4" type="submit" value="Modifier">Modifier</button>
				</form>
			</fieldset>
			
			<%
		}else{ 
			%>
			le Salle est n'existe pas :(
		<% } %>
</div>
</body>
</html>