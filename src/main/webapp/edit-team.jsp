<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Team</title>
</head>
<body>
<form action = "editTeamServlet" method="post">
Club : <input type ="text" name = "club" value= "${teamToEdit.clubName}">
League: <input type = "text" name = "league" value= "${teamToEdit.league}">
City: <input type = "text" name = "city" value= "${teamToEdit.city}">
Country: <input type = "text" name = "country" value= "${teamToEdit.country}">
<input type = "hidden" name = "id" value="${teamToEdit.id}">
<input type = "submit" value="Save Edited Item">
</form>
</body>
</html>