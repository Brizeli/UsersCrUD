<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add user</title>
</head>
<body>
<center>
    <br><br><br><br>
    <form action="addUser">
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>Age:</td>
                <td><input type="number" name="age"></td>
            </tr>
            <tr>
                <td>Admin:</td>
                <td><input type="checkbox" name="isAdm"></td>
            </tr>
        </table>
        <button type="submit">Add</button>
    </form>
    ${result}
    <form action="home">
        <button type="submit">Home</button>
    </form>
</center>
</body>
</html>
