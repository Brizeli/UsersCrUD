<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Show users</title>
</head>
<body>
<table border="1">
    <th>ID</th>
    <th>Name</th>
    <th>Age</th>
    <th>Admin</th>
    <th>Created Date</th>
    <c:forEach items="${userList}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>${user.admin}</td>
            <td>${user.createdDate}</td>
            <td><a href="getInfo?userId=${user.id}">Info</a></td>
        </tr>
    </c:forEach>
</table>
<table>
    <c:if test="${currentPage != 1}">
        <td><a href="searchUsers?page=${currentPage - 1}&userName=${userName}">Previous</a></td>
    </c:if>
    <td><a href="home">Home</a></td>
    <c:if test="${currentPage lt noOfPages}">
        <td><a href="searchUsers?page=${currentPage + 1}&userName=${userName}">Next</a></td>
    </c:if>
</table>
</body>
</html>
