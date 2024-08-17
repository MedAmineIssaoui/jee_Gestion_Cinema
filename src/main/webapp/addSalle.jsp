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
	<h1 class="mt-5">Ajouter une salle</h1>
	<form method="post" action="SalleServlet?action=add">
		<div>
		  <label class="col-form-label mt-4" for="inputDefault">Nom de salle</label>
		  <input type="text" name="nom" class="form-control" placeholder="Nom de salle" id="inputDefault">
		</div>
		<div>
		  <label class="col-form-label mt-4" for="inputDefault">Capacité</label>
		  <input type="number" name="capacite" class="form-control"  placeholder="Capacite" id="inputDefault">
		</div>
		<button  class="btn btn-primary m-auto mt-4 " type="submit" name="titre" value="Ajouter">Ajouter</button>
	</form>
	<%
		String message ="";
		Object addedAttribute = request.getAttribute("added");
		if(  addedAttribute != null ){
			if( ((boolean) addedAttribute) == true){
				message = "Salle est ajouter avec succées";
			}else {
				message = "Errorr!";
			}
		}
	%>
	<%= message %>
</div>
</body>
</html>