<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Result of adding pizza</title>
</head>
<body>

<h2>Pizza information</h2>
<table>
    <tr>
        <td>Name :</td>
        <td>${name}</td>
    </tr>
    <tr>
        <td>ID :</td>
        <td>${id}</td>
    </tr>
    <tr>
        <td>Price :</td>
        <td>${price}</td>
    </tr>
    <tr>
        <td>Diameter :</td>
        <td>${diameter}</td>
    </tr>
</table>
</body>
</html>