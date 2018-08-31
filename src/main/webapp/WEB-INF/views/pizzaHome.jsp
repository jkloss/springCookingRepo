<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<h3>Welcome in adding pizza page</h3>
<form:form method="post" action="/java/com/cooking/cook/controllers/addPizza" modelAttribute="pizza">
    <p>ID: <input type="text", value="id"></p>
    <p>Name: <input type="text", value="name"></p>
    <p>Price: <input type="text", value="price"></p>
    <p>Diameter: <input type="text", value="diameter"></p>
</form:form>
</body>
</html>