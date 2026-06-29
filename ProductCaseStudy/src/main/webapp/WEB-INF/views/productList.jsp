<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List</title>
</head>
<body>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Stock</th>
    </tr>

    <c:forEach var="p" items="${requestScope.list}">
        <tr>
            <td>${p.product_id}</td>
            <td>${p.product_name}</td>
            <td>${p.price}</td>
            <td>${p.stock}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>