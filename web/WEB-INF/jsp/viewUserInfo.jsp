<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>User info</title>
</head>
<body>
<center>
    <h3>User info</h3>
    <form action="updateUser">
        <c:set var="user" value="${user}"/>
        <c:if test="${user.admin==true}">
            <c:set var="admin" value="checked"/>
        </c:if>
        <table>
            <tr>
                <td>Id</td>
                <td><input type="text" name="userId" readonly value="${user.id}"></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="userName" value="${user.name}"></td>
            </tr>
            <tr>
                <td>Age</td>
                <td><input type="number" name="userAge" value="${user.age}"></td>
            </tr>
            <tr>
                <td>Admin</td>
                <td><input type="checkbox" name="userAdmin" ${admin}></td>
            </tr>
            <tr>
                <td>Created date</td>
                <td>${user.createdDate}</td>
            </tr>
        </table>
        <button type="submit" name="action" value="update">Update</button>
        <button type="submit" name="action" value="delete">Delete</button>
    </form>
    ${result}<br>
    <a href="home">Home</a>
</center>
</body>
</html>
