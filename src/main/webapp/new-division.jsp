<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a new Division</title>
</head>
<h1>New Division</h1>
<body>
<form action = "createNewListServlet" method="post">
List Name: <input type ="text" name = "listName"><br />

Division Name: <input type = "text" name = "divisionName"><br />
Available Teams:<br />
<select name="allItemsToAdd" multiple size="6">
<c:forEach items="${requestScope.allItems}" var="currentitem">
 <option value = "${currentitem.id}">${currentitem.clubName} | 
${currentitem.league}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value="Create List and Add Teams">
</form>
<a href = "index.html">Go add new teams instead.</a>
</body>
</body>
</html>