<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="category" method="post">
    <div class="container">
        <h2>Category List</h2>

        <div class="row">
            <label>Select</label>

            <select name="option">
            <c:forEach var="p" items="${requestScope.list}">
                <option value="${p.categoryName}" selected>${p.categoryName}</option>
            </c:forEach>
            </select>
        </div>

        <button type="submit" class="btn">Choose A Category</button>
    </div>
</form>
</body>
</html>