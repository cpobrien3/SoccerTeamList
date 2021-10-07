<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Division List</title>
</head>
<h1>Divisions</h1>
<body>
<form method = "post" action = "divisionNavigationServlet">
<table>
<c:forEach items="${requestScope.allLists}" var="currentlist">
<tr>
 <td><input type="radio" name="id" value="${currentlist.id}"></td>
 <tr><td colspan="3">${currentlist.getDivision()}</td></tr>
 <c:forEach var = "listVal" items = "${currentlist.listOfTeams}">
 <tr><td></td><td colspan="3">
 ${listVal.clubName}, ${listVal.league}, ${listVal.city}, ${listVal.country}
 </td>
 </tr>
 </c:forEach>
</c:forEach>
</table>
<input type = "submit" value = "delete" name="doThisToList">
<input type="submit" value = "add" name = "doThisToList">
</form>
<a href="addDivisionsServlet">Create a new Division</a>
<a href="index.html">Insert a new item</a>
</body>
</body>
</html>